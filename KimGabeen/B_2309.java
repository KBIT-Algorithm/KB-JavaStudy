package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2309 {
	static int[] arr,ans;
	static boolean find = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr= new int[9];
		//중복처리이자 정답 담을 배열
		ans = new int [9];
		
		//9명 난쟁이들의 키를 입력 받음.
		for(int i=0; i<9;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr[i]=N;
		}
		
		dfs(0,0,0);
	}
	//9명에서 7명을 선택하는 조합 문제로 생각함. 
	//현재 확인하는 난쟁이 번호, 선택한 난쟁이의 수, 선택한 난쟁이들의 키의 합
	public static void dfs(int n, int count, int height) {
		//이미 가능한 경우를 선택했으면 종료. 
		if(find)return;
		//9번째까지 다 확인했으면 종료
		if(n==9) {
			//이때 선택한 난쟁이의 수가 7명이고 그들의 합이 100일때가 정답임.
			if(count==7 && height==100){
				//정답처리 - 오름차순 정렬
				Arrays.sort(ans);
				//ans에서 선택하지 않은 난쟁이는 0이므로 이때는 넘어가고 아닌 경우만 출력
				for(int num : ans) {
					if(num==0) continue;
					System.out.println(num);
				}
				//현 문제는 여러가지의 경우의 수가 있는 경우, 한 가지의 경우만 출력해야함. 
				//1가지의 경우만 선택하기 위해 트리거 변수를 걸어줌. 
				find = true;
			}
			return;
		}
		//현재 난쟁이를 선택한 경우 ans정답 배열에 키 값 넣어주기
		ans[n]=arr[n];
		//현재를 선택했으니 다음 재귀의 경우는 확인할 난쟁이 번호 +1, 선택한 수 +1, 키+ 현재 난쟁이의 키를 넘겨받는다.
		dfs(n+1,count+1,height+arr[n]);
		
		//위에 선택했을 경우를 다 탐색하고 종료한 후에는 선택하지 않는 경우를 탐색해야 하는데, 
		//ans에 이미 현 난쟁이의 키가 들어있으니 이를 0으로 다시 저장해줌. (즉, 선택X를 0을 표시)
		//비효율적인듯...
		ans[n]=0;
		dfs(n+1,count,height);
	}
}
