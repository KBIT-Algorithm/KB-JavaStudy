package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())}); // offer = 리스트의 마지막에 특정요소 추가, 새로운 배열 생성
			}
			
			int count = 0;
			
			while(!q.isEmpty()){
				int[] front = q.poll(); //맨앞의 요소를 가져옴과 동시에 요소 제거
				boolean isMax = true;
				
				for(int i=0; i<q.size(); i++) {
					if(front[1]<q.get(i)[1]) { // 큐의 형태로 저장되는 int[]{ , } 형태의 값을 가져옴.						q.offer(front);
						for(int j=0;j<i;j++) {
							q.offer(q.poll());
						}
						
						isMax = false;
						break;
					}
				}
				
				if(isMax==false) {
					continue;
				}
				
				count++;
				if(front[0]==M) {
					break;
				}
			}
			
			sb.append(count).append('\n');
			
			
		}
		System.out.println(sb);
	}

}

//참고 : https://st-lab.tistory.com/201
