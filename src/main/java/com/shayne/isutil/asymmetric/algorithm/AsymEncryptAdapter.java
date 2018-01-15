package com.shayne.isutil.asymmetric.algorithm;

import java.util.Map;

/**
 * 使用该类作为Adapter,可以使得其子类无需实现某些方法，只实现需要的方法
 * 
 * @author ShayneLin
 *
 */
public abstract class AsymEncryptAdapter implements AsymEncryptIntel {

	public Map<String, Object> initKey() throws Exception {
		return null;
	}

	public Map<String, Object> initKey(byte[] key) throws Exception {
		return null;
	}

	public byte[] encrypt(byte[] data, byte[] key) throws Exception {
		return null;
	}

	public byte[] decrypt(byte[] data, byte[] key) throws Exception {
		return null;
	}

	public byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {
		return null;
	}

	public byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {
		return null;
	}

	public byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
		return null;
	}

	public byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getSecretKey(byte[] publicKey, byte[] privateKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getPrivateKey(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getPublicKey(Map<String, Object> keyMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setKeySize(int size) {
		// TODO Auto-generated method stub
		
	}

}
