package net.tncy.tool;

import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserServiceFactory;

public class User
{
	public static boolean isConnected(HttpSession session)
	{
		return UserServiceFactory.getUserService().isUserLoggedIn();
	}
}
