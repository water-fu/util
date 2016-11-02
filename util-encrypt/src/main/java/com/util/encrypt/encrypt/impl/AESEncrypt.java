package com.util.encrypt.encrypt.impl;

import com.util.encrypt.encrypt.IEncrypt;
import com.util.encrypt.impl.AES;

public class AESEncrypt implements IEncrypt {

	/**
	 * 加密
	 */
	@Override
	public String encodePassword(String rawPass, Object salt) throws Exception {
		try {
			return AES.enAes(rawPass, salt.toString());
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
	@Override
	public String decodePassword(String rawPass, Object salt) throws Exception {
		try {
			return AES.deAes(rawPass, salt.toString());
		} catch (Exception e) {
			throw new Exception("参数解密异常", e);
		}
	}
}
