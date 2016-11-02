package com.util.encrypt.factory;

import com.util.encrypt.encrypt.IEncrypt;

/**
 * 加密工厂
 *
 * @author
 */
public class EncryptFactory {

    /**
     * 根据摘要算法字符串返回加密类
     *
     * @param clazz
     * @return
     * @throws
     */
    public static IEncrypt getInstance(Class clazz) throws Exception {
        IEncrypt iEncrypt = null;
        try {
            iEncrypt = (IEncrypt) clazz.newInstance();
        } catch (Exception ex) {
            throw new Exception(clazz.getName() + "类初始化异常", ex);
        }

        return iEncrypt;
    }
}
