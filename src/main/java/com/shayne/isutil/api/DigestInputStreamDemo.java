package com.shayne.isutil.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//InputStreamDigest的例子
public class DigestInputStreamDemo {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// 要生成消息摘要的数据
		byte[] data = "Hello,World!".getBytes();
		// 消息摘要算法
		MessageDigest md = MessageDigest.getInstance("MD5");

		// DigestInputStream实例化,传入要进行摘要处理的数据和摘要对象（包含了算法）
		DigestInputStream dis = new DigestInputStream(new ByteArrayInputStream(data), md);

		// 这一步可以决定对那些数据进行摘要！！可以使用流的方式来更新数据，也就是可以读取各种设备的文件或者其他数据。
		 int i = dis.read(data);
		 //int j = dis.read(data, 0, data.length - 4);

		// 生成摘要结果
		byte[] digestData = dis.getMessageDigest().digest();
		dis.close();
		System.out.println(new String(digestData));

	}
}
/*后记：
 * DigestInputStream和DigestOutputStream使用都相似，一个是在数据读入的时候对数据进行摘要，一个是在数据写出的时候对数据进行摘要，
 * 关键的实现：在read()和write()方法里的实现对是否开启了摘要功能的变量进行了判断，on则使用摘要对象update()方法进行摘要处理，否则当做
 * 普通的流操作。
 * 
 */
