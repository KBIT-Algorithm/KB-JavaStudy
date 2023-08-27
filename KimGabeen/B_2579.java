package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N= Integer.parseInt(st.nextToken());
        //dp[1]과 [2]를 미리 초기화하여 사용할 것이기에 N+1로 설정하지 않고 넉넉하게 계단 개수 300보다 큰 301로 설정함.
        int[] arr= new int[301];
        int[] dp = new int[301];

        for(int i=1; i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //1번째 칸과 2번째 칸은 점화식에서 벗어나는 범위기에 미리 초기화 해준다.
        dp[1]=arr[1];
        dp[2]=dp[1]+arr[2];

        //3번째 칸에서 N번째 칸 까지 올라가며, i번째가 되는 계단의 최댓값을 dp[i]에 저장한다.
        //N번째를 밟을 수 있는 경우는 n-1에서 올라온 경우와 n-2번째에서 올라온 경우가 존재.
        //N번째에 올라왔기에 이미 하나는 밟았으므로 3개의 계단을 연속으로 밟지 않기 위해서는 n-1번째 이전 계단이 n-3번째여야 한다.
        //또 해당 경우는 n-3번째가 최댓값이 되는 경우를 구하고 n-1번째의 수를 더한 것이 최댓값을 결정하기에 점화식이 다음과 같다.
		for(int i=3;i<=N;i++) {
	    	dp[i]=Math.max(dp[i-3]+arr[i-1],dp[i-2])+arr[i];
	    }


        System.out.println(dp[N]);
    }
}
