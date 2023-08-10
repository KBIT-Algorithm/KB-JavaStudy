package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_2503 {
	static int N,cnt;
	static int[][] arr, score;
	static int[] ans; 
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		//입력 받은 값 저장할 배열
		arr= new int[N][3];
		//1~9까지 숫자 3개를 뽑아서 만든 수열을 담을 배열 
		ans = new int[3];
		//0~9까지 사용 여부를 확인할 배열 
		v = new boolean[10];
		//0:스트라이크 1: 볼의 개수를 확인하기 위해 생성한 배열
		score = new int[N][2];
		
		//입력 처리 부분
		//붙어서 입력되는 숫자 부분은 charAt으로 차례대로 j에 담고 이때
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0; j<3;j++) {
				//charAt의 반환값은 char이기에 아스키코드 표 상, 정수형과 문자(1~9)를 비교하기 위해서는 
				//48을 빼거나, 똑같은 문자형인 '0'을 빼야지 정수형이 담김.  
				arr[i][j] = input.charAt(j)-'0';
			}
			//스트라이크와 볼은 지정된 자리에만 입력되므로 각각의 인덱스를 입력해주소 '0'을 빼줌.
			score[i][0] = input.charAt(4)-'0';
			score[i][1] = input.charAt(6)-'0';
		}
		//아무것도 고르지 않았을 때부터 시작.
		dfs(0);
		System.out.println(cnt);
	}
	public static void dfs(int n) {
		//숫자 3개를 뽑으면 종료. 
		if(n==3) {
			//정답처리-> 1~9까지의 수 3개를 고른 상황에서, 수열 ans이 질문 조건에 해당하는지 점검.
			//N행만큼 스트라이크와 볼 개수가 같다면 조건을 만족하는 수열임.
			int check=0;
			for(int i=0;i<N;i++) {
				int strike=0, ball=0;
				for(int j=0; j<3;j++) {
					//인덱스가 j로 같고 값이 동일하다면 스트라이크
					if(arr[i][j]==ans[j]) {
						strike++;
					}
					//인덱스가 같지 않을 때, ans[j]가 arr[i]에 포함되어 있는 경우는 볼임. 
					else {
						for(int num:arr[i]) {
							if(num == ans[j])ball++;
						}
					}
				}
				//n행마다 볼과 스트라이크의 개수가 같다면 check++
				if(score[i][0]==strike && score[i][1]==ball)
					check++;
			}//반복문
			//check가 N과 같다면 모든 조건에 부합하는 경우이므로 해당되는 숫자임. 따라서 찾은 숫자 개수 카운트
			if(check==N) cnt++;
			return;
		}
		//[2]하부 함수 호출(1~9 까지)
		// 순서 상관 있고, 중복 허용 X 따라서 순열 이용.
		for(int i=1;i<=9;i++) {
			//중복 체크 
			if(v[i]) continue;
			v[i]= true;
			//현재 ans에서 n위치에 1~9 중 고른 값 넣고
			ans[n]=i;
			//다음 재귀 탐색하기 
			dfs(n+1);
			
			//중복 해제 -> 원래대로
			v[i] = false;
		}
	}
}
