package com.gx.core.export;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 普通的数据
 */
public class ExcelDataNormalStrategy implements ExcelDataStrategy {

    /**
     * 获取用于导出的dataMap数据
     *
     * @param beanList 导出的list
     * @param metaMap  导出项的元信息
     * @return
     */
    public Map<String, Object> getExcelDataMap(List beanList, Map<String, Object> metaMap) {
        String[] columnName = (String[]) metaMap.get("columnName");//顺序key
        String[] columnComments = (String[]) metaMap.get("columnComment");
        Integer[] excelHeaderWidth = (Integer[]) metaMap.get("columnWidth");//列宽
        com.alibaba.fastjson.JSONArray jsonArray = new com.alibaba.fastjson.JSONArray(beanList);

        Map<Integer, List<String>> dataMap = new HashMap<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            List<String> list = dataMap.get((i + 1));
            if (list == null) {
                list = new ArrayList<>();
                dataMap.put((i + 1), list);
            }
            for (String key : columnName) {
                Object value = object.get(key);
                list.add(StringUtils.isEmpty(value) ? "" : value.toString());
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", dataMap);
        resultMap.put("columnComment", columnComments);
        resultMap.put("columnWidth", excelHeaderWidth);
        return resultMap;
    }

}

