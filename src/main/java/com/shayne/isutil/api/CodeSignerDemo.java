package com.shayne.isutil.api;

import java.io.FileInputStream;
import java.security.CodeSigner;
import java.security.Timestamp;
import java.security.cert.CertPath;
import java.security.cert.CertificateFactory;
import java.util.Date;

public class CodeSignerDemo {
	public static void main(String[] args) throws Exception {
		// 生成证书工厂对象CertificateFactory，证书的类型为X509
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		// 生成CertPath对象
		CertPath certPath = cf.generateCertPath(new FileInputStream("D:\\tmp\\shayne.crt"));
		// 实例化Timestamp对象
		Timestamp t = new Timestamp(new Date(), certPath);
		// 实例化CodeSigner对象
		CodeSigner cs = new CodeSigner(certPath, t);

		// 获得比对结果,若CertPath和Timestamp一样则说明CodeSigner相同
		boolean status = cs.equals(new CodeSigner(certPath, t));
		System.out.println(status);

	}

}
