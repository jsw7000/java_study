package com.java.first;

public class CheckPoint {

	public static void main(String[] args) {
		int height=Integer.parseInt(args[0]);
		int weight=Integer.parseInt(args[1]);
		
		int fat = weight+100-height;
		
		System.out.println("비만수치는 "+fat+"입니다.");
		if(fat>0) {
			System.out.println("당신은 비만이군요.");
		}
			
	}

}
