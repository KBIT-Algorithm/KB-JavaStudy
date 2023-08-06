package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14620 {
	static int N,ans,cnt;
	static int[][] arr;
	static boolean[][] v;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		v = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		//최솟값을 구하기 위한 최악의 값으로 꽃잎 3개의 5지점의 가격이 전부 200으로 산정
		ans = 200*5*3;
		dfs(0,0);
		
		System.out.println(ans);
	}
	public static void dfs(int cnt, int costSum) {
		//꽃잎의 개수가 3개가 될 때가 종료조건
		if(cnt==3) {
			//꽃잎 3개의 가격 중 최솟값 찾기 
			ans = Math.min(ans, costSum);
			return;
		}
		//씨앗을 1행1열부터 심어야 경계에 안 걸치고 꽃잎 존재 가능
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				//화단을 벗어나는지 아닌지 체크하기 위한 변수
				boolean find = true;
				//각 꽃잎 5지점의 가격을 구하기 위한 변수
				int cost=0;
				//씨앗이 심어질 부분이 비어 있다면 해당 지점 가격 더해주기
				if(!v[i][j]) cost+=arr[i][j];
				//그 다음 살펴볼 4지점이 
				for(int k=0;k<4;k++) {
					int ni = i+di[k];
					int nj = j+dj[k];
					//1.범위 내, 2. 미방문 확인을 만족하지 못하면 break
					if (ni<0 || nj<0 || ni>=N || nj>=N || v[ni][nj]) {
						find = false;
						break;
					}
					//아니라면 꽃잎 4지점의 가격 더하기 
					cost += arr[ni][nj];
				}	
				//4방면이 다 안 벗어나고 비어있다면 4지점 다 체크표시 해주기
				if(find) {
					//씨앗 심은 부분 T
					v[i][j] = true;
					for(int n = 0; n < 4; n++) {
						int ni = i + di[n];
						int nj = j + dj[n];
						//꽃잎 필 부분 T
						v[ni][nj] = true;
						
					}
					//다음 꽃을 심었을 때 총 가격을 구하기 위해 완탐해준다. 
					dfs(cnt+1,costSum+cost);
					//탐색이 끝났으므로 다 해제
					for(int n = 0; n < 4; n++) {
						int ni = i + di[n];
						int nj = j + dj[n];
						//꽃잎 부분 해제
						v[ni][nj] = false;
					}
					//씨앗 심은 부분 해제
					v[i][j] = false;
				}
				
			}
		}
	}
}
