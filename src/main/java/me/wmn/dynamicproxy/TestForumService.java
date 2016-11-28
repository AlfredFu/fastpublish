package me.wmn.dynamicproxy;

import java.lang.reflect.Proxy;

public class TestForumService {

	public static void main(String[] args){
//		IForumService forumService = new ForumServiceImpl();
//		forumService.removeForum(1);
//		forumService.removeTopic(2);
		
		IForumService target = new ForumServiceImpl();
		
		PerformanceHandler handler = new PerformanceHandler(target);
		
		IForumService proxy = (IForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), 
				handler);
		proxy.removeForum(1);
		proxy.removeTopic(2);
		
		CglibProxy cglibProxy = new CglibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl)cglibProxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(1);
		forumService.removeTopic(2);
	}
}
