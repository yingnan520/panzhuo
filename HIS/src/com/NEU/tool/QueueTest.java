package com.NEU.tool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> patientQueue = new LinkedList<Integer>();
		
		while (true) {
			
			boolean flag1 = true;
			boolean flag2 = true;
			
			while (flag1) {
				System.out.println("添加一个数字：");
				int i = sc.nextInt();
				if( i == 0 ) {
					flag1 = false;
				}else {
					patientQueue.offer(i);
					for (int j : patientQueue) {
						System.out.println(j);
					}
				}
			}
			while (flag2) {
				System.out.println("输入1继续，输入0退出");
				int j = sc.nextInt();
				if (j == 1) {
					System.out.println("删除第一个数字：");
					patientQueue.poll();
					for (int k : patientQueue) {
						System.out.println(k);
					}
				}else if (j == 0) {
					flag2 = false;
				}
			}
			
				
		}

	}

}
