package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AlgTest {
	
	public static int T;
	public static int N, M;
	
	public static Queue<Integer> queue, index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		// TestCase 의 사이즈
		
		// 각 값을 담을 queue
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int bigger = 0;
			int counter = 0;
			
			queue = new LinkedList<>();
			index = new LinkedList<>();


			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				index.add(j);
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			while(!queue.isEmpty()) {
				// 다 뽑을때까지
				bigger = Collections.max(queue);
				// 제일 큰 값을 먼저 찾음
				if (bigger != queue.peek()) {
					// 제일 큰 값이 뽑히지않았으면
					index.add(index.poll()); // 다시 뒤로 후순위 배열
					queue.add(queue.poll());
				}
				else {
					// 큰 값이 이면
					if(index.poll() == M) {
						// 몇번째로 q 에 담겼는지 확인 후
						// 원하는 M 번쨰 수일 경우 queue에서 해당 값 뽑기
						queue.poll();
						counter++;
						// counter 로 번쨰수 새줌
						break;
					}
					else {
						queue.poll();
						counter++;
					}
				}
			}
			
			sb.append(counter).append("\n");
		}
		
		System.out.println(sb);

	}

}
