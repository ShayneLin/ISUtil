package com.shayne.isutil.symmetric;

import static org.junit.Assert.assertEquals;
import org.apache.commons.codec.binary.Base64;

import com.shayne.isutil.symmetric.algorithm.AESCoder;
import com.shayne.isutil.symmetric.algorithm.DESCoder;
import com.shayne.isutil.symmetric.algorithm.DESedeCoder;
import com.shayne.isutil.symmetric.algorithm.IDEACoder;
import com.shayne.isutil.constant.SymEncryptType;

public class Test {
	@org.junit.Test
	public final void testAES() throws Exception {
		String inputStr = "AES";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);
		AESCoder aesCoder = (AESCoder) SymEncryptFactory.getSymEncryptUtil(SymEncryptType.AES);
		// 初始化密钥
		byte[] key = aesCoder.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = aesCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = aesCoder.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}

	@org.junit.Test
	public final void testDESede() throws Exception {
		System.out.println("\n\n");
		String inputStr = "DESede";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);
		DESedeCoder desedeCoder = (DESedeCoder) SymEncryptFactory.getSymEncryptUtil(SymEncryptType.DESede);
		// 初始化密钥
		byte[] key = desedeCoder.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = desedeCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = desedeCoder.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}

	@org.junit.Test
	public final void testDES() throws Exception {
		System.out.println("\n\n");
		String inputStr = "DES";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);
		DESCoder desCoder = (DESCoder) SymEncryptFactory.getSymEncryptUtil(SymEncryptType.DES);
		// 初始化密钥
		byte[] key = desCoder.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = desCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = desCoder.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}

	/**
	 * 测试
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public final void testIDEA() throws Exception {

		String inputStr = "IDEA";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);
		IDEACoder ideaCoder = (IDEACoder) SymEncryptFactory.getSymEncryptUtil(SymEncryptType.IDEA);
		// 初始化密钥
		byte[] key = ideaCoder.initKey();
		System.err.println("密钥:\t" + Base64.encodeBase64String(key));

		// 加密
		inputData = ideaCoder.encrypt(inputData, key);
		System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));

		// 解密
		byte[] outputData = ideaCoder.decrypt(inputData, key);

		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}
}
