package com.alg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlgTest {

	static int N;
	static ArrayList<Integer> array;
	static StringBuilder sb;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		array = new ArrayList<>();
		sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push":
				int number = Integer.parseInt(st.nextToken());
				push(number);
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "top":
				top();
				break;
			}
		}
		
		System.out.println(sb);
	
	}
	
	public static void push(int number) {
		array.add(number);
	}
	
	public static void pop() {
		if(array.isEmpty()) sb.append(-1).append("\n");
		else sb.append(array.remove(array.size() - 1)).append("\n");
	}
	
	public static void size() {
		sb.append(array.size()).append("\n");
	}
	
	public static void empty() {
		if(!array.isEmpty()) sb.append(0).append("\n");
		else sb.append(1).append("\n");
	}
	
	public static void top() {
		if(array.isEmpty()) sb.append(-1).append("\n");
		else sb.append(array.get(array.size() - 1)).append("\n");
	}

}
