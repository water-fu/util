package com.util.excel.read.reader.impl;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.util.excel.read.model.ReadRowDataResult;
import com.util.excel.read.reader.IExcelDataHandler;
import com.util.excel.read.reader.IExcelReadAttribute;
import com.util.excel.read.reader.IExcelReader;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Excel数据读取
 * Created by fusj on 16/12/8.
 */
public class ExcelReaderImpl implements IExcelReader {

    @Override
    public List<ReadRowDataResult> read(InputStream excelIn, IExcelReadAttribute attribute, IExcelDataHandler handler) throws Exception {
        // Excel列数
        int colTotal = attribute.getColTotal();
        // Excel数据开始行
        int rowStart = attribute.getRowStart();

        if(colTotal < 1) {
            throw new Exception("属性[colTotal]不能小于1");
        }
        if(rowStart < 0) {
            throw new Exception("属性[rowStart]不能小于0");
        }

        // 校验版本号
        if(attribute.isChechVersion()) {
            if (attribute.versionRow() < 0) {
                throw new Exception("属性[versionRow]不能小于0");
            }
            if (attribute.versionCol() < 0) {
                throw new Exception("属性[versionCol]不能小于0");
            }
            if(StringUtils.isEmpty(attribute.getVersion())) {
                throw new Exception("属性[version]不能为空");
            }
        }

        Workbook workbook = null;
        // 异常数据
        List<ReadRowDataResult> errorObjects = Lists.newArrayList();
        try {
            // 获取
            workbook = Workbook.getWorkbook(excelIn);
            Sheet sheet = workbook.getSheet(0);

            // 校验版本号
            if(attribute.isChechVersion()) {
                int versionRowNo = attribute.versionRow();
                int versionColNo = attribute.versionCol();

                String xlsVersion = sheet.getRow(versionRowNo)[versionColNo].getContents();
                if(StringUtils.isEmpty(xlsVersion) || xlsVersion.equals(attribute.getVersion())) {
                    throw new Exception("上传的Excel版本号不正确");
                }
            }

            // excel的行数
            int totalRow = sheet.getRows();
            if(totalRow <= rowStart) {
                throw new Exception("Excel文件数据为空");
            }

            // 读取数据病处理数据
            for(int i = rowStart; i < totalRow; i++) {
                List<String> rowData = Lists.newArrayList();

                // 单条数据校验
                try {
                    Cell[] cells = sheet.getRow(i);
                    if(cells.length == 0) {
                        continue;
                    }

                    for(int j = 0; j < colTotal; j++) {
                        if(j >= cells.length) {
                            rowData.add("");
                        } else {
                            rowData.add(cells[j].getContents());
                        }
                    }

                    // 数据转换
                    Map<String, Optional<String>> dataMap = handler.transExcelRowData(i, rowData);
                    // 数据校验
                    handler.validateExcelRowData(i, dataMap, attribute.getCustomData());
                    // 保存数据
                    handler.dealExcelRowData(i, dataMap, attribute.getCustomData());
                } catch (Exception ex) {
                    ReadRowDataResult result = new ReadRowDataResult();
                    result.setRowNo(i);
                    result.setMsg(ex.getMessage());
                    result.setData(rowData);

                    errorObjects.add(result);
                }
            }
        } finally {
            if(null != workbook) {
                workbook.close();
            }
        }

        return errorObjects;
    }
}
