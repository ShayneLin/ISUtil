package com.shayne.isutil.api;

import java.io.FileInputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;

//获得证书链
public class CertPathDemo {
	public static void main(String[] args) throws Exception {
		// 1.证书工厂实例化
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// 2.获得证书的输入流
		FileInputStream is = new FileInputStream("D:\\tmp\\tomcat\\forclient.cer");
		// 3.生成证书链
		CertPath cp = cf.generateCertPath(is);//不知道为什么出错了。。。。。。。。
		is.close();
		
	}
}
