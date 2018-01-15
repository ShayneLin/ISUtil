package com.shayne.isutil.signature;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.shayne.isutil.constant.SignatureType;
import com.shayne.isutil.signature.algorithm.DSASignatureCoder;
import com.shayne.isutil.signature.algorithm.ECDSASignatureCoder;
import com.shayne.isutil.signature.algorithm.RSASignatureCoder;

public class Test {
	/**
	 * 公钥
	 */
	private byte[] publicKey;

	/**
	 * 私钥
	 */
	private byte[] privateKey;

	/**
	 * 校验签名
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testDSASign() throws Exception {
		// ==准备阶段===
		System.err.println("\n\n\n\n----DSA准备阶段----");
		DSASignatureCoder dsaSignatureCoder = (DSASignatureCoder) SignatureFactory
				.getSignatureInstance(SignatureType.DSA);
		Map<String, Object> keyMap = dsaSignatureCoder.initKey();

		publicKey = dsaSignatureCoder.getPublicKey(keyMap);

		privateKey = dsaSignatureCoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));
		// ==签名\验证阶段==
		System.err.println("----签名\\验证阶段----");
		String inputStr = "DSA数字签名";
		byte[] data = inputStr.getBytes();

		// 产生签名
		byte[] sign = dsaSignatureCoder.sign(data, privateKey);
		System.err.println("签名:\r" + Hex.encodeHexString(sign));

		// 验证签名
		boolean status = dsaSignatureCoder.verify(data, publicKey, sign);
		System.err.println("状态:\r" + status);
		assertTrue(status);

	}

	/**
	 * 初始化密钥
	 * 
	 * @throws Exception
	 */

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testRSASign() throws Exception {
		// ==准备阶段===
		System.err.println("\n\n\n\n----RSA准备阶段----");
		RSASignatureCoder rsaSignatureCoder = (RSASignatureCoder) SignatureFactory
				.getSignatureInstance(SignatureType.RSA);

		Map<String, Object> keyMap = rsaSignatureCoder.initKey();

		publicKey = rsaSignatureCoder.getPublicKey(keyMap);

		privateKey = rsaSignatureCoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));
		// ==签名\验证阶段==
		System.err.println("----签名\\验证阶段----");

		String inputStr = "RSA数字签名";
		byte[] data = inputStr.getBytes();

		// 产生签名
		byte[] sign = rsaSignatureCoder.sign(data, privateKey);
		System.err.println("签名:\n" + Hex.encodeHexString(sign));

		// 验证签名
		boolean status = rsaSignatureCoder.verify(data, publicKey, sign);
		System.err.println("状态:\n" + status);
		assertTrue(status);

	}

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testECDSASign() throws Exception {
		// ==准备阶段===
		System.err.println("\n\n\n\n----ECDSA准备阶段----");
		ECDSASignatureCoder ecdsSignatureCoder = (ECDSASignatureCoder) SignatureFactory
				.getSignatureInstance(SignatureType.ECDSA);
		Map<String, Object> keyMap = ecdsSignatureCoder.initKey();

		publicKey = ecdsSignatureCoder.getPublicKey(keyMap);

		privateKey = ecdsSignatureCoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));
		// ==签名\验证阶段==
		System.err.println("----签名\\验证阶段----");
		String inputStr = "ECDSA 数字签名";
		byte[] data = inputStr.getBytes();

		// 产生签名
		byte[] sign = ecdsSignatureCoder.sign(data, privateKey);
		System.err.println("签名:\r" + Hex.encodeHexString(sign));

		// 验证签名
		boolean status = ecdsSignatureCoder.verify(data, publicKey, sign);
		System.err.println("状态:\r" + status);
		assertTrue(status);

	}
}
