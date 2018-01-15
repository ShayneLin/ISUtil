
package com.shayne.isutil.messagedigest.sha;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * SHA加密组件
 * 
 */
public final class SHACoderAC implements SHAIntel {

	/**
	 * Apache Commons提供的SHA加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha(data);
	}

	/**
	 * Apache Commons提供的SHAHex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHAHex(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.shaHex(data);
	}

	/**
	 * Apache Commons提供的SHA256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA256(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha256(data);
	}

	/**
	 * Apache Commons提供的SHA256Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA256Hex(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha256Hex(data);
	}

	/**
	 * Apache Commons提供的SHA384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA384(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha384(data);
	}

	/**
	 * Apache Commons提供的SHA384Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA384Hex(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha384Hex(data);
	}

	/**
	 * Apache Commons提供的SHA512Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA512(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha512(data);
	}

	/**
	 * Apache Commons提供的SHA512Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA512Hex(String data) throws Exception {

		// 执行消息摘要
		return DigestUtils.sha512Hex(data);
	}

	public byte[] encodeSHA224(byte[] data) throws Exception {
		throw new Exception("未提供SHA224的十六进制实现，请使用其它厂商的实现");
	}

	public String encodeSHA224Hex(byte[] data) throws Exception {
		throw new Exception("未提供SHA224的十六进制实现，请使用其它厂商的实现");
	}
}
