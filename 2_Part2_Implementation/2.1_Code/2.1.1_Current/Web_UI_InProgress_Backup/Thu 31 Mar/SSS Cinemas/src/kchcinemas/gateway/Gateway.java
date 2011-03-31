package kchcinemas.gateway;

// This is where all the intercommunication takes place between the java backend system and the java webui system.

import java.util.HashMap;

// Until the two are linked, it will contain only fake methods.
public class Gateway {
	private static HashMap<String,String> mapUsers = new HashMap<String, String>();
	static {
		mapUsers.put("admin", "god");
	}

	public static boolean login(String strUsername, String strPassword) {
		if (mapUsers.containsKey(strUsername)) {
			if (mapUsers.get(strUsername).equals(strPassword)) {
				return true;
			}
		}
		return false;
	}
}
