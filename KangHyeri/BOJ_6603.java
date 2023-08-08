package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int n;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n == 0)  // 수의 개수가 0개인 경우, for 문을 빠져나가도록 예외 처리
                break;

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visit = new boolean[n];
            back(0, 0);

            System.out.println(sb);

        }

    }

    static void back(int start, int depth) {
        if (depth == 6) {  // 종료 조건: 수가 6개 다 뽑힌 경우
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {  // 종료 조건 아닌 경우: 수를 더 뽑아야함, 방문 배열 설정하여 뽑기
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                back(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}