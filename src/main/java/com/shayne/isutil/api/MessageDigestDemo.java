package com.shayne.isutil.api;

import java.security.MessageDigest;

public class MessageDigestDemo {
	public static void main(String[] args) throws Exception {
		byte[] data = "Hello".getBytes();
		MessageDigest md = MessageDigest.getInstance("MD4");
		md.update(data);
		md.digest();
	}

}
