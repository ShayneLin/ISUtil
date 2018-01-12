package com.shayne.isutil.api;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CiperOutputStreamDemo {
	public static void main(String[] args)throws Exception {
		//待加密数据
		String data = "123456789";
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		kg.init(56);
		SecretKey sKey = kg.generateKey();
		//1.实例化Cipher对象
		Cipher cipher = Cipher.getInstance("DES");
		//初始化Cipher对象，用于加密操作
		cipher.init(Cipher.ENCRYPT_MODE, sKey);
		//实例化CipherOutputStream对象,指定Cipher对象，使用它来进行对流数据的加密解密
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream("D:\\tmp\\secret.data"), cipher);
		DataOutputStream dop = new DataOutputStream(cos);
		dop.writeUTF(data);
		dop.close();
	}

}
