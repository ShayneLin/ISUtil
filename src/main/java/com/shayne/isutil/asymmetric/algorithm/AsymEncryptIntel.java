package com.shayne.isutil.asymmetric.algorithm;

import java.util.Map;

/**
 * 对称加密的接口，规定了对称加密的所有方法
 * 
 * @author Administrator
 *
 */
public interface AsymEncryptIntel {
	/**
	 * 设置一下密钥的长度
	 * 
	 * @param size
	 */

	public void setKeySize(int size);

	/**
	 * 初始化甲方密钥
	 * 
	 * @return Map 甲方密钥Map
	 * @throws Exception
	 */
	public Map<String, Object> initKey() throws Exception;

	/**
	 * 初始化乙方密钥
	 * 
	 * @param key
	 *            甲方公钥
	 * @return Map 乙方密钥Map
	 * @throws Exception
	 */
	public Map<String, Object> initKey(byte[] key) throws Exception;

	/**
	 * 加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] data, byte[] key) throws Exception;

	/**
	 * 解密<br>
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            密钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] data, byte[] key) throws Exception;

	/**
	 * 私钥加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            私钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception;

	/**
	 * 用公钥加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            公钥
	 * @return byte[] 加密数据
	 * @throws Exception
	 */
	public byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception;

	/**
	 * 私钥解密
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            私钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception;

	/**
	 * 公钥解密
	 * 
	 * @param data
	 *            待解密数据
	 * @param key
	 *            公钥
	 * @return byte[] 解密数据
	 * @throws Exception
	 */
	public byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception;

	/**
	 * 构建密钥
	 * 
	 * @param publicKey
	 *            公钥
	 * @param privateKey
	 *            私钥
	 * @return byte[] 本地密钥
	 * @throws Exception
	 */
	public byte[] getSecretKey(byte[] publicKey, byte[] privateKey) throws Exception;

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 私钥
	 * @throws Exception
	 */
	public byte[] getPrivateKey(Map<String, Object> keyMap);

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 *            密钥Map
	 * @return byte[] 公钥
	 * @throws Exception
	 */
	public byte[] getPublicKey(Map<String, Object> keyMap);

}
