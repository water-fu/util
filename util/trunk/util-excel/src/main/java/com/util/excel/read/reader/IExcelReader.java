package com.util.excel.read.reader;

import com.util.excel.read.model.ReadRowDataResult;

import java.io.InputStream;
import java.util.List;

/**
 * Excel数据读取
 * Created by fusj on 16/12/8.
 */
public interface IExcelReader {

    /**
     * 数据处理
     * @param excelIn   excel文件
     * @param attribute 导入属性
     * @param handler   excel行数据处理
     * @return
     * @throws Exception
     */
    List<ReadRowDataResult> read(InputStream excelIn, IExcelReadAttribute attribute, IExcelDataHandler handler) throws Exception;
}
