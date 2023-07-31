package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(q.size()!=1) {
			for(int i=0;i<k-1;i++) { //k-1때까지 처음에 있던 값을 뒤로 보낸다.
				q.offer(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}

// 참고 : https://dev-coco.tistory.com/167