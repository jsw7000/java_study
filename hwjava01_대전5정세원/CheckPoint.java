package com.java.first;

public class CheckPoint {

	public static void main(String[] args) {
		int height=Integer.parseInt(args[0]);
		int weight=Integer.parseInt(args[1]);
		
		int fat = weight+100-height;
		
		System.out.println("�񸸼�ġ�� "+fat+"�Դϴ�.");
		if(fat>0) {
			System.out.println("����� ���̱���.");
		}
			
	}

}
