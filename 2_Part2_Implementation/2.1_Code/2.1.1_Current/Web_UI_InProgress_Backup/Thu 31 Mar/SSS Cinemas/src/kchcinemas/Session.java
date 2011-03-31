package kchcinemas;

import kchcinemas.gateway.Gateway;
import java.util.Date;

/**
 *
 * @author darthcrap
 */
public class Session {
	private long lngLastUseTime = 0;
	private String strUserID = null;

	public Session() {
		updateUsageTime();
	}

	public long getLastUseTime() {
		return this.lngLastUseTime;
	}

	private void updateUsageTime() {
		this.lngLastUseTime = new Date().getTime();
	}

	public String getKey() {
		return SessionManager.findKey(this);
	}

	public boolean login(String strUsername, String strPassword) {
		updateUsageTime();
		if (!isLoggedIn()) {
			if (Gateway.login(strUsername,strPassword)) {
				this.strUserID = strUsername;
				return true;
			}
		}
		return false;
	}

	public boolean isLoggedIn() {
		return (this.strUserID != null);
	}
}
