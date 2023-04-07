package com.javalab.thread.pkg04;

import javax.swing.JOptionPane;

/*
 * [멀티 스레드]
 *  - 사용자에게 입력받는 부분과 숫자 출력하는 부분을 각각의 스레드로 구현
 *  - 사용자의 입력이 끝나지 않아도 화면에 숫자가 출력된다.
 */
public class ThreadEx07 {
	public static void main(String[] args) throws Exception {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		
	}
}

class ThreadEx7_1 extends Thread{
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
				} catch (Exception e) {
			}
		}
	}
}