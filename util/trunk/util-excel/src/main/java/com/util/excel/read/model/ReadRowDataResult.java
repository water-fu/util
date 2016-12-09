package com.util.excel.read.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 解析单行Excel数据结果
 * Created by fusj on 16/12/8.
 */
public class ReadRowDataResult {

    /**
     * 行号
     */
    private int rowNo;
    /**
     * 读取异常时异常结果描述
     */
    private String msg;

    /**
     * Excel一行数据
     */
    private List<String> data;


    public ReadRowDataResult() {
        this.msg = "";
        data = Lists.newArrayList();
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
