package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		int count=1;
		int[] di= {-1,1,0,0}; //상,하,좌,우
		int[] dj= {0,0,-1,1};
		int[] num = new int[3];
		while(count<=TC) {
			int jump=3;//점프 카운트
			int N = sc.nextInt(); //N*N
			int bug_num=sc.nextInt(); //소금쟁이 수
			int start_i=sc.nextInt();
			int start_j=sc.nextInt();
			int direction=sc.nextInt();
			int[][] pond = new int[N][N];
			for(int i=jump;i>0;i--) {
				for(int k=start_i;k<pond.length;i++) {
					for(int j=start_j;j<pond.length;j++) {

						if(direction==1) {

						}
						if(direction==2) {

						}
						if(direction==3) {

						}
						if(direction==4) {

									}
							
					}
			}
			for(int i=start_i;i<pond.length;i++) {
				for(int j=start_j;j<pond.length;j++) {

					if(direction==1) {

					}
					if(direction==2) {

					}
					if(direction==3) {

					}
					if(direction==4) {

								}
						
				}
					//연못밖으로 나가는 경우
//					for(int d=0;d<dj.length;d++) {
//						int ni = i+di[d];
//						int nj = j+dj[d];
//
//						if(ni>=0&&ni<pond.length&&nj>=0&&nj<pond.length) {
//
//
//						}
//					}
					if()
				}

			}

		}

	}
