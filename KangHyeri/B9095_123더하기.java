package work02_algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class B9095_123더하기 {
	static int T, n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		// n <=11 이므로, 배열 크기 11로 지정
		int[] arr = new int[11];
		// sum[4]를 기준으로, 뒤의 자리만 바꾼다는 가정 하에 경우의 수로 배열 값 지정   
		arr[1] = 1;  // 3+1 : 1을 만드는 경우의 수 1가지(1)
		arr[2] = 2;  // 2+2 : 2를 만드는 경우의 수 2가지(2 | 1+1)
		arr[3] = 4;  // 1+3 : 3을 만드는 경우의 수 4가지 (3 | 2+1 | 1+2 | 1+1+1)
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			// arr 4번째 자리 비었으니까 해당 위치부터 ~ n까지 for문 돌며 더하기
			for(int j = 4; j <= n; j++) {
				arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
			}
			System.out.println(arr[n]);
		}
	}
	}

