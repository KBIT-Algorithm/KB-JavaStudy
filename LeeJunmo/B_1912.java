package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {

	static int N;
	
	public static void main(String[] args) throws IOException{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 입력값 받기
	
	N = Integer.parseInt(br.readLine());
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	int value =Integer.parseInt(st.nextToken());
	int max =value;
	// 첫번째 값을 받아서 max 에 담음

	for(int i = 1; i < N; i++) {
		int num = Integer.parseInt(st.nextToken());
		// 첫번째를 건너뛰고 계산
		value = Math.max(0, value) + num;
		// value 가 음수가 아닐 떄만. 음수이면 의미 없음
		max = Math.max(max, value);
		// 큰값 다시 적재
	}
	System.out.println(max);
	}
}
