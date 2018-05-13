package websocket;

import Entities.Account;
import Logic.Implementations.UserLogic;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

@ServerEndpoint("/socket/{username}")
public class Sock {

	@Inject
	UserLogic ul;

	@OnOpen
	public void open(Session session, @PathParam("username") String username){
		Listner.getInstance().getSessionMap().put(username,session);
	}

	@OnClose
	public void close(Session session, @PathParam("username") String username){
		Listner.getInstance().getSessionMap().remove(username);
	}

	@OnMessage
	public void onMessage(String message, Session session, @PathParam("username") String username){
		List<String> users = Listner.getInstance().getUsers();

		Account usr = ul.getUserFromDatabase(username);

		users.forEach(user -> {
				Listner.getInstance().getSessionMap().get(user).getAsyncRemote().sendText("\"" + message + "\" Has been posted by: " + username);
		});
	}
}
