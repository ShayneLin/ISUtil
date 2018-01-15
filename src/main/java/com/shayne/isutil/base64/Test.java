package com.shayne.isutil.base64;

import com.shayne.isutil.constant.Type;

public class Test {
	public static void main(String args[]) throws Exception {
		// BC
		System.out.println("------BC提供者------");
		String data = "Haha,Hello世界";
		System.out.println("原文：\n\t" + data);
		String enData = UrlBase64Coder.encode(data);
		System.out.println("编码后：\n\t" + enData);
		String deData = UrlBase64Coder.decode(enData);
		System.out.println("解码后：\n\t" + deData);
		// AC
		System.out.println("\n------AC提供者------\n");
		UrlBase64Coder.setType(Type.AC);
		System.out.println("原文：\n\t" + data);
		enData = UrlBase64Coder.encode(data);
		System.out.println("编码后：\n\t" + enData);
		deData = UrlBase64Coder.decode(enData);
		System.out.println("解码后：\n\t" + deData);
	}

}
