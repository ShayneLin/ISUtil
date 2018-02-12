package com.shayne.isutil.messagedigest;

import com.shayne.isutil.constant.Type;

public class Test {
	public static void main(String[] args) throws Exception {
		String str = "SHA224消息摘要";
		SHAUtil.setProviderType(Type.BC);
		// 获得摘要信息
		byte[] data1 = SHAUtil.encodeSHA224(str.getBytes());

		System.out.println(new String(data1));
		// 校验
		// assertArrayEquals(data1, data2);
	}

}
