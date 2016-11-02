package com.util.encrypt.encrypt.impl;

import com.util.encrypt.encrypt.IEncrypt;
import com.util.encrypt.impl.SHA1;

/**
 * SHA1加密
 * Created by fusj on 16/4/17.
 */
public class SHA1Encrypt implements IEncrypt {

    /**
     * 加密
     */
    @Override
    public String encodePassword(String rawPass, Object salt) throws Exception {
        try {
            return SHA1.sha1(rawPass);
        } catch (Exception e) {
            throw new Exception("参数加密异常", e);
        }
    }

    /**
     *
     */
    @Deprecated
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws Exception {
        return false;
    }

    /**
     * 解密
     */
    @Deprecated
    @Override
    public String decodePassword(String rawPass, Object salt) throws Exception {
        return null;
    }
}
