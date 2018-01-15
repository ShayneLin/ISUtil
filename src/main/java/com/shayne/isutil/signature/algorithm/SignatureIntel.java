package com.shayne.isutil.signature.algorithm;

import java.util.Map;

public interface SignatureIntel {
	/**
	 * 初始化密钥
	 * 
	 * @return Map 密钥对儿 Map
	 * @throws Exception
	 */
	public Map<String, Object> initKey() throws Exception;

	/**
	 * 签名
	 * 
	 * @param data
	 *            待签名数据
	 * @param privateKey
	 *            私钥
	 * @return byte[] 数字签名
	 * @throws Exception
	 */
	public byte[] sign(byte[] data, byte[] privateKey) throws Exception;

	/**
	 * 校验
	 * 
	 * @param data
	 *            待校验数据
	 * @param publicKey
	 *            公钥
	 * @param sign
	 *            数字签名
	 * 
	 * @return boolean 校验成功返回true 失败返回false
	 * @throws Exception
	 * 
	 */
	public boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception;

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception;

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public byte[] getPublicKey(Map<String, Object> keyMap) throws Exception;

	/**
	 * 设置密钥的长度
	 * 
	 * @param size
	 *            长度
	 */
	public void setKeySize(int size);

	/**
	 * 获取密钥的长度
	 **/
	public int getKeySize();
}
