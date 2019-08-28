package com.github.vinoses.jerseyemberbsdwrsendgrid;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint(value = "/websocket")
public class WebsocketServerEndpointSendgridCounter {

  public WebsocketServerEndpointSendgridCounter() {
  }

  @OnMessage
    public void onMessage(String message, Session session)
        throws IOException, InterruptedException {

      // Print the client message for testing purposes
      System.out.println("Client message : " + message);
      WebsocketSessionManager.getInstance().setSession(session);
      // Send response message to the client
     // session.getBasicRemote().sendText("UPDATE");

    }

    @OnOpen
    public void onOpen() {
      System.out.println("Client connected");
    }

    @OnClose
    public void onClose() {
      System.out.println("Connection closed");
    }
  }

