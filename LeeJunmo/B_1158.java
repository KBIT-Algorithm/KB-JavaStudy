package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlgTest {
	
	static int N, K;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		
		while(1 < q.size()) {
			for(int i = 0; i < K-1; i++) {
				int target = q.poll();
				// 뽑아서 뒤에 적재
				q.add(target);
			}
			
			sb.append(q.poll()).append(", ");
		}
		
		sb.append(q.poll()).append(">");
		// 최종 한명 남았을 때
		// 마지막 큐에 남은 값을 담고 > 로 닫기
				
		System.out.println(sb);
		
		
	}

}
