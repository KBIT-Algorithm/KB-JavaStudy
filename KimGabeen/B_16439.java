package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16439 {
	static int N,M,ans;
	static int[] col;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		col = new int[3];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans =0;

		dfs(0,0);
		System.out.println(ans);
	}

	//현재 depth:n, 현재 시작지점(열) : start
	public static void dfs(int n, int start) {
		//3종류의 치킨을 고르면 종료
		if(n==3) {
			//정답 처리 -> 3종류의 치킨에 대한 모든 회원의 만족도의 합이 최대가 되도록 함.
			int result =0;
			//각 종류에 대한 모든 회원들의 최대 만족도 구하기
			for(int i=0;i<N;i++) {
				int likes = 0;
				for(int ch : col) {
					//만족도는 시킨 치킨 중에서 선호도가 가장 큰 값.
					likes = Math.max(arr[i][ch], likes);
				}
				result += likes;
			}
			//가능한 만족도의 합 중에서 최대합 구하기
			ans = Math.max(ans, result);
			return;
		}

		//현 시작지점 부터 열 탐색하며
		for(int j=start;j<M;j++) {
			//n번 인덱스에 현재 선택한 열 저장.
			col[n] = j;
			//다음 재귀는 현 시작지점 다음부터 탐색
			dfs(n+1,j+1);
		}
	}
}
