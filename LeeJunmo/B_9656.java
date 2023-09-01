package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgTest {
	
	static int N;
	static boolean [] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int turn = N / 3;
		int tmp = N % 3;
		
		// 나머지가 2나 0 이면 해당 턴의 사람이 패배하므로		
		if(tmp == 1) {
			// 나눈 나머지가 1 이면
			turn += 1;
			// 다음 턴이 패배
		}
		
		if(turn % 2 == 1) {
			// turn 이 홀수이면 상근이 패배
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
		
	
	
	}

}
