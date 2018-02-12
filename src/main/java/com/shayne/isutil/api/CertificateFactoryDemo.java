package com.shayne.isutil.api;

import java.io.FileInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class CertificateFactoryDemo {
	public static void main(String[] args) throws Exception {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// 1.获得证书的输入流,是证书的路径，而不是密钥库的路径
		FileInputStream is = new FileInputStream("D:\\tmp\\shayne.crt");
		// 2.获取证书
		Certificate cert = cf.generateCertificate(is);
		System.out.println(new String(cert.getPublicKey().getEncoded()));
		// 3.关闭流
		is.close();

	}
}
