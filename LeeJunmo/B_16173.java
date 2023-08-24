package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlgTest {
	
	static int N;
	static int [][] array;
	static String answer;
	
	static int [] dx = {1, 0};
	static int [] dy = {0, 1};
	
	static boolean [][] visited;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		array = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = "Hing";

		dfs(0, 0);
		System.out.println(answer);
	}

	public static void dfs(int startX, int startY) {
		if(array[startX][startY] == -1) {
			// 마지막 점에 도착했을 경우
			answer = "HaruHaru";
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int x = startX + dx[i] * array[startX][startY];
			int y = startY + dy[i] * array[startX][startY];
			if(x >= N || y >= N || visited[x][y]) continue;
			
			visited[x][y] = true;
			dfs(x, y);
		}
	}
}
