package net.tncy.tool;

import javax.servlet.http.HttpSession;

public class User
{
	public static boolean isConnected(HttpSession session)
	{
		if(session.getAttribute("connected") != null)
			return true;
		return false;
	}
}
