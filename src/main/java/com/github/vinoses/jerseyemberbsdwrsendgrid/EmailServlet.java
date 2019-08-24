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

import java.io.IOException;

@WebServlet(name = "EmailServlet", urlPatterns = {"/emailservice"})
public class EmailServlet extends HttpServlet {

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        Email from = new Email("test@example.com");
        String subject = "Sendgrid Email, hidden image attached";
        Email to = new Email("vinoses@hotmail.com");
        Content content = new Content("text/plain", "With Java everything is easy!");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            if(response.getStatusCode() == 202){
                httpResponse.setStatus(202,"success");
            } else {
                httpResponse.setStatus(500,"error");
            }
;
        } catch (IOException ex) {
            throw ex;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
