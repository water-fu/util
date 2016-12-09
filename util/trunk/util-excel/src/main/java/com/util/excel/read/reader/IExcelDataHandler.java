package com.util.excel.read.reader;

import com.google.common.base.Optional;
import com.util.excel.read.model.ReadRowDataResult;

import java.util.List;
import java.util.Map;

/**
 * 具体Excel数据处理Handler
 * Created by fusj on 16/12/8.
 */
public interface IExcelDataHandler {

    /**
     * 对excel一行数据转换
     * @param rowNo    行号
     * @param rowData  行数据
     * @return
     */
    Map<String, Optional<String>> transExcelRowData(int rowNo, List<String> rowData) throws Exception;

    /**
     * 对excel一行数据校验
     * @param rowNo    行号
     * @param rowData  行数据
     * @param data     公共数据
     * @return
     */
    void validateExcelRowData(int rowNo, Map<String, Optional<String>> rowData, Map<String, Optional<Object>> data) throws Exception;

    /**
     * 对excel一行数据进行处理
     * @param rowNo    行号
     * @param rowData  行数据
     * @param data     公共数据
     * @return
     */
    Object dealExcelRowData(int rowNo, Map<String, Optional<String>> rowData, Map<String, Optional<Object>> data) throws Exception;
}
