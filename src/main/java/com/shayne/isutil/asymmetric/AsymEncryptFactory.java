package com.shayne.isutil.asymmetric;

import com.shayne.isutil.asymmetric.algorithm.AsymEncryptIntel;
import com.shayne.isutil.asymmetric.algorithm.DHCoder;
import com.shayne.isutil.asymmetric.algorithm.ElGamalCoder;
import com.shayne.isutil.asymmetric.algorithm.RSACoder;
import com.shayne.isutil.constant.AsymEncryptType;

/**
 * 将三种非对称加密的算法封装成工厂类
 * 
 * @author ShayneLin
 *
 */
public class AsymEncryptFactory {
	/**
	 * 
	 * @param type
	 *            非对称加密算法的名称，例如SymEncryptType.RSA
	 * @return 返回获取的算法的对应对称加密的对象<br>
	 *         若加密的算法不存在，则返回null
	 * @throws Exception
	 */
	public static AsymEncryptIntel getAsymEncryptUtil(AsymEncryptType type) throws Exception {
		if (type == null)
			throw new Exception("未提供算法的名称，请提供要实现的对称算法的名称！");
		switch (type) {
		case RSA:
			return new RSACoder();
		case DH:
			return new DHCoder();
		case ElGamal:
			return new ElGamalCoder();
		default:
			return null;
		}
	}
}
