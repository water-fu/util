package com.util.excel.read.reader;

import com.google.common.base.Optional;

import java.util.Map;

/**
 * Excel读取属性
 * Created by fusj on 16/12/8.
 */
public abstract class IExcelReadAttribute {
    /**
     * 获取总列数
     * @return
     */
    public abstract int getColTotal();

    /**
     * 获取数据开始行号,行数从0开始
     * @return
     */
    public abstract int getRowStart();

    /**
     * 是否需要检验版本号
     *  如需要,重写该方法,并必须实现versionRow() versionCol() getVersion()方法
     * @return
     */
    public boolean isChechVersion() {
        return false;
    }

    /**
     * 版本号所在行数,行数从0开始
     * @return
     */
    public abstract  int versionRow();

    /**
     * 版本号所在列数,列数从0开始
     * @return
     */
    public abstract int versionCol();

    /**
     * 返回当前excel正确的版本号
     * @return
     */
    public abstract String getVersion();

    /**
     * 私有属性,会传输到具体业务方法
     * @return
     */
    public abstract Map<String, Optional<Object>> getCustomData();
}
