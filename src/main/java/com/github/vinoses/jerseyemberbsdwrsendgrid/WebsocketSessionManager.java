package com.github.vinoses.jerseyemberbsdwrsendgrid;

import javax.websocket.Session;

public class WebsocketSessionManager {
  Session session;

  private static WebsocketSessionManager ourInstance = new WebsocketSessionManager();

  public static WebsocketSessionManager getInstance() {
    return ourInstance;
  }

  private WebsocketSessionManager() {
  }

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }
}
