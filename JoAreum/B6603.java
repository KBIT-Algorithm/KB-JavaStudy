package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6603 {
	static int k;
	static int[] arr;
	static int[] result;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0)
				break;
			
			arr = new int[k];
			for(int i=0;i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			result = new int[6];
			visit = new boolean[k];
			back(0,0);
			
			System.out.println(sb);
		}
			
	}
	
	static void back(int start, int depth) {
		if(depth == 6) { // depth 가 6일 때 저장한 배열 출력
			for(int val:result) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<k; i++) {//visit을 사용해서 중복된 수가 들어오지 못하도록 한다. 
			if(!visit[i]) { // visit[i]가 false인 경우 인덱스 i의 요소가 아직 현재 조합에 포함되지 않았다는 의미. result 배열에 이 요소를 포함시키고 back 함수를 재귀로 호출 후 더 많은 조합 탐색. 
				visit[i] = true; // visit[i]가 true일 경우 인덱스 i의 요소가 이미 현재 조합에 포함되어 있다는 의미이므로 다시 선택하지 않음
				result[depth] = arr[i];
				back(i, depth +1);
				visit[i] = false;
			}
		}
	}

}

//참고 : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-6603%EB%B2%88-%EB%A1%9C%EB%98%90-Java-%EC%9E%90%EB%B0%94
