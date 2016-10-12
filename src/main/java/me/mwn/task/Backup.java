package me.mwn.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Backup {

	/**
	 * 每隔5秒钟的定时任务
	 */
	@Scheduled(cron="0/5 * * * * *")
	public void backupPackage(){
		//System.out.println("task sample");
	}
}
