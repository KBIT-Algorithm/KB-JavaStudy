package team;

/*
	순서대로 K번째 사람이 제거되고, 사람들끼리 원을 이루고 있기에 K-1번째까지는 삭제된 후 다시 삽입되어야 한다. 
	앞에서 pop한 것을 뒤에 다시 push해야 하므로 큐를 사용하는 것이 좋다고 판단.  
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//큐 생성 
		Queue<Integer> q = new LinkedList<>();
		// 정답에 문자열처리가 필요하여 스트링빌더에 값을 저장하고자 함.  
		StringBuilder ans= new StringBuilder();
		ans.append("<");
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//1~N번째까지 N명의 사람들끼리 원을 이루고 있으므로 1~N까지 큐에 삽입해줌.
		for(int n=1; n<=N; n++) q.add(n);
		

		//큐가 비기 전까지 원소를 제거+삽입을 반복해야함.  
		while(!q.isEmpty()) {
			//순서대로 K번쨰 사람을 제거함. 따라서 K-1번째까지는 삭제 후 뒤에 삽입하는 과정이 필요.
			//그러므로 총 K-1번 루프동안 삭제한 값을 그대로 다시 삽입해서 맨 끝으로 보내준다. 
			for(int i=0;i<K-1;i++) {
				q.add(q.poll());
			}
			//K번째가 되는 곳. 따라서 이 값은 삭제 후 정답처리 변수 ans에 담아준다. 
			ans.append(q.poll()).append(", ");
		}
		//while문을 탈출하면 마지막원소,(공백) 상태가 된다. 따라서 뒤에서 2개를 제거해준 뒤 >를 더해주어 요구하는 출력 형식을 맞춰준다.
		ans.delete(ans.length()-2, ans.length());
		ans.append(">");
		System.out.println(ans);	
	}

}
