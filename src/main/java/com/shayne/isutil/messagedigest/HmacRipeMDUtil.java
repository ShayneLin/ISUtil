package com.shayne.isutil.messagedigest;

import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * HmacRipeMD系列加密组件<br>
 * HmacRipeMD128、HmacRipeMD160共2种算法。<br>
 * 
 */
public abstract class HmacRipeMDUtil {

	/**
	 * 初始化HmacRipeMD128密钥
	 * 
	 * @return byte[] 密钥
	 * @throws Exception
	 */
	public static SecretKey initHmacRipeMDKey(String keyType) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 初始化KeyGenerator
		KeyGenerator keyGenerator = KeyGenerator.getInstance(keyType);

		// 产生秘密密钥
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey;
	}

	/**
	 * HmacRipeMD128消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeHmacRipeMD128(byte[] data) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 还原密钥
		SecretKey secretKey = initHmacRipeMDKey("HmacRipeMD128");

		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacRipeMD128Hex消息摘要,生成十六进制的形式
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param String
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static String encodeHmacRipeMD128Hex(byte[] data) throws Exception {

		// 执行消息摘要
		byte[] b = encodeHmacRipeMD128(data);

		// 做十六进制转换
		return new String(Hex.encode(b));
	}

	/**
	 * HmacRipeMD160消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public static byte[] encodeHmacRipeMD160(byte[] data) throws Exception {

		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 还原密钥
		SecretKey secretKey = initHmacRipeMDKey("HmacRipeMD160");

		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());

		// 初始化Mac
		mac.init(secretKey);

		// 执行消息摘要
		return mac.doFinal(data);
	}

	/**
	 * HmacRipeMD160Hex消息摘要
	 * 
	 * @param data
	 *            待做消息摘要处理的数据
	 * @param byte[]
	 *            密钥
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public static String encodeHmacRipeMD160Hex(byte[] data) throws Exception {

		// 执行消息摘要
		byte[] b = encodeHmacRipeMD160(data);

		// 做十六进制转换
		return new String(Hex.encode(b));
	}
}
