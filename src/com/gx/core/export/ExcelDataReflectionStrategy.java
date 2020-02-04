package com.gx.core.export;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataReflectionStrategy implements ExcelDataStrategy {
    /**
     * 获取用于导出的dataMap数据
     *
     * @param beanList 导出的list
     * @param metaMap  导出项的元信息
     * @return
     */
    @Override
    public Map<String, Object> getExcelDataMap(List beanList, Map<String, Object> metaMap) {
        Class clazz = (Class) metaMap.get("clazz");//类对象
        String[] columnNames = (String[]) metaMap.get("columnNames");//导出项的字段名

        Map<String, Object> stringObjectMap = ReflectionUtil.getExportColumnComment(clazz, columnNames);
        String[] columnComments = (String[]) stringObjectMap.get("columnComment");
        Integer[] excelHeaderWidth = (Integer[]) stringObjectMap.get("columnWidth");//列宽
        String[] validColumnName = (String[]) stringObjectMap.get("columnName");//实际导出的字段：经过校验的（如果需要导出项都为0或者空，则需要导出全部项目）

        Map<Integer, List<String>> dataMap = new HashMap<>();
        for (int i = 0; i < beanList.size(); i++) {
            Object obj = beanList.get(i);
            List<String> list = dataMap.get((i + 1));
            if (list == null) {
                list = new ArrayList<>();
                dataMap.put((i + 1), list);
            }

            for (int m = 0; m < validColumnName.length; m++) {
                String columnName = validColumnName[m];
                Object columnValue = ReflectionUtil.getValue(clazz, obj, columnName);
                list.add(StringUtils.isEmpty(columnValue) ? "" : columnValue.toString());
            }

        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", dataMap);
        resultMap.put("columnComment", columnComments);
        resultMap.put("columnWidth", excelHeaderWidth);
        return resultMap;
    }


}
