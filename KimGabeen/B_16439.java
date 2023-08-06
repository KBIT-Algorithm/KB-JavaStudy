package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16439 {
	static int N,M,max;
	static int[][] arr;
	static int[] col;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		col = new int[3];
		v= new boolean[M];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = 0; 
		combi(0,0);
		System.out.println(max);
	}
	//M개 중에서 3개 뽑기 
	public static void combi(int cnt, int start) {
		//3개를 뽑았을 때가 종료 조건 
		if(cnt==3) {
			//치킨 3종류의 만족도의 합을 구하기 위한 변수
			int result =0;
			//뽑힌 3개의 열 조합들을 0~N-1행마다 골랐을 때 만족도가 최대가 되는 경우를 구함.  
			for(int i=0;i<N;i++) {
				int likes = 0;
				for(int j : col) {
					likes = Math.max(likes, arr[i][j]);
				}
				//주어진 조합들의 합을 구하고
				result += likes;
			}
			//가능한 만족도의 합의 최댓값 구하기
			if(result>max)max=result;
			return;
		}
		
		//M개의 열 중 3개의 열 조합 구하기 
		for (int j=start; j<M; j++) {
			if(v[j]) continue;	

			v[j]=true;
			col[cnt]=j;
			combi(cnt+1,j+1);
			v[j]=false;
		}
	}
}
