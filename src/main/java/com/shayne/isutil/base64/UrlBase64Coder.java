package com.shayne.isutil.base64;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.UrlBase64;

import com.shayne.isutil.constant.Type;

/**SUN没有提供实现，AC、BC提供了实现
 * Url Base64组件
 * 
 */
public final class UrlBase64Coder {

	/**
	 * 字符编码
	 */
	public final static String ENCODING = "UTF-8";

	/**
	 * 指定使用哪个组织或机构的实现，AC,BC；默认BC
	 */
	public static Type type = Type.BC;

	/**
	 * 设置使用的UrlBase64由哪家实现（不同的提供者的实现或者优缺点不同）
	 * 
	 * @param bType
	 */
	public static void setType(Type bType) {
		type = bType;
	}

	/**
	 * Url Base64编码
	 * 
	 * @param data
	 *            待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {

		// 执行编码
		byte[] enData = null;

		if (type == Type.BC)
			enData = UrlBase64.encode(data.getBytes(ENCODING));
		else if (type == Type.AC) {
			enData = Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
		}

		return new String(enData, ENCODING);
	}

	/**
	 * Url Base64解码
	 * 
	 * @param data
	 *            待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {

		// 执行解码
		byte[] enData = null;

		if (type == Type.BC)
			enData = UrlBase64.decode(data.getBytes(ENCODING));
		else if (type == Type.AC) {
			enData = Base64.decodeBase64(data.getBytes(ENCODING));
		}
		
		return new String(enData, ENCODING);
	}

}
