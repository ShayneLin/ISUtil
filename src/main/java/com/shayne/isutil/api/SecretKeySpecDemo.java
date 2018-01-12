package com.shayne.isutil.api;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeySpecDemo {
	public static void main(String[] args) throws Exception {
		//1.创建密钥生成器，并且初始化它
		KeyGenerator kg = KeyGenerator.getInstance("RC2");
		//2.生成SecretKey对象
		SecretKey secretKey = kg.generateKey();
		//3.获得密钥编码数组
		byte[] key = secretKey.getEncoded();
		//4.生成SecretKeySpec对象,转为SecretKey
		SecretKey  sKey = new SecretKeySpec(key,"RC2");
		/*后记：其实这些所谓的密钥规范，主要是提供了字节数组形式的密钥转为密钥对象的方法。
		 * 
		 */
	}
}
