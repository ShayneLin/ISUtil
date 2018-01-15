package com.shayne.isutil.signature;

import com.shayne.isutil.constant.SignatureType;
import com.shayne.isutil.signature.algorithm.DSASignatureCoder;
import com.shayne.isutil.signature.algorithm.ECDSASignatureCoder;
import com.shayne.isutil.signature.algorithm.RSASignatureCoder;
import com.shayne.isutil.signature.algorithm.SignatureIntel;

public class SignatureFactory {

	public static SignatureIntel getSignatureInstance(SignatureType type) throws Exception {
		if (type == null)
			throw new Exception("未提供算法的名称，请提供要实现的对称算法的名称！");
		switch (type) {
		case DSA:
			return new DSASignatureCoder();
		case RSA:
			return new RSASignatureCoder();
		case ECDSA:
			return new ECDSASignatureCoder();
		default:
			return null;
		}
	}

}
