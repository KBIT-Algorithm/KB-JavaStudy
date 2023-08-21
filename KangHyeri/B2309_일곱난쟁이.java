package work02_algorithm;

import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309_일곱난쟁이 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int[] arr = new int[9];
	        int sum = 0;
	        // 난쟁이 9명 키의 합
	        for (int i = 0; i < 9; i++) {
	            arr[i] = Integer.parseInt(br.readLine());
	            sum += arr[i];
	        }
	        
	        // 난쟁이 9명 키의 합에서 2명씩 빼줌 
	        // 이중 for문으로 완탐
	        // 합이 100이면 출력 
	        for (int i = 0; i < 8; i++) {
	            for (int j = i+1; j < 9; j++) {
	                if (sum - arr[i] - arr[j] == 100) {
	                    arr[i] = 0;
	                    arr[j] = 0;
	                    // 오름차순으로 정렬해서 하나씩 출력
	                    Arrays.sort(arr);
	                    for (int k = 2; k < 9; k++) {
	                        System.out.println(arr[k]);
	                    }
	                    return;
	                }
	            }
	        }

	}

}
