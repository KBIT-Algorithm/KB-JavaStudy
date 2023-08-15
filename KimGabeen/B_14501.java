package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {
	static int N,ans;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		//N일까지 계산하기 위해 범위 +1 더 줌. 
		arr = new int[N+1][2];
		
		//1일부터 N일까지 T와 P입력받기
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<2;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=0;
		//1일부터 시작
		dfs(1,0);
		System.out.println(ans);
	}
	
	public static void dfs(int n,int p) {
		//N+1일을 넘어가면 최대이익을 고려할 필요도 없기에 그냥 리턴해주기
		if(n>N+1) return;
		//N+1이 되면 N일까지 중 최대 이익 구하기 
		if(n==N+1){
			ans = Math.max(ans, p);
			return;
		}
		
		//해당 일의 상담을 선택한다면 다음 재귀
		dfs(n+arr[n][0],p+arr[n][1]);
		//선택하지 않는다면 이익X이고 다음 날 재귀 탐색
		dfs(n+1,p);
	}
}
