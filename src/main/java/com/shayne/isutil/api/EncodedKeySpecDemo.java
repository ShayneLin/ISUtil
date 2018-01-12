package com.shayne.isutil.api;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class EncodedKeySpecDemo {
	public static void main(String[] args) throws Exception {
		// KeyPairGenerator生成器对象,初始化
		KeyPairGenerator kg = KeyPairGenerator.getInstance("DSA");
		kg.initialize(1024);
		//生成KeyPair对象
		KeyPair kp = kg.genKeyPair();
		
		//转为publicKey的流程
		byte[] pCode = kp.getPublic().getEncoded();
		X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(pCode);
		//实例化KeyFactory对象
		KeyFactory factory = KeyFactory.getInstance("DSA");
		PublicKey publicKey = factory.generatePublic(encodedKeySpec);
		/*后记：私钥的实现也是这样
		 * X509EncodedKeySpec和PKCS8EncodedKeySpec类主要是解决一种情况下的问题，那就是通常密钥都会以二进制保存在文件中
		 * ，由程序读入，所以需要借助这些类来转换为密钥对象.
		 */
	}
}
