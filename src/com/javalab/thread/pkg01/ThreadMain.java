package com.javalab.thread.pkg01;
/*
 * 실행 클래스
 */
public class ThreadMain {
	
	public static void main(String[] args) {
		
		//1. 위에서 정의 해놓은 MyThread 클래스 사용해서 스레드 객체 생성
		Mythread t1 = new Mythread();
		
		//스레드 실행
		t1.start();
	}

}
