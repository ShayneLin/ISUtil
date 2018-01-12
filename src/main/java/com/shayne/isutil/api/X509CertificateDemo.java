package com.shayne.isutil.api;

import java.awt.image.SinglePixelPackedSampleModel;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Signature;
import java.security.cert.X509Certificate;

public class X509CertificateDemo {
	public static void main(String[] args) throws Exception {
		// 1.加载密钥库文件
		FileInputStream is = new FileInputStream("D:\\tmp\\X.keystore");
		// 2.实例化KeyStore对象
		KeyStore keyStore = KeyStore.getInstance("JKS");
		// 3.加载密钥库
		keyStore.load(is, "hello123".toCharArray());

		// 关闭流
		is.close();

		// 4.获得X.509证书
		X509Certificate cert = (X509Certificate) keyStore.getCertificate("X");
		// 5.通过证书标明的签名算法构造签名对象
		Signature signature = Signature.getInstance(cert.getSigAlgName());
		System.out.println(signature.getAlgorithm());
	}
}
