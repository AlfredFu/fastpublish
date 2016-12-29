package me.wmn.demo.concurrent;

import java.util.Date;
import java.util.concurrent.Executor;

public class ExecutorDemo implements Executor{

	public static void main(String[] args) {
		ExecutorDemo ed = new ExecutorDemo();
		TimeOut to = new TimeOut();
		
		ed.execute(to);
	}

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}

}

class TimeOut implements Runnable{

	@Override
	public void run() {
		int i =  0;
		while(i < 10){
			System.out.println(new Date());
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
