package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_9095 {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc =0; tc<t;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			dp = new int[N+1];
			
			System.out.println(dfs(N));
		}//tc
	}

	/*
	 	1,2,3의 합으로 N을 이루는 개수는 다음의 규칙을 따른다. 단, n>=4인 경우에만 
	 	N = N-1번째의 경우의 수 + N-2번째의 경우의 수 + N-3번째의 경우의 수 
	 */
	public static int dfs(int n) {
		//입력으로 0~3 값이 들어올 수도 있으니 dp테이블 작성 전에 처리해줘야 함. 
		if(n<3) return n;
		if(n==3) return 4;
		
		//n이 4이상이라면 1,2,3 값을 초기화 해주고 dp 테이블을 점화식에 따라 초기화해줌. 
		dp[1]=1; dp[2]=2; dp[3]=4;
		for(int i=4;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		return dp[n];
	}
}
