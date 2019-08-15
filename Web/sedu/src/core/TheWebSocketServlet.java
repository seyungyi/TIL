package core;

import java.io.*;

import javax.websocket.*;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/TheWebSocketServlet")
public class TheWebSocketServlet {
@OnOpen
public void onOpen(Session session) {//연결된 클라이언트의 정보를가지고있는 세션객체
	try {
		session.getBasicRemote().sendText("Welcome!");
	}catch (IOException e){
		e.printStackTrace();
	}
}
@OnClose
public void onClose(Session session) {
	System.out.println("종료!!");
}
@OnMessage
public void onMessage(Session session,String message) {
	String s="-웹소켓 서버로 부터의 응답!!";
	try {
		if(message.equals("multimessage")) {
			for(int i=1;i<11;i++) {
				try {
					Thread.sleep(2000);
				}catch (Exception e) {
					
				}
				session.getBasicRemote().sendText(i+s);
			}
		}else {
			session.getBasicRemote().sendText("Echo ["+message+"]"+s);

		}
	}catch(IOException e) {
		e.printStackTrace();
	}
}

}
