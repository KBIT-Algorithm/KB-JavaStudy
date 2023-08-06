package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlgTest {

	public static int K;
	public static int [] array, answer;
	
	public static boolean [] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			// K 가 0 이면 실행 종료
			
			array = new int[K];
			visit = new boolean[K];
			answer = new int[6];
			// 값을 저장할 배열 크기 지정
			
			for(int i = 0; i < K; i++) {
				array[i] = (Integer.parseInt(st.nextToken()));
				// 추가된 입력값 배열에 넣기
			}	
			dfs(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) {
			// 6개를 다 선택했을 경우
			for(int number : answer) {
				// answer 에 담긴 숫자 출력
				sb.append(number).append(" ");
			}
			sb.append("\n");
			return;
			//출력 후 종료
		}
		
		for(int i = start; i < K; i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer[depth] = array[i];
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}
