package com.util.encrypt.encrypt;

/**
 * 如需自己扩展,继承该类
 */
public interface IEncrypt {

    String encodePassword(String rawPass, Object salt) throws Exception;
    
    boolean isPasswordValid(String encPass, String rawPass, Object salt) throws Exception;

    String decodePassword(String rawPass, Object salt) throws Exception;
}
