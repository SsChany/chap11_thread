package com.javalab.thread.pkg05;
/*
 * 동기화로 잔액이 마이너스가 되는 문제 해력
 */
public class ThreadSyncAfter {
   public static void main(String args[]) {
      Runnable r = new RunnableEx2();
      // 두 개의 스레드를 생성/실행시켜서 경쟁적으로 출금 
      Thread t1 = new Thread(r); 
      Thread t2 = new Thread(r);
      
      t1.start();
      t2.start();      
   }
} // end class

// 은행 계정 클래스
class  Account {
   private int balance = 1000;    // private으로 해야 동기화가 의미가 있다.


   // 잔액 확인 메소드
   public int getBalance() {
      return balance;
   }
   /*
    * [동기화 synchronized]
    * -하나의 스레드가 출금 메서드를 사용중이면 다른 스레드가 잠시
    * 대기하로독 synchronized(동기화)한다. 실행중인 작업이 끝나야
    * 다음 스레드가 출금을 진행한다
    */
   public synchronized void withdraw(int money){
      if(balance >= money) {
         try { 
            Thread.sleep(1000);
         } catch(InterruptedException e) {
         }
         balance -= money;   // 잔액 - 출금액 차감
      }
   }
}

// 출금을 실행하는 스레드 클래스
class RunnableEx2 implements Runnable {
	//필드
   Account acc = new Account(); // 은행 계정 객체 생성

   public void run() {
      while(acc.getBalance() > 0) {   // 은행 계정 클래스에서 잔액 확인
         // 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
         int money = (int)(Math.random() * 3 + 1) * 100;
         acc.withdraw(money); // 출금
         System.out.println("balance:" + acc.getBalance());
      }
   }
}
