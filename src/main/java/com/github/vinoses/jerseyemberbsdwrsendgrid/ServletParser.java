package com.github.vinoses.jerseyemberbsdwrsendgrid;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;

import static com.google.gwt.user.client.Window.Location.getPort;

@WebServlet(urlPatterns = {"/ServletParser"})
public class ServletParser extends HttpServlet {

  @Produces(MediaType.APPLICATION_JSON)
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("Webhook: Sendgrid Email POST Callback - Entry");
    try {


      SendgridEmailVO vo = new SendgridEmailVO();

      try {
        JsonReader jsonReader = Json.createReader(new BufferedReader(request.getReader()));
        JsonArray json = jsonReader.readArray();
        jsonReader.close();

        for (int i = 0; i < json.size(); i++) {
          for (String key : json.get(i).asJsonObject().keySet()) {

            switch (key) {
              case "email":
                vo.setEmail(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "event":
                vo.setEvent(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "ip":
                vo.setIp(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "response":
                vo.setResponse(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "sg_event_id":
                vo.setSg_event_id(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "smtp_id":
                vo.setSmtp_id(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "sg_message_id":
                vo.setSg_message_id(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "timestamp":
                vo.setTimestamp(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              case "tls":
                vo.setTls(json.getJsonObject(i).get(key).toString().replaceAll("\"", ""));
                break;
              default:
                break;
            }
          }
        }



        System.out.println("Webhook: Sendgrid Email POST Callback - Processed request as :\n" + vo.toString());
        parseEvent(vo, request);
      } catch (Exception e) {
        System.out.println("Exception parsing event : " + e);
      }
    } catch(Exception e) {
      System.out.println("Exception - Webhook: Sendgrid Email POST Callback - processing Websocket : " + e);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  private void parseEvent(SendgridEmailVO vo, HttpServletRequest request){
    System.out.println("Webhook: Sendgrid Email POST Callback - Parsing request");
    String event = vo.getEvent();
    SendgridEmailSingletonCounter counter = SendgridEmailSingletonCounter.getInstance();
    if(null != event && event.length() > 0) {
      switch (event) {
        case "processed" :
          counter.addEmailProcessed();
          System.out.println("Webhook: Sendgrid Email POST Callback - Parsed request as : " + event);
          break;
        case "open" :
          counter.addOpened();
          System.out.println("Webhook: Sendgrid Email POST Callback - Parsed request as : " + event);
          break;
        case "click" :
          counter.addClicked();
          System.out.println("Webhook: Sendgrid Email POST Callback - Parsed request as : " + event);
          break;
        default :
          counter.addFailed();
          System.out.println("INFO - Webhook: Sendgrid Email POST Callback - Did not parse event : " + event);
      }
      try {
          WebsocketClientEndpointSendgridCounter client = new WebsocketClientEndpointSendgridCounter();
          client.onMessage(WebsocketSessionManager.getInstance().getSession());
      } catch(Exception e){
        System.out.println("Exception - Webhook: Sendgrid Email POST Callback - WebSocket error :" + e);
      }
    }
  }
}
