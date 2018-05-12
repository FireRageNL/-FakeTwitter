package websocket;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listner {

	private static List<String> users;
	private static Listner listen = null;
	private static Map<String,Session> sessionMap;

	protected Listner(){
		users = new ArrayList<>();
		sessionMap = new HashMap<>();
	}

	public static Listner getInstance(){
		if(listen == null){
			listen = new Listner();
		}
		return listen;
	}

	public List<String> getUsers(){
		return users;
	}

	public Map<String,Session> getSessionMap(){
		return sessionMap;
	}


}
