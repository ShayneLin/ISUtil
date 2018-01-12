package com.shayne.isutil.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//消息摘要的信息
public class ShaMessageDigest {

	public static void main(String args[]) throws NoSuchAlgorithmException {
		byte[] input = "Shayne".getBytes();

		MessageDigest md = MessageDigest.getInstance("SHA");
		// 更新要进行摘要的数据
		md.update(input);

		byte[] b = md.digest();// 获取消息摘要的结果
		System.out.println(new String(b));
	}

}
