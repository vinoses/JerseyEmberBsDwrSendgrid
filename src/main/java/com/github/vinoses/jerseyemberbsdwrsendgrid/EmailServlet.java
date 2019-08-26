package com.github.vinoses.jerseyemberbsdwrsendgrid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "EmailServlet", urlPatterns = {"/emailservice"})
public class EmailServlet extends HttpServlet {

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)  {
        Email from = new Email("test@example.com");
        String subject = "Sendgrid Email, hidden image attached";
        Email to = new Email("vinoses@hotmail.com");
        Content content = new Content("text/html",
                "<p>With Java everything is easy!</p>" +
                        "<br/>" +
                        "<a href='http://www.google.com'>Tracking Link</a>");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            System.out.println("EmailServlet processing email Sendgrid Post event");
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sg.api(request);
            System.out.println("EmailServlet processed email through Sendgrid with response: " + response.getStatusCode());

            System.out.println("EmailServlet email Sendgrid response callback: ");
            Gson gson = new Gson();
            Object json = gson.fromJson(httpRequest.getReader(), Object.class);
            gson = new GsonBuilder().setPrettyPrinting().create();
            String callbackPayload = gson.toJson(json);
            System.out.println(callbackPayload);

            EmailCounter.getInstance().addEmail();
        } catch (Exception e) {
            System.out.println("Exception in EmailServlet.doPost(), processing mail request to sendgrid: " + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
