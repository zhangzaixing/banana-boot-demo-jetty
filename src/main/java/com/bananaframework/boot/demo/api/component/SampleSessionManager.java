package com.bananaframework.boot.demo.api.component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appleframework.rop.session.Session;
import com.appleframework.rop.session.SessionManager;

/**
 * 
 *SampleSessionManager class
 *
 *@author zzx
 *@date 2017年12月26日 下午4:34:58
 */
public class SampleSessionManager implements SessionManager {

	protected final Logger logger = LoggerFactory.getLogger(SampleSessionManager.class);
	
	private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);
	
	@Override
	public void addSession(String sessionId, Session session) {
		sessionCache.put(sessionId, session);
	}

	@Override
	public Session getSession(String sessionId) {
		return sessionCache.get(sessionId);
	}

	@Override
	public void removeSession(String sessionId) {
		sessionCache.remove(sessionId);
	}

	@Override
	public Session createSession(Map<String, Object> map) {
		return null;
	}

}
