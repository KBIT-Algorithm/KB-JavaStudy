package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_6603 {
	static int K;
	static int[] arr,ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			K = Integer.parseInt(st.nextToken());
			//입력 종료 조건
			if(K==0) break;
			
			ans=new int[6];
			arr = new int[K];
			
			for(int i=0;i<K;i++) 
				arr[i] = Integer.parseInt(st.nextToken());
		
			dfs(0,0);
			System.out.println();
		}//테스트 케이스 K==0이면 종료
	}
	//K개 중에서 6개의 조합을 고르는 메소드, 중복X,순서상관X
	//크기가 6인 정답배열의 인덱스 n, 저장할 숫자 선택을 위한 변수
	public static void dfs(int n, int start) {
		//종료조건:6개 까지 뽑았을 경우 종료
		if (n==6) {	
			for (int i=0; i<6; i++) 
				System.out.print(ans[i]+" ");
			System.out.println();
			return;
		}
		//start~다음 숫자를 선택
		for(int i=start;i<K;i++) {
			ans[n]= arr[i]; //입력 배열에서 선택한 숫자 저장 
			dfs(n+1,i+1); //다음 숫자 선택하기 위한 하부 함수 호풀 
		}
	}
}
