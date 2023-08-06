package week2;

import java.util.Scanner;

public class B14620 {
	static int[][] map;
	static boolean [][] visited;
	static int n,min = Integer.MAX_VALUE;
	static int[] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				map[i][j] = sc.nextInt(); //화단 값 입력 받기
			
		dfs(0,0);
		System.out.println(min);
	}

	static void dfs(int depth, int sum) {
		if(depth==3) { //3개 꽃 심었다면 최소비용 갱신
			min=Math.min(min, sum);
			return;
		}
		// 모든 화단 탐색
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isPossible(i,j)) {// i행 j열에 꽃을 심을 수 있다면
					int temp = expense(i,j);// 비용계산
					
					visited[i][j]=true; // 꽃을 심은 자리와 상,하,좌,우 방문처리
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						
						visited[nx][ny]=true;
					}
					dfs(depth+1,sum+temp);// 방문했으니 개수를 늘리고, 비용을 더한 후 재귀호출
					//다음 경우의 수를 위해 값 초기화
					visited[i][j]=false;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dx[k];
						
						visited[nx][ny]=false;
					}
				}
			}
		}
	}
	//x행 y열에 꽃을 심을 수 있는지 판별하는 함수
	static boolean isPossible(int x, int y) {
		if(visited[x][y]==true) //해당 자리가 이미 방문처리 되어있다면 false 리턴
			return false;
		for(int i=0;i<4;i++) { // 꽃잎이 펼쳐질 수 있는지 확인
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=n||ny>=n||nx<=0||ny<0)
				return false; //꽃잎이 배열의 범위를 벗어난다면 해당 자리에 꽃을 심을 수 없음.
			if(visited[nx][ny])
				return false; // 꽃잎의 자리에 다른 꽃이 핀 경우도 꽃을 심을 수 없음
		}
		return true; //위의 경우가 아니면 꽃을 심을 수 있음.
	}
	
	static int expense(int x, int y) { //비용계산
		int sum=map[x][y];
		
		for(int k=0;k<4;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			sum+=map[nx][ny];
		}
		return sum;
	}
}

//참고 : https://subin-programming.tistory.com/280
