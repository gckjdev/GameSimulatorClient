package com.orange.gameclient.draw.test.dao;

import java.util.HashMap;


public class SessionManager {
	private static HashMap<Long, Integer>sessionMap 
	= new HashMap<Long, Integer>();
	
	public static  void increaseCount(long sessionID)
	{
		synchronized (sessionMap) {	
			Integer countInteger = sessionMap.get(Long.valueOf(sessionID));
			if (countInteger != null) {
				countInteger = countInteger + 1;
			}else{
				countInteger = 1;
			}
			sessionMap.put(Long.valueOf(sessionID), countInteger);
		}
	}
	
	public static int count(long sessionID)
	{
		Integer countInteger = sessionMap.get(Long.valueOf(sessionID));
		if (countInteger == null) {
			return 0;
		}
		return countInteger;
	}
	
	public static String getString() {
		return sessionMap.toString();
	}
}
