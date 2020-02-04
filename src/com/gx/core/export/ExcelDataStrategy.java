package com.gx.core.export;

import java.util.List;
import java.util.Map;

/**
 * 用于导出数据
 */
public interface ExcelDataStrategy {
    /**
     * 获取用于导出的dataMap数据
     *
     * @param beanList 导出的list
     * @param metaMap  导出项的元信息
     * @return
     */
    Map<String, Object> getExcelDataMap(List beanList, Map<String, Object> metaMap);
}
