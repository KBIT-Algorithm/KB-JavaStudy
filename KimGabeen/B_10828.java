package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_10828 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			//각 명령문 조건에 따라 다르게 처리
			switch(command) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				//스택에 삽입
				stack.push(num);
				break;
			case "pop" :
				//만약 비어있다면 -1 출력
				if(stack.empty()) System.out.println(-1);
				else System.out.println(stack.pop());
				break;
			case "size" :
				System.out.println(stack.size());
				break;
			case "empty" :
				if(stack.empty())System.out.println(1);
				else System.out.println(0);
				break;
			default :
				if(stack.empty()) System.out.println(-1);
				else System.out.println(stack.peek());
				break;
			}

		}
	}

}