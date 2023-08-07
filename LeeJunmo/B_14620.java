package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {
	public static int N;
	public static int [][] array;
	public static boolean [][] impossible;
	
	public static int answer = Integer.MAX_VALUE;
	
	public static int [] moveX = {1, -1, 0, 0}; // 동서남북
	public static int [] moveY = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		impossible = new boolean[N][N];
		// 안되는 x y 위치
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(array[i][j] + " ");
//			}
//			
//			System.out.println();
//		}
//		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(impossible[i][j] + " ");
//			}
//			
//			System.out.println();
//		}		
		
		dfs(0, 1, 0);
		// 어차피 0 index x 는 안되므로 1부터 시작
		System.out.println(answer);
	}

	public static void dfs(int depth, int start, int summary) {
		if(depth == 3) {
			// 꽃을 3개 심엇으면 return
			answer = Math.min(answer, summary);
			return;
		}
		
		for(int i = start; i < N - 1; i++) {
			// 시작지점 부터 하나 전까지 (맨 끝은 어차피 심으면 죽기 때문)
			for(int j = 1; j < N - 1; j++) {
				if(impossible[i][j]) continue;
				// 불가능한 위치면 넘기기
				if(!possible(i , j)) continue;
				// 가능한 곳인지 (다른 꽃이링 겹치는지)
				int tmp = array[i][j];
				// 불가능 조건에 해당되지 않는 경우 값을 tmp 에 담기
				impossible[i][j] = true;
				// 불가능한 배열에 true 로 변경
				
				for(int k = 0; k < 4; k++) {
					impossible[i + moveX[k]][j + moveY[k]] = true;
					// 각 4방향으로 true로 변환
					tmp += array[i + moveX[k]][j + moveY[k]];
					// 꽃이 가린 가격도 합하기
				}
				
				dfs(depth + 1, i ,summary + tmp);
				// dfs 실행
				impossible[i][j] = false;
				// return 하고 나올 때 false 로 돌려놓기
				for(int k = 0; k < 4; k++) {
					impossible[i + moveX[k]][j + moveY[k]] = false;				}
					// 4방향 해제
			}
		}
	}

	static boolean possible(int x, int y) {
		// 가능한지 여부
		for(int i = 0; i < 4; i++) {
			if(x < 0 ||  x >= N || y < 0 || y >= N || impossible[x + moveX[i]][y + moveY[i]])
                // array 를 벗어났는 지, 가능한 위치 인지 확인
				return false;
			}
		
		return true;
	}

}
