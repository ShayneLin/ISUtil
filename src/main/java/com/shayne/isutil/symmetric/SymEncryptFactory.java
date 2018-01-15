package com.shayne.isutil.symmetric;

import com.shayne.isutil. symmetric.algorithm.AESCoder;
import com.shayne.isutil. symmetric.algorithm.SymEncryptIntel;
import com.shayne.isutil. symmetric.algorithm.DESCoder;
import com.shayne.isutil. symmetric.algorithm.DESedeCoder;
import com.shayne.isutil. symmetric.algorithm.IDEACoder;
import com.shayne.isutil.constant.SymEncryptType;

/**
 * 对称加密的工厂类
 * @author ShayneLin
 *
 */

public class SymEncryptFactory {
	/**
	 * 
	 * @param type
	 *            对称加密算法的名称，例如AsymEncryptType.DES
	 * @return 返回获取的算法的对应对称加密的对象<br>
	 *         若加密的算法不存在，则返回null
	 * @throws Exception
	 */
	public static SymEncryptIntel getSymEncryptUtil(SymEncryptType type) throws Exception {
		if (type == null)
			throw new Exception("未提供算法的名称，请提供要实现的对称算法的名称！");
		switch (type) {
		case AES:
			return new AESCoder();
		case DES:
			return new DESCoder();
		case DESede:
			return new DESedeCoder();
		case IDEA:
			return new IDEACoder();
		default:
			return null;
		}
	}

}
