package com.shayne.isutil.messagedigest;

import com.shayne.isutil.messagedigest.md.MD4Coder;
import com.shayne.isutil.messagedigest.md.MD5Coder;
import com.shayne.isutil.messagedigest.md.MDCoder;

/**
 * MD工具类 只需传入需要摘要的数据即可生成摘要。
 *
 */
public abstract class MDUtil {
	/**
	 * MD2加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD2(byte[] data) throws Exception {
		return MDCoder.encodeMD2(data);
	}

	/**
	 * SUN的MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(byte[] data) throws Exception {
		return MDCoder.encodeMD5(data);
	}

	/**
	 * Bouncy Castle提供的MD4加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeMD4(byte[] data) throws Exception {
		return MD4Coder.encodeMD4(data);
	}

	/**
	 * Bouncy Castle提供的MD4加密(返回十六进制字符串)
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encodeMD4Hex(byte[] data) throws Exception {

		return MD4Coder.encodeMD4Hex(data);
	}

	/**
	 * Apache Commoms提供的MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception {

		return MD5Coder.encodeMD5(data);
	}

	/**
	 * Apache Commoms提供的MD5加密(返回十六进制字符串)
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encodeMD5Hex(String data) throws Exception {

		return MD5Coder.encodeMD5Hex(data);
	}
}
