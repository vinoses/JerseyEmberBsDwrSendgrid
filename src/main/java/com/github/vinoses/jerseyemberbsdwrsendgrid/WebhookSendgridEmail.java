package com.github.vinoses.jerseyemberbsdwrsendgrid;

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
import javax.ws.rs.POST;
import java.io.IOException;

@WebServlet(urlPatterns={"/emailservice"})
public class WebhookSendgridEmail extends HttpServlet{

    @POST
    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        System.out.println("\nWebhook: Sendgrid Email POST event Entry ");
        //
        try {
            System.out.println("Webhook: Sendgrid Email POST event - request server port: " + httpRequest.getServerPort());

            if (httpRequest.getServerPort() == 8080) {
                         System.out.println("Webhook: Sendgrid Email POST event - send email entry ");
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

                        request.setMethod(Method.POST);
                        request.setEndpoint("mail/send");
                        request.setBody(mail.build());

                        Response response = sg.api(request);
                        System.out.println("Webhook: Sendgrid Email POST event - processed email with response: " + response.getStatusCode());

                        SendgridEmailSingletonCounter.getInstance().addEmailSent();

            } else {
              httpRequest.getRequestDispatcher("/ServletParser").forward(httpRequest, httpResponse);
            }
        }catch (Exception e) {
            System.out.println("Exception in EmailServlet.doPost(), processing mail request to sendgrid: " + e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Received a get request");
    }


}
