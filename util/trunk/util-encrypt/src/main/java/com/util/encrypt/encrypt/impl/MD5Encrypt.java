package com.util.encrypt.encrypt.impl;

import com.util.encrypt.encrypt.IEncrypt;
import com.util.encrypt.impl.MD5;

public class MD5Encrypt implements IEncrypt {

    public String encodePassword(String rawPass, Object salt) throws Exception {
        String afterPass = salt.toString() + rawPass;
        return MD5.md5(afterPass);
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws Exception {
        String afterPass = this.encodePassword(rawPass, salt);
        return encPass.equalsIgnoreCase(afterPass);
    }

    @Deprecated
    @Override
    public String decodePassword(String rawPass, Object salt) throws Exception {
        return null;
    }

}
