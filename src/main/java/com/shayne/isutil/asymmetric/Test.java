package com.shayne.isutil.asymmetric;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import org.apache.commons.codec.binary.Base64;
import com.shayne.isutil.asymmetric.algorithm.DHCoder;
import com.shayne.isutil.asymmetric.algorithm.ElGamalCoder;
import com.shayne.isutil.asymmetric.algorithm.RSACoder;
import com.shayne.isutil.constant.AsymEncryptType;

public class Test {
	public static void main(String args[]) throws Exception {
		Test test = new Test();
		test.test();

	}

	
	/**
	 * 公钥
	 */
	private byte[] publicKey;
	/**
	 * 私钥
	 */
	private byte[] privateKey;

	/*
	 * 甲方公钥
	 */
	private byte[] publicKey1;
	/**
	 * 甲方私钥
	 */

	private byte[] privateKey1;

	/**
	 * 甲方本地密钥
	 */

	private byte[] key1;

	/**
	 * 乙方公钥
	 */
	private byte[] publicKey2;
	/**
	 * 乙方私钥
	 */
	private byte[] privateKey2;
	/**
	 * 乙方本地密钥
	 */
	private byte[] key2;
	
	
	
	// =========================DH==========================

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public final void test() throws Exception {
		// ======初始化密钥=====
		DHCoder dhCoder = (DHCoder) AsymEncryptFactory.getAsymEncryptUtil(AsymEncryptType.DH);
		Map<String, Object> keyMap1 = dhCoder.initKey();

		publicKey1 = dhCoder.getPublicKey(keyMap1);
		privateKey1 = dhCoder.getPrivateKey(keyMap1);

		System.err.println("甲方公钥:\n" + Base64.encodeBase64String(publicKey1));
		System.err.println("甲方私钥:\n" + Base64.encodeBase64String(privateKey1));
		// =====开始测试======

		// 由甲方公钥产生本地密钥对儿
		Map<String, Object> keyMap2 = dhCoder.initKey(publicKey1);

		publicKey2 = dhCoder.getPublicKey(keyMap2);
		privateKey2 = dhCoder.getPrivateKey(keyMap2);

		System.err.println("乙方公钥:\n" + Base64.encodeBase64String(publicKey2));
		System.err.println("乙方私钥:\n" + Base64.encodeBase64String(privateKey2));

		key1 = dhCoder.getSecretKey(publicKey2, privateKey1);
		System.err.println("甲方本地密钥:\n" + Base64.encodeBase64String(key1));

		key2 = dhCoder.getSecretKey(publicKey1, privateKey2);
		System.err.println("乙方本地密钥:\n" + Base64.encodeBase64String(key2));

		assertArrayEquals(key1, key2);
		System.err.println("\n=====甲方向乙方发送加密数据=====");
		String input1 = "密码交换算法 ";
		System.err.println("原文: " + input1);

		System.err.println("---使用甲方本地密钥对数据加密---");

		// 使用甲方本地密钥对数据加密
		byte[] code1 = dhCoder.encrypt(input1.getBytes(), key1);

		System.err.println("加密: " + Base64.encodeBase64String(code1));

		System.err.println("---使用乙方本地密钥对数据解密---");

		// 使用乙方本地密钥对数据解密
		byte[] decode1 = dhCoder.decrypt(code1, key2);
		String output1 = (new String(decode1));

		System.err.println("解密: " + output1);

		assertEquals(input1, output1);

		System.err.println("\n=====乙方向甲方发送加密数据=====");
		String input2 = "DH";
		System.err.println("原文: " + input2);

		System.err.println("---使用乙方本地密钥对数据加密---");

		// 使用乙方本地密钥对数据加密
		byte[] code2 = dhCoder.encrypt(input2.getBytes(), key2);

		System.err.println("加密: " + Base64.encodeBase64String(code2));

		System.err.println("---使用甲方本地密钥对数据解密---");

		// 使用甲方本地密钥对数据解密
		byte[] decode2 = dhCoder.decrypt(code2, key1);
		String output2 = (new String(decode2));

		System.err.println("解密: " + output2);

		// 校验
		assertEquals(input2, output2);
	}

	// ==========================RSA=====================================

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testRSA() throws Exception {
		// =====初始化密钥=====
		RSACoder rsaCoder = (RSACoder) AsymEncryptFactory.getAsymEncryptUtil(AsymEncryptType.RSA); // 初始化密钥
		Map<String, Object> keyMap = rsaCoder.initKey();

		publicKey = rsaCoder.getPublicKey(keyMap);
		privateKey = rsaCoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));

		System.err.println("\n---私钥加密——公钥解密---");

		// ====校验=====
		String inputStr1 = "RSA加密算法";
		byte[] data1 = inputStr1.getBytes();
		System.err.println("原文:\n" + inputStr1);

		// 加密
		byte[] encodedData1 = rsaCoder.encryptByPrivateKey(data1, privateKey);
		System.err.println("加密后:\n" + Base64.encodeBase64String(encodedData1));

		// 解密
		byte[] decodedData1 = rsaCoder.decryptByPublicKey(encodedData1, publicKey);
		String outputStr1 = new String(decodedData1);
		System.err.println("解密后:\n" + outputStr1);

		// 校验
		assertEquals(inputStr1, outputStr1);

		System.err.println("\n---公钥加密——私钥解密---");
		String inputStr2 = "RSA Encypt Algorithm";
		byte[] data2 = inputStr2.getBytes();
		System.err.println("原文:\n" + inputStr2);

		// 加密
		byte[] encodedData2 = rsaCoder.encryptByPublicKey(data2, publicKey);
		System.err.println("加密后:\n" + Base64.encodeBase64String(encodedData2));

		// 解密
		byte[] decodedData2 = rsaCoder.decryptByPrivateKey(encodedData2, privateKey);
		String outputStr2 = new String(decodedData2);
		System.err.println("解密后: " + outputStr2);

		// 校验
		assertEquals(inputStr2, outputStr2);
	}

	// =====================ElGamal========================

	/**
	 * 校验
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testElGamal() throws Exception {
		// =====初始化密钥=====
		ElGamalCoder elGamaCoder = (ElGamalCoder) AsymEncryptFactory.getAsymEncryptUtil(AsymEncryptType.ElGamal);
		Map<String, Object> keyMap = elGamaCoder.initKey();

		publicKey = elGamaCoder.getPublicKey(keyMap);
		privateKey = elGamaCoder.getPrivateKey(keyMap);

		System.err.println("公钥: \n" + Base64.encodeBase64String(publicKey));
		System.err.println("私钥： \n" + Base64.encodeBase64String(privateKey));

		// ======校验=====
		String inputStr = "ElGamal加密";

		byte[] data = inputStr.getBytes();

		System.err.println("原文: \n" + inputStr);

		byte[] encodedData = elGamaCoder.encryptByPublicKey(data, publicKey);

		System.err.println("加密后: \n" + Base64.encodeBase64String(encodedData));

		byte[] decodedData = elGamaCoder.decryptByPrivateKey(encodedData, privateKey);

		String outputStr = new String(decodedData);

		System.err.println("解密后: \n" + outputStr);

		assertEquals(inputStr, outputStr);
	}
}
