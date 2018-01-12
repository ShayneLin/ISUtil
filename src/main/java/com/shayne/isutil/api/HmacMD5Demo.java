package com.shayne.isutil.api;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HmacMD5Demo {
	public static void main(String[] args) throws Exception {
		// 1.数据
		byte[] data = "Hello,World!".getBytes();
		// 2.初始化KeyGenerator生成器
		KeyGenerator kg = KeyGenerator.getInstance("HmacMD5");
		kg.init(256);
		// 3.生成密钥
		SecretKey secretKey = kg.generateKey();
		// 4.生成Mac对象,初始化
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		// 5.生成摘要
		byte[] digestData = mac.doFinal(data);
		System.out.println(new String(digestData));
	}
}
