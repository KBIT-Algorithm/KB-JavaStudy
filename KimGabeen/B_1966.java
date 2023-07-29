package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1966{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int TC = Integer.parseInt(st.nextToken());
		
		for(int tc=0; tc<TC; tc++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			ArrayList<Integer> arrIdx = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//입력 순서대로 큐에 삽입하고 삽입된 원소가 몇번째로 삽입된 값인지 구분하기 위한 인덱스를 리스트에 저장 
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				arrIdx.add(i);
			}
			//문서가 1개일 때는 중요도를 비교할 필요가 X 따라서 큐를 비우고 다음 테스트 케이스로 ...
			if (N==1) {
				queue.poll();
				System.out.println(1);
				continue;
			}
			
			// 몇 번째로 출력되는지 구하기 위한 카운트 변수 
			int cnt = 0;	
			//큐가 다 비면 프린터 작동이 끝난 것
			while(!queue.isEmpty()) {
				//max값 찾기 -> 중요도가 높은 문서가 최상단에 있을 때 출력되기 떄문
				int max = Collections.max(queue);
				int maxIdx = ((LinkedList<Integer>)queue).indexOf(max);
				
				//Max-1번째 까지 삭제, 삽입을 반복해야 함. 따라서 maxidx(Max-1)만큼 삭제 삽입 반복 
				for(int i=0;i<maxIdx;i++) {
					//큐와 인덱스 리스트 같은 작업 진행 -> 그래야 나중에 중복이 있어도 인덱스를 통해 구분 가능
					int num = queue.poll();
					int numIdx = arrIdx.remove(0);
					
					queue.offer(num);
					arrIdx.add(numIdx);
				}
				//for문 끝나면 최상단의 값이 중요도가 MAX임. 
				queue.poll();
				int temp = arrIdx.remove(0);
				
				cnt++;
				//만약 최상단 값의 인덱스가 우리가 처음에 궁금했던 문서의 위치와 같다면 정답임.
				if(temp==M) break;
				
			}
			System.out.println(cnt);
		}
		
		
	}

}
