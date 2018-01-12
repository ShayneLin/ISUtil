package com.shayne.isutil.api;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.SignedObject;
//该对象主要包含了两部分：Object和签名
public class SignObjectDemo {
	public static void main(String[] args) throws Exception {
		byte[] data = "Hello World!".getBytes();

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		keyGen.initialize(1024);

		KeyPair keyPair = keyGen.generateKeyPair();
		Signature signature = Signature.getInstance(keyGen.getAlgorithm());

		// 1.签名对象的生成,签名对象自身会完成签名操作，生成签名的数据。
		SignedObject so = new SignedObject(data, keyPair.getPrivate(), signature);
		// 1.通过公钥和signature参数，完成验证
		boolean flag = so.verify(keyPair.getPublic(), signature);
		System.out.println(flag);
	}

}
