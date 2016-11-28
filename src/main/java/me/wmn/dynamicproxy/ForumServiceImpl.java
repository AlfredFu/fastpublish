package me.wmn.dynamicproxy;

public class ForumServiceImpl implements IForumService {

	@Override
	public void removeTopic(int id) {
		//PerformanceMonitor.begin("removeTopic");
		
		try{
			Thread.sleep(20);
		}catch(Exception e){
			
		}
		
		//PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int id) {
		//PerformanceMonitor.begin("removeTopic");
		
		try{
			Thread.sleep(20);
		}catch(Exception e){
			
		}
		
		//PerformanceMonitor.end();
	}

}
