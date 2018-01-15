/**
 * 2009-9-3
 */
package com.shayne.isutil.messagedigest.sha;

import java.security.MessageDigest;

/**
 * SHA加密组件
 * 
 */
public final class SHACoder implements SHAIntel {

	/**
	 * SUN提供的SHA-1加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA(String data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA");

		// 执行消息摘要
		return md.digest(data.getBytes());
	}

	public String encodeSHAHex(String data) throws Exception {
		throw new Exception("未提供SHA1的十六进制实现，请使用其它厂商的实现");
	}

	/**
	 * SUN提供的SHA-256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA256(String data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		// 执行消息摘要
		return md.digest(data.getBytes());
	}

	public String encodeSHA256Hex(String data) throws Exception {
		throw new Exception("未提供SHA256的十六进制实现，请使用其它厂商的实现");
	}

	/**
	 * SUN提供的SHA-384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA384(String data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-384");

		// 执行消息摘要
		return md.digest(data.getBytes());
	}

	public String encodeSHA384Hex(String data) throws Exception {
		throw new Exception("未提供SHA384的十六进制实现，请使用其它厂商的实现");
	}

	/**
	 * SUN提供的SHA-512加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA512(String data) throws Exception {
		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-512");

		// 执行消息摘要
		return md.digest(data.getBytes());
	}

	public String encodeSHA512Hex(String data) throws Exception {
		throw new Exception("未提供SHA512的十六进制实现，请使用其它厂商的实现");
	}

	public byte[] encodeSHA224(byte[] data) throws Exception {
		throw new Exception("未提供SHA224的十六进制实现，请使用其它厂商的实现");
	}

	public String encodeSHA224Hex(byte[] data) throws Exception {
		throw new Exception("未提供SHA224的十六进制实现，请使用其它厂商的实现");
	}

}
