package com.shayne.isutil.messagedigest.sha;
/**
 * 为SHA提供的各种接口
 * @author Administrator
 *
 */
public interface SHAIntel {
	/**
	 * 提供的SHA加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA(String data) throws Exception;

	/**
	 * 提供的SHAHex加密，十六进制
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHAHex(String data) throws Exception;

	/**
	 * SHA-224加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public byte[] encodeSHA224(byte[] data) throws Exception;

	/**
	 * SHA-224加密,十六进制
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA224Hex(byte[] data) throws Exception;

	/**
	 * 提供的SHA256加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA256(String data) throws Exception;

	/**
	 * 提供的SHA256Hex加密，十六进制
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA256Hex(String data) throws Exception;

	/**
	 * SHA384加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA384(String data) throws Exception;

	/**
	 * SHA384Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA384Hex(String data) throws Exception;

	/**
	 * SHA512Hex加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * @throws Exception
	 */
	public byte[] encodeSHA512(String data) throws Exception;

	/**
	 * 提供的SHA512Hex加密，十六进制
	 * 
	 * @param data
	 *            待加密数据
	 * @return String 消息摘要
	 * @throws Exception
	 */
	public String encodeSHA512Hex(String data) throws Exception;
}
