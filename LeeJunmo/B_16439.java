package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {
	
	public static int N, M;
	// N 은 사람 수, M 은 치킨의 종류
	public static int [][] favor;
	// 각 선호도
	public static boolean [] selected;
	// 해당 치킨의 선택 유무
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		favor = new int[N][M];
		selected = new boolean[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				favor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int value : favor) {
//			System.out.println(value);
//		}
		
		dfs(0, 0);
		// dfs 시작
		
		System.out.println(answer);
	}
	
	public static void dfs(int depth, int start) {
		if(depth == 3) {
			// 3개 고르기로 했으므로
			int summary = 0;
			// 총합 값 summary
			for(int i = 0; i < N; i++) {
				int tmp = 0;
				// 각 라인의 총합을 구할 tmp
				
				for(int j = 0; j < M; j++) {
					if(selected[j]) tmp = Math.max(tmp, favor[i][j]);
					// 선택된 치킨이면 해당 라인에서 가장 큰 값
				}
			
				summary += tmp;
			}
			
			answer = Math.max(summary, answer);
			// 해당 값이 제일 큰 선택지인지 확인 후 담기
			return;
		}
		
		for(int i = start; i < M; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			dfs(depth + 1, i + 1);
			selected[i] = false;
		}
	}
}
