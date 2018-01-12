package com.shayne.isutil.api;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;

public class KeyAgreementDemo {
	// KeyAgreement离不开DH算法
	public static void main(String[] args) throws Exception {
		// 1.实例化KeyPairGenerator对象，并指定DH算法
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		// 2.生成KeyPair对象kp1、kp2

		KeyPair kp1 = kpg.generateKeyPair();
		KeyPair kp2 = kpg.generateKeyPair();

		// 3.实例化KeyAgreement对象，并初始化(根据DH算法来创建的，显然依赖于DH算法)
		KeyAgreement keyAgree = KeyAgreement.getInstance(kpg.getAlgorithm());
		keyAgree.init(kp2.getPrivate());
		// 4.执行计划，就是执行下一个阶段（具体是干嘛还不清楚）
		keyAgree.doPhase(kp1.getPublic(), true);

		// 5.生成SecretKey对象,指定算法(协商出来的算法)
		SecretKey secretKey = keyAgree.generateSecret("DES");
		System.out.println("keyA:"+new String(secretKey.getEncoded()));
		
		
		
		//！！！！同理对方生成的密钥也应该一样(kp1和kp2的顺序调换)
		keyAgree.init(kp1.getPrivate());
		keyAgree.doPhase(kp2.getPublic(), true);
		SecretKey keyB = keyAgree.generateSecret("DES");
		System.out.println("keyB:"+new String(keyB.getEncoded()));
		/*后记：KeyAgreement与DH算法相关联，用来协商生成的密钥，初始化条件：甲乙两方各自拥有一对公私钥，DH算法的功能是
		 * 双方使用对方的公钥与自己的私钥来构建新的秘密密钥，这样构建的秘密密钥将相等。关键点就是使用对方的公钥和自己的私钥
		 * 构建的密钥将与对方构建的一样，达到密钥协商。
		 * 
		 */

	}

}
