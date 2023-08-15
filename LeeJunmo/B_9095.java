package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {

	public static int T, N;
	public static int [] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		// TestCase 갯수 입력
		
		array = new int[11];
		
		array[1] = 1; // 1일때 1
		array[2] = 2; // 2일때 2
		array[3] = 4; // 3일때 4
		
		for(int i = 4; i < 11; i++) {
			array[i] = array[i - 3] + array[i - 2] + array[i - 1];
			// 공식 유추
			// 4는 1 , 2 , 3 을 더한값과 같다
		}
		
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			sb.append(array[N]).append("\n");
		}
		
		System.out.println(sb);
	}
}
