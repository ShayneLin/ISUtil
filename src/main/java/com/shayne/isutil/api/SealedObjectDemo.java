package com.shayne.isutil.api;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class SealedObjectDemo {
	public static void main(String[] args)throws Exception {
		//要加密的对象
		String object = new String("Hello");
		//1.密钥生成器对象
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		//2.初始化
		kg.init(56);
		//3.生成密钥
		SecretKey secretKey = kg.generateKey();
		//4.Cipher对象实例化,并且初始化
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		//5.SealedObject初始化，使用要加密的对象和Cipher对象来初始化
		SealedObject so = new SealedObject(object,cipher);
		//6.获取解密的对象
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		Object deObject = so.getObject(cipher);
		System.out.println(deObject);
		
	}

}