package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_스택 {
		public static int [] stack;
		public static int size=0;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		while(N-- >0) {//배열의 크기보다 작으면 작동할 수 없으므로
			st = new StringTokenizer(br.readLine()," ");
			
			switch(st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop":
				sb.append(pop()).append('\n'); //출력값처럼 출력하기 위해 StringBuilder 사용
				break;
				
			case "size":
				sb.append(size()).append('\n');
				break;
				
			case "empty":
				sb.append(empty()).append('\n');
				break;
				
			case "top":
				sb.append(top()).append('\n');
				break;
			
			}
		}
		
		System.out.println(sb);
		
		
	}

	public static void push(int p) {
		stack[size] = p;
		size++;
		
	}
	
	public static int pop() {
		if(size==0) {
			return -1;
		}else {
			int last = stack[size-1]; // 맨 위에 있는 값
			stack[size -1]=0;
			size--;
			return last;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		if(size==0) {
			return 1;
		}else {
			return 0;
		}
			
	}
	
	public static int top() {
		if(size==0) {
			return -1;
		} else {
			return stack[size-1];
		}
	}

}
