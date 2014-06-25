/**
 *@Copyright:Copyright (c) 2014
 */
package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *@Author kklt21cn
 *@Since 2014年6月23日
 *@Version 1.0
 */
public class Md5Encrypte {
	  	// MD5加密
		public String Encrypt_md5(String strSrc) {
			MessageDigest md = null;
			String strDes = null;
			try {
				md = MessageDigest.getInstance("MD5"); // 获取MD5加密实例
				md.update(strSrc.getBytes()); // 得到加密对象,MD5加密算法只对字节数组进行加密计算
				byte[] bt = md.digest(); // 进行加密运算，返回字节数组
				strDes = bytes2Hex(bt); // 字节数组转换成十六进制字符串，形成最终的密文
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Invalid algorithm.");
				return null;
			}
			return strDes;
		}

		// 加密后转十六进制字符串
		public String bytes2Hex(byte[] bts) // 加密字节数组转十六进制字符串
		{
			String des = "";
			String tmp = null;
			for (int i = 0; i < bts.length; i++) {
				tmp = (Integer.toHexString(bts[i] & 0xFF)); // 转十六进制字符
				if (tmp.length() == 1) {
					des += "0";
				}
				des += tmp;
			}
			return des;
		}

		public static void main(String[] args) {
			//String s = Md5Encrypte.Encrypt_md5("abcabcabc"); // "abcabcabc"是原文
		//	System.out.println(s);
		}
}
