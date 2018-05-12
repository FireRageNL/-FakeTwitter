package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

@ServerEndpoint("/socket/{username}")
public class Sock {

	@OnOpen
	public void open(Session session, @PathParam("username") String username){
		Listner.getInstance().getSessionMap().put(username,session);
	}

	@OnClose
	public void close(Session session, @PathParam("username") String username){
		Listner.getInstance().getSessionMap().remove(username);
	}
}
