package com.github.vinoses.jerseyemberbsdwrsendgrid;

import java.io.IOException;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;

@ClientEndpoint
public class WebsocketClientEndpointSendgridCounter {

  @OnOpen
  public void onOpen(Session session){
    System.out.println("Server connected...");
    try {
      session.getBasicRemote().sendText("start");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @OnMessage
  public void onMessage(Session session){
    System.out.println("Webhook: Sendgrid Email POST Callvack - Issuing update ");
    try {
      session.getBasicRemote().sendText("update");
    } catch (Exception ex) {
      System.out.println("Exception ex : " + ex);
    }
  }
}