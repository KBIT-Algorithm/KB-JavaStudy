package week2;

import java.util.Scanner;

public class B16439 {
	static int n,m,max=0;
	static int[][] chicken;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 회원 수
		m = sc.nextInt(); // 치킨 종류
		
		chicken = new int[n][m];
		visited = new boolean[m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				chicken[i][j]=sc.nextInt();
		
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int depth, int start) {
		if(depth==3) {
			int sum=0;
			
			for(int i=0;i<n;i++) {
				int num=0;
				for(int j=0;j<m;j++) {
					if(visited[j]==true)
						num=Math.max(num, chicken[i][j]); // 더 큰 값 저장
				}
				sum+=num;
			}
			max = Math.max(max, sum);
			return;
		}
		for(int i=start;i<m;i++) { // 중복 없이 선택
			if(visited[i]==false) {
				visited[i] = true;
				dfs(depth+1,i+1);
				visited[i] = false;
			}
		}
	}

}
