package com.gx.core.export;



import java.lang.reflect.Method;
import java.util.*;

public class ReflectionUtil {
    /**
     * 获取某个字段的值
     *
     * @param clazz
     * @param obj
     * @param columName
     * @return
     */
    public static Object getValue(Class clazz, Object obj, String columName) {
        try {
            if (StringUtils.isEmpty(columName)) {
                return null;
            }

            String getMethodName = getterMethodName(clazz, columName);

            return clazz.getMethod(getMethodName).invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取某个类的导出列名
     *
     * @param clazz 需要导出的类信息
     * @return columnName列名字段名，columnComment列名显示，columnWidth列宽度
     */
    public static Map<String, Object> getExportColumns(Class clazz) {
        ExportBean exportBean = (ExportBean) clazz.getAnnotation(ExportBean.class);

        String[] columnComment = exportBean.columnComment();
        String[] columnName = exportBean.columnName();
        int[] columnWidth = exportBean.columnWidth();
        if (columnComment != null && columnComment.length > 0 && columnName != null && columnName.length > 0) {
            Map<String, Object> columnsMap = new HashMap<>();
            columnsMap.put("columnName", columnName);//类中对应字段
            columnsMap.put("columnComment", columnComment);//需要在Excel中显示的列名
            columnsMap.put("columnWidth", columnWidth);//列宽度
            return columnsMap;
        }
        return null;
    }

    /**
     * 查找列字段名在类注解中对应的中文名称、列宽数组
     *
     * @param clazz         类对象
     * @param columnNameTar 列名（英文名）
     * @return
     */
    public static Map<String, Object> getExportColumnComment(Class clazz, String[] columnNameTar) {
        Map<String, Object> stringObjectMap = getExportColumns(clazz);

        if (stringObjectMap == null) {
            return null;
        }
        String[] columnNamesSrc = (String[]) stringObjectMap.get("columnName");
        String[] columnComments = (String[]) stringObjectMap.get("columnComment");
        int[] columnWidths = (int[]) stringObjectMap.get("columnWidth");
        List<String> columnCommentList = new ArrayList<>();
        List<Integer> columnWidthList = new ArrayList<>();

        String[] columnCommentArr;
        Integer[] columnWidthArr;
        String[] columnNameArr;
        if (columnNameTar != null && columnNameTar.length > 0) {
            for (int i = 0; i < columnNameTar.length; i++) {
                for (int j = 0; j < columnNamesSrc.length; j++) {
                    if (columnNameTar[i].equals(columnNamesSrc[j])) {
                        columnCommentList.add(columnComments[j]);
                        columnWidthList.add(columnWidths[j]);
                        break;
                    }
                }
            }

            columnCommentArr = columnCommentList.toArray(new String[0]);
            columnWidthArr = columnWidthList.toArray(new Integer[0]);
            columnNameArr = columnNameTar;
        } else {//如果导出项目为0或者为空，则导出全部项目
            columnCommentArr = columnComments;
            columnWidthArr = (Integer[]) Arrays.asList(columnWidths).toArray();
            columnNameArr = columnNamesSrc;
        }

        stringObjectMap.put("columnComment", columnCommentArr);
        stringObjectMap.put("columnWidth", columnWidthArr);
        stringObjectMap.put("columnName", columnNameArr);

        return stringObjectMap;
    }

    /**
     * 获取getter方法名称：用于状态字段的默认get方法
     *
     * @param clazz
     * @param columnName
     * @return
     */
    private static String getterMethodName(Class clazz, String columnName) {
        try {
            if (StringUtils.isEmpty(columnName)) {

                return null;
            }
            String defaultMethodName = "get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);

            Method method = clazz.getMethod(defaultMethodName);

            ExportFieldGetter methodGetter = method.getAnnotation(ExportFieldGetter.class);

            return methodGetter == null ? defaultMethodName : methodGetter.getterName();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
