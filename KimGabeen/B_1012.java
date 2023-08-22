package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1012 {
	static int N,M;
	static int[][] arr;
	static boolean[][] v;
	
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine()," ");
			//가로길이 M : col, 세로길이 N : row
			M =  Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			v = new boolean[N][M];
			
			int K = Integer.parseInt(st.nextToken());
			
			for(int k=0; k<K;k++) {
				st = new StringTokenizer(br.readLine()," ");
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				
				arr[row][col] = 1;
			}//입력
			
			
			int ans =0;
			//arr 전체 순회하면서 1을 만나면 bfs호출-> 4방향에 1이 있는지 탐색
			for(int i=0; i<N;i++) {
				for(int j=0;j<M;j++) {
					//이전에 방문한 적 없는 좌표이고 값이 1인경우만 BFS탐색
					if(!v[i][j] && arr[i][j]==1) {
						//이 경우 인접한 곳까지 지렁이 1마리가 커버 가능. ++
						ans++;
						bfs(new Pos(i, j));
					}
				}
			}
			
			System.out.println(ans);
		}//tc
	}
	//방향 확인하고 이런 면이 미로탐색(수업시간)과 비슷한 문제. 따라서 BFS로 풀음
	public static void bfs(Pos s) {
		Queue<Pos> q = new LinkedList<>();
		
		//큐에 초기데이터 삽입, 방문 표시
		q.add(s);
		v[s.i][s.j]=true;
		
		
		while(!q.isEmpty()) {
			Pos c = q.poll();
			
			for(int k=0;k<4;k++) {
				int ni = c.i + di[k];
				int nj = c.j + dj[k];
				//1.범위 내 2.미방문 3.조건
				if(ni>=0 && ni<N && nj>=0 && nj<M) {
					//인접한 곳의 값이 1이고 방문한 적 X면 이 좌표를 기준으로 또 탐색하기 위해 add, 현재는 v true로
					if(!v[ni][nj] && arr[ni][nj] == 1) {
						q.add(new Pos(ni,nj));
						v[ni][nj] = true;
					}
				}
				
					
			}
		}
		
	}
}

	class Pos{	//	좌표(position을 저장하는)
		public int i, j;
		Pos(int i, int j){
			this.i=i;
			this.j=j;
		}
	}


