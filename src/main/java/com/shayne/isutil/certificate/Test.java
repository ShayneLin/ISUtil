package com.shayne.isutil.certificate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import org.apache.commons.codec.binary.Hex;

public class Test {
	private String password = "123456";

	private String alias = "demo";

	private String certificatePath = "d:/demo.cer";

	private String keyStorePath = "d:/demo.keystore";
	//特别注意KeyStore库有密码，而且里面的存的密钥也有自己的密码，这个问题可能会导致Can't recover key;
	public static void main(String args[]) throws Exception {
		Test test = new Test();
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// 1.获得证书的输入流,是证书的路径，而不是密钥库的路径
		FileInputStream is = new FileInputStream("d:/demo.cer");
		// 2.获取证书
		Certificate cert = cf.generateCertificate(is);
		System.out.println(new String(cert.getPublicKey().getEncoded()));
		System.out.println(cert.getType());
		// 3.关闭流
		is.close();
		test.test1();
		test.test2();
		test.testSign();
	}

	/**
	 * 公钥加密——私钥解密
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void test1() throws Exception {
		CertificateUtil certificateUtil = CertificateUtil.getInstance();

		System.err.println("公钥加密——私钥解密");
		String inputStr = "Ceritifcate";
		byte[] data = inputStr.getBytes();

		// 公钥加密
		byte[] encrypt = certificateUtil.encryptByPublicKey(data, certificatePath);

		// 私钥解密
		byte[] decrypt = certificateUtil.decryptByPrivateKey(encrypt, keyStorePath, alias, password);
		String outputStr = new String(decrypt);

		System.err.println("加密前:\n" + inputStr);

		System.err.println("解密后:\n" + outputStr);

		// 验证数据一致
		assertArrayEquals(data, decrypt);

	}

	/**
	 * 私钥加密——公钥解密
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void test2() throws Exception {
		CertificateUtil certificateUtil = CertificateUtil.getInstance();

		System.err.println("私钥加密——公钥解密");

		String inputStr = "sign";
		byte[] data = inputStr.getBytes();

		// 私钥加密
		byte[] encodedData = certificateUtil.encryptByPrivateKey(data, keyStorePath, alias, password);

		// 公钥加密
		byte[] decodedData = certificateUtil.decryptByPublicKey(encodedData, certificatePath);

		String outputStr = new String(decodedData);

		System.err.println("加密前:\n" + inputStr);
		System.err.println("解密后:\n" + outputStr);

		// 校验
		assertEquals(inputStr, outputStr);
	}

	/**
	 * 签名验证
	 * 
	 * @throws Exception
	 */
	@org.junit.Test
	public void testSign() throws Exception {
		CertificateUtil certificateUtil = CertificateUtil.getInstance();

		String inputStr = "签名";
		byte[] data = inputStr.getBytes();
		System.err.println("私钥签名——公钥验证");

		// 产生签名
		byte[] sign = certificateUtil.sign(data, keyStorePath, alias, password, certificatePath);
		System.err.println("签名:\n" + Hex.encodeHexString(sign));

		// 验证签名
		boolean status = certificateUtil.verify(data, sign, certificatePath);
		System.err.println("状态:\n" + status);

		// 校验
		assertTrue(status);

	}

}
