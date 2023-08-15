package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {

	static int N; // 백준이가 일하는 날짜
	static int [] T, P;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N + 1];
		P = new int[N + 1];
		// 각각 상담에 걸리는 시간, 금액을 배열을 생성
		// 1일부터 세기 위해 + 1
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		} // 배열 값 넣기
		
		answer = Integer.MIN_VALUE;
		
		dfs(1, 0);
		// 1일부터 시작
		
		System.out.println(answer);
	}
	
	public static void dfs(int day, int money) {
		if(N + 1 < day) {
			// 근무일 초과 시 종료
			return;
		}

		if(N + 1 == day) {
			// 퇴사날과 day 가 같을 경우 (퇴사)
			answer = Math.max(money, answer);
			// 가장 돈을 많이주는 값으로 저장
			return; // 메서드 종료
		}
		
		
		dfs(day + T[day], money + P[day]);
		dfs(day + 1, money);		
	}
}
