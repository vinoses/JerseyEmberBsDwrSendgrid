package com.github.vinoses.jerseyemberbsdwrsendgrid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebServlet(name = "EmailEventServlet", urlPatterns = {"/payload"})
public class EmailEventServlet extends HttpServlet {

    @Produces(MediaType.APPLICATION_JSON)
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            System.out.println("EmailEventServlet processing Sendgrid Post event");
            Gson gson = new Gson();
            Object json = gson.fromJson(request.getReader(), Object.class);
            gson = new GsonBuilder().setPrettyPrinting().create();
            String callbackPayload = gson.toJson(json);
            System.out.println(callbackPayload);

        } catch (Exception e) {
            System.out.println("Exception in EmailEventServlet.doPost() while processing event callbackPayout :" + e);
        }
    }

    public void doGet(HttpServletRequest requests, HttpServletResponse response) {

    }

}
