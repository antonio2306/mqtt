package com.zeze.demo.util;

public class MyCodeExample {

	public static void main(String[] args) {

		String str = "20160505102859";
		
		System.out.println("size: " + Integer.toHexString(str.length() & 0xFF));
		
		byte[] buf = str.getBytes();
		System.out.print("0x");
		printHexString(buf);
	}

	public static void printHexString(byte[] b) {
		
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(" ");
			System.out.print(hex.toUpperCase());
		}

	}

}
