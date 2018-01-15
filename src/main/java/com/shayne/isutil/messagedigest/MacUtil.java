package com.shayne.isutil.messagedigest;

import java.security.Security;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import com.shayne.isutil.constant.MacConst;

/**
 *Mac工具类
 * 
 * @author ShayneLin
 *
 */
public abstract class MacUtil {
	

	// ============SUN=========================
	/**
	 * 初始化Mac各种密钥包括： HmacMD5、HmacSHA1、 HmacSHA256、HmacSHA384、 HmacSHA512 、HmacMD2、
	 * HmacMD2Hex、HmacMD4、 HmacSHA224；
	 * 
	 * @return
	 * @throws Exception
	 */
	private static SecretKey initKey(String keyType) throws Exception {

		// 初始化KeyGenerator
		KeyGenerator keyGenerator = KeyGenerator.getInstance(keyType);

		// 产生秘密密钥
		SecretKey secretKey = keyGenerator.generateKey();

		return secretKey;
	}

	/**
	 * HmacMD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD5(byte[] data) throws Exception {

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacMD5);

		// 实例化Mac "SslMacMD5"
		Mac mac = Mac.getInstance("SslMacMD5");// secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacSHA1加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA(byte[] data, byte[] key) throws Exception {

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacSHA1);

		// 实例化Mac SslMacMD5
		Mac mac = Mac.getInstance("SslMacMD5");// secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacSHA256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA256(byte[] data) throws Exception {

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacSHA256);
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacSHA384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA384(byte[] data) throws Exception {

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacSHA384);
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacSHA512加密
	 * 
	 * @param data
	 *            待加密数据
	 * @param key
	 *            密钥
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA512(byte[] data) throws Exception {

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacSHA512);
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	// ==================BouncyCastle=============================

	/**
	 * HmacMD2消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD2(byte[] data) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacMD2);

		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacMD2Hex消息摘要,生成十六进制的字符串
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param String
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeHmacMD2Hex(byte[] data) throws Exception {

		// 执行消息摘要
		byte[] b = encodeHmacMD2(data);

		// 做十六进制转换
		return new String(Hex.encode(b));
	}

	/**
	 * HmacMD4消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeHmacMD4(byte[] data) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacMD4);
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacMD4Hex消息摘要,生成十六进制的字符串
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeHmacMD4Hex(byte[] data, byte[] key) throws Exception {

		// 执行消息摘要
		byte[] b = encodeHmacMD4(data);

		// 做十六进制转换
		return new String(Hex.encode(b));
	}

	/**
	 * HmacSHA224消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeHmacSHA224(byte[] data) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 还原密钥
		// 生成密钥
		SecretKey secretKey = initKey(MacConst.HmacSHA224);

		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacSHA224Hex消息摘要,生成十六进制字符串
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeHmacSHA224Hex(byte[] data) throws Exception {

		// 执行消息摘要
		byte[] b = encodeHmacSHA224(data);

		// 做十六进制转换
		return new String(Hex.encode(b));
	}
}
