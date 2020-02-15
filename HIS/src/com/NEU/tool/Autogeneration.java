package com.NEU.tool;

import java.util.Random;

public class Autogeneration {                       //自动生成
	
	public static String generatePatientCode() {   //自动生成病历号
		
		String no = "";
		int num[] = new int[8];
		int c = 0;
		for (int i = 0; i < 8; i++) {
			num[i] = new Random().nextInt(10);
			c= num[i];
			for (int j = 0; j < i; j++) {
				if (num[j] == c) {
					i--;
					break;
				}
			}
		}
		if (num.length > 0) {
			for (int i = 0; i < num.length; i++) {
				no += num[i];
			}
		}
		
		return no;
	}
	
}