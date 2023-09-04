package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 연속된 숫자 중에서 최댓값 찾기
//1. 이전의 값+현재 값과 현재 값을 비교해서 더 큰 값이 현재 값으로 갱신됨.
//2. 이전 값 + 현재 값이 이전 값보다 작을 수 있으므로 최댓값을 갱신하며 비교해야 함
public class B_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int maxNum = 0;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int n=0; n<N;n++) {
			arr[n]= Integer.parseInt(st.nextToken());
		}
		//dp와 maxNum 초기화
		dp[0]=arr[0];
		maxNum = arr[0];
		
		for(int i=1; i<N;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i] , arr[i]);//1번의 경우를 해결하기 위해 dp 값 갱신.
			maxNum = Math.max(maxNum, dp[i]);	//2번의 경우를 해결하기 위해 현재 갱신된 dp 값을 max에 지정 
		}
		
		System.out.println(maxNum);
	}
	/*
	 * 처음엔 1의 경우만 생각하고 dp[N-1]의 값이 최댓값이라 작성해서 틀렸음. 2번의 경우를 위해 maxNum을 활용하니 해결됨.
	 */
}
