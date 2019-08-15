package core;


import java.io.IOException;
import java.util.*;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatserver")
public class WebSocketChatServer {

	private static Set<Session> clients=Collections.synchronizedSet(new HashSet<Session>());
	
	@OnMessage
	public void onMessage(String message,Session session) throws IOException {
		System.out.println(message);
	for(Session client:clients) {
		client.getBasicRemote().sendText(message);
	}
	}
	@OnOpen
	public void onOpen(Session session) {
		clients.add(session);
	}
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
}
