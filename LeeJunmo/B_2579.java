package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgTest {

	static int N;
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());

	        int[] stairs = new int[N + 1];
	        // 계단 수를 기준으로 배열 생성 0부터 하므로 n+1

	        for (int i = 1; i <= N; i++) {
	            stairs[i] = Integer.parseInt(br.readLine());
	        }

	        int[] dp = new int[N + 1];
	        
	        dp[1] = stairs[1];

	        for (int i = 2; i <= N; i++) {
	            if(i==2){
	            	// 게단수가 두개
	                dp[2] = stairs[1] + stairs[2];
	            }else if(i==3){
	                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
	                // 계단 수가 3개일 경우
	                // 두개의 값중 큰 값을 더한 값이 제일 큼
	            }else{
	                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
	                // 그 외 해당 점화식이 성립
	            }
	        }

	        System.out.println(dp[N]);
	        // 값 출력
	}

}
