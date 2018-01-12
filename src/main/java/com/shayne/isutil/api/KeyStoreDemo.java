package com.shayne.isutil.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

public class KeyStoreDemo {
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException,
			IOException, UnrecoverableEntryException {
		// 密码
		char[] pwd = "hello123".toCharArray();
		// 加载密钥库文件
		FileInputStream is = new FileInputStream("D:\\tmp\\my.store");
		// 实例化KeyStore对象
		KeyStore ks = KeyStore.getInstance("JCEKS");
		// 加载密钥库，使用密码
		ks.load(is, pwd);
		// 关闭文件流
		is.close();

		// 1.获取私钥对象方式1：获得其别名对应的私钥
		PrivateKey key = (PrivateKey) ks.getKey("shayne", pwd);
		System.out.println("1.该私钥的信息：");
		System.out.println(key.getAlgorithm() + "\n" + new String(key.getEncoded()));

		// 2.获取私钥对象方式2：
		KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry("shayne",
				new KeyStore.PasswordProtection(pwd));
		PrivateKey pkKey = pkEntry.getPrivateKey();
		System.out.println("2.该私钥的信息：");
		System.out.println(pkKey.getAlgorithm() + "\n" + new String(pkKey.getEncoded()));
		System.out.println(pkKey == key);

		/*
		 * 后记：key和pkKey的对象是同一个，随意第二次打印私钥信息时，重新生成可getEncoded信息。
		 */

	}
}
