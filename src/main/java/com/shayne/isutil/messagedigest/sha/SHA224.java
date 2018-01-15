/**
 * 2009-9-3
 */
package com.shayne.isutil.messagedigest.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * BouncyCastle提供的SHA224加密组件
 */
public final class SHA224 implements SHAIntel {

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws NoSuchAlgorithmException
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA224(byte[] data) throws NoSuchAlgorithmException {
		// 加入BouncyCastleProvider支持
		Security.addProvider(new BouncyCastleProvider());

		// 初始化MessageDigest
		MessageDigest md = MessageDigest.getInstance("SHA-224");

		// 执行消息摘要
		return md.digest(data);
	}

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA224Hex(byte[] data) throws Exception {

		// 执行消息摘要
		byte[] b = encodeSHA224(data);

		// 做十六进制编码处理
		return new String(Hex.encode(b));

	}

	public byte[] encodeSHA(String data) throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("未提供SHA1的实现，请使用其它厂商的实现");

	}

	public String encodeSHAHex(String data) throws Exception {
		throw new Exception("未提供SHA1的十六进制实现，请使用其它厂商的实现");
	}

	public byte[] encodeSHA256(String data) throws Exception {
		throw new Exception("未提供SHA256的实现，请使用其它厂商的实现");
	}

	public String encodeSHA256Hex(String data) throws Exception {
		throw new Exception("未提供SHA256的十六进制实现，请使用其它厂商的实现");
	}

	public byte[] encodeSHA384(String data) throws Exception {
		throw new Exception("未提供SHA384的实现，请使用其它厂商的实现");
	}

	public String encodeSHA384Hex(String data) throws Exception {
		throw new Exception("未提供SHA384的十六进制实现，请使用其它厂商的实现");
	}

	public byte[] encodeSHA512(String data) throws Exception {
		throw new Exception("未提供SHA512的实现，请使用其它厂商的实现");
	}

	public String encodeSHA512Hex(String data) throws Exception {
		throw new Exception("未提供SHA512的十六进制实现，请使用其它厂商的实现");
	}

}
