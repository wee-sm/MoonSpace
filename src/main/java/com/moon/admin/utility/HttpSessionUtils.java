package com.moon.admin.utility;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
	public static final String USER_SESSIO_KEY = "sessionedUser";
	
	public static boolean isLoginUser(HttpSession session) {
		Object sessionedUser = session.getAttribute(USER_SESSIO_KEY);
		if(sessionedUser == null) {
			return false;
		}
		return true;
	}
}
