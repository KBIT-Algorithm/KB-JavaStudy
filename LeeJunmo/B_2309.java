package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgTest {
	
    static int faker1 = 0;
    static int faker2 = 0;
    static int sum = 0;
    // 거짓말쟁이 둘의 키와 합
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] array = new int [9];
        // 일곱난쟁이와 두명의 거짓말쟁이의 배열

        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }

        Arrays.sort(array);
        // 정렬

        int counter = 0;

        for(int i = 0; i < array.length; i++) {
            if (counter == 1) break;
            for(int j = array.length - 1; i != j ; j--) {
                // 가장 작은 난쟁이와 큰난쟁이를 비교
            	if (counter == 1) break;
                if(sum - ( array[i] + array[j]) == 100) {
                    faker1 = i;
                    faker2 = j;
                    counter++;
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            if(i == faker1 || i == faker2) {
            	// 찾으면 출력
                continue;
            }
            else System.out.println(array[i]);

        }
    }
}