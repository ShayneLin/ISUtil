package com.shayne.isutil.messagedigest;

import com.shayne.isutil.constant.Type;
import com.shayne.isutil.messagedigest.sha.SHA224;
import com.shayne.isutil.messagedigest.sha.SHACoder;
import com.shayne.isutil.messagedigest.sha.SHACoderAC;
import com.shayne.isutil.messagedigest.sha.SHAIntel;

/**
 * 该工具提供了SUN,BC,AC三个厂商提供的算法实现，互相弥补， 
 * 默认是SUN的，可以通过setProviderType
 * 指定使用哪个厂商的算法实现
 * 
 * @author ShayneLin
 *
 */
public abstract class SHAUtil {
	/**
	 * 指定要使用的厂商的SHA算法,默认SUN
	 */
	private static SHAIntel sha = new SHACoder();

	/**
	 * 设置使用哪个提供者的算法
	 * 
	 * @param type
	 *            SUN,AC,BC
	 */
	public static void setProviderType(Type type) {
		switch (type) {
		case SUN:
			sha = new SHACoder();
			break;
		case BC:
			sha = new SHA224();
			break;
		case AC:
			sha = new SHACoderAC();
			break;
		default:
			sha = new SHACoder();
		}
	}

	/**
	 * SHA加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeSHA(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA(data);
	}

	/**
	 * SHAHex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHAHex(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHAHex(data);
	}

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeSHA224(byte[] data) throws Exception {

		return sha.encodeSHA224(data);
	}

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHA224Hex(byte[] data) throws Exception {

		return sha.encodeSHA224Hex(data);

	}

	/**
	 * SHA256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeSHA256(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA256(data);
	}

	/**
	 * SHA256Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHA256Hex(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA256Hex(data);
	}

	/**
	 * SHA384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeSHA384(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA384(data);
	}

	/**
	 * SHA384Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHA384Hex(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA384Hex(data);
	}

	/**
	 * SHA512Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeSHA512(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA512(data);
	}

	/**
	 * HA512Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeSHA512Hex(String data) throws Exception {

		// 执行消息摘要
		return sha.encodeSHA512Hex(data);
	}

}
