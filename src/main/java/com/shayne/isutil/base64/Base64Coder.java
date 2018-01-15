package com.shayne.isutil.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64组件
 * 
 */
public final class Base64Coder {
	/**
	 * 字符编码 默认UTF-8
	 */
	public static String ENCODING = "UTF-8";

	/**
	 * 设置字符编码
	 * 
	 * @param encoding
	 *            字节数组的编码
	 */
	public static void setEncode(String encoding) {
		ENCODING = encoding;
	}

	/**
	 * Base64编码
	 * 
	 * @param data
	 *            字符串
	 * @return
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		byte[] b = data.getBytes(ENCODING);
		return encoder.encodeBuffer(b);
	}

	/**
	 * Base64编码
	 * 
	 * @param data
	 *            待编码数据，字节数组
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] data) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encodeBuffer(data);
	}

	/**
	 * Base64解码
	 * 
	 * @param data
	 *            待解码数据
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = decoder.decodeBuffer(data);
		return new String(b, ENCODING);
	}
}
