package me.wmn.demo;

public class ThreadDemo1 {

	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my);
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.run();
	}

}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println(i);
		}
	}

}

class MyThread extends Thread{
	public void run(){
		for(int i = 0; i < 1000; i++){
			System.out.println(i);
		}
	}
}