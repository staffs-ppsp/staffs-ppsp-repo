package kchcinemas;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author darthcrap
 */
public class SessionManager {
	public static final Object LOCK_OBJECT_MAP = new Object();
	public static final Object LOCK_OBJECT_ALLOWANCE = new Object();
	private static final long EXPIRY_TIME = 120000;

	private static HashMap<String,Session> mapSessions = new HashMap<String,Session>();
	private static int intPrunerLocks = 0;
	private static Thread objSessionPruner = null;
	private static SecureRandom objRandom = new SecureRandom();

	private static class SessionPruner extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(10000);
				}
				catch (InterruptedException objException) {}
				synchronized (SessionManager.LOCK_OBJECT_ALLOWANCE) {
					if (intPrunerLocks > 0) {
						continue;
					}
				}
				synchronized (SessionManager.LOCK_OBJECT_MAP) {
					long lngTime = new Date().getTime();
					Iterator<Session> objIterator = mapSessions.values().iterator();
					while (objIterator.hasNext()) {
						Session objSession = objIterator.next();
						long lngDifference = (lngTime - objSession.getLastUseTime());
						if (lngDifference >= EXPIRY_TIME) {
							String strKey = objSession.getKey();
							objIterator.remove();
						}
					}
				}
			}
		}
	}

	private SessionManager() {}

	public static void initialize() {
		if (objSessionPruner == null) {
			objSessionPruner = new SessionPruner();
			objSessionPruner.start();
		}
	}

	public static void suspendPruner() {
		synchronized(SessionManager.LOCK_OBJECT_ALLOWANCE) {
			intPrunerLocks++;
		}
	}

	public static void restartPruner() {
		synchronized(SessionManager.LOCK_OBJECT_ALLOWANCE) {
			intPrunerLocks--;
		}
	}

	public static String findKey(Session objWantedSession) {
		String strKey = null;
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			for (Map.Entry<String,Session> objSessionEntry : mapSessions.entrySet()) {
				if (objSessionEntry.getValue() == objWantedSession) {
					strKey = objSessionEntry.getKey();
					break;
				}
			}
		}
		return strKey;
	}

	public static Session getSession(String strKey) {
		Session objSession = null;
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			objSession = mapSessions.get(strKey);
			if (objSession != null) {
					String strNewKey = createNewKey();
					System.out.println("Session " + strKey + " changed to " + strNewKey);
					mapSessions.put(strNewKey, objSession);
					mapSessions.remove(strKey);
			}
		}
		return objSession;
	}

	public static boolean hasSession(String strKey) {
		boolean boolExists = false;
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			boolExists = mapSessions.containsKey(strKey);
		}
		return (getSession(strKey) != null);
	}

	private static String createKey() {
		String strCredential = new BigInteger(32*4,objRandom).toString(1<<4);
		while (strCredential.length() < 32) {
			strCredential = "0" + strCredential;
		}
		return strCredential.toUpperCase();
	}

	private static String createNewKey() {
		String strKey;
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			while (mapSessions.containsKey(strKey = createKey())) {}
		}
		return strKey;
	}

	public static Session createSession() {
		Session objSession = new Session();
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			String strNewKey = createNewKey();
			System.out.println("Created session with ID " + strNewKey);
			mapSessions.put(strNewKey, objSession);
		}
		return objSession;
	}

	public static void printSessionSummary() {
		synchronized (SessionManager.LOCK_OBJECT_MAP) {
			long lngTime = new Date().getTime();
			for (Map.Entry<String,Session> objSessionEntry : mapSessions.entrySet()) {
				System.out.println("\tSession " + objSessionEntry.getKey() + " - Last Usage " + (lngTime-objSessionEntry.getValue().getLastUseTime()) + "ms ago");
			}
		}
	}
}
