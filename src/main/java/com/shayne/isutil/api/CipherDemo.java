package com.shayne.isutil.api;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CipherDemo {
	public static void main(String[] args) throws Exception {
		byte[] data = "Hello,World!".getBytes();
		// 1.获取KeyGenerator对象，并且指定DES算法的
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		kg.init(56);
		// 2.生成SecretKey对象
		SecretKey sKey = kg.generateKey();
		// 3.创建Cipher对象,指定加密算法
		Cipher cipher = Cipher.getInstance("DES");
		// 4.加密初始化并且加密
		cipher.init(Cipher.ENCRYPT_MODE, sKey);
		byte[] encryptData = cipher.doFinal(data);
		System.out.println("加密后的数据：" + new String(encryptData));
		
		// 5.解密初始化并且解密
		cipher.init(Cipher.DECRYPT_MODE, sKey);
		byte[] dencryptDateFinal = cipher.doFinal(encryptData);
		System.out.println("解密后的数据：" + new String(dencryptDateFinal));
		
		/*报8个一组的错的解决办法
		int offset = 0;
		while (encryptData.length - offset > 0) {
			byte[] temp = get8ByteData(encryptData, offset, encryptData.length);
			cipher.update(temp);
			offset = offset + 8;
		}
		*/

	}

	public static byte[] get8ByteData(byte[] data, int offset, int length) {
		byte[] arr = new byte[8];
		if (offset >= length)
			return null;

			for (int i = 0; offset < length && i < 8; i++, offset++) {
				arr[i] = data[offset];
			}
		return arr;
	}

}
