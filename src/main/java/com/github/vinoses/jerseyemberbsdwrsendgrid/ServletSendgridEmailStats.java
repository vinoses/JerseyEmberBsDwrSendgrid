package com.github.vinoses.jerseyemberbsdwrsendgrid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.protocol.HttpContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.*;

//not working, unable to capture async response, possible bad url for api

@WebServlet(name = "EmailStatsServlet", urlPatterns="/stats")
public class ServletSendgridEmailStats extends HttpServlet {

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        try {
            // Start the client
            httpclient.start();

            URIBuilder builder = new URIBuilder("http://www.apache.org/");
            builder.addParameter("Authorization", "Bearer" +  System.getenv("SENDGRID_API_KEY"));

            // Test Execute request
            // use a callback for operation result
            final CountDownLatch latch1 = new CountDownLatch(1);
            final HttpGet request2 = new HttpGet(builder.build());
            httpclient.execute(request2, new FutureCallback<HttpResponse>() {
                public void completed(final HttpResponse response2) {
                    latch1.countDown();
                    String status = response2.getStatusLine().toString();
                    System.out.println(request2.getRequestLine() + "->" + status);
                    if("200".equals(status)){
                        System.out.println(response2.getAllHeaders());
                    }
                }
                public void failed(final Exception ex) {
                    latch1.countDown();
                    System.out.println("Failed async response for request2.getRequestLine() ->" + ex);
                }
                public void cancelled() {
                    latch1.countDown();
                    System.out.println(request2.getRequestLine() + " cancelled");
                }
            });
            latch1.await();


            URIBuilder builder3 = new URIBuilder("https://api.sendgrid.com/v3/stats?aggregated_by=day");
            builder3.addParameter("Authorization", "Bearer" +  System.getenv("SENDGRID_API_KEY"));


            // also want to stream
            // request and response body content
            final CountDownLatch latch2 = new CountDownLatch(1);
            final HttpGet request3 = new HttpGet(builder3.build());
            request3.addHeader("Authorization", "Bearer" + System.getenv("SENDGRID_API_KEY"));

            HttpAsyncRequestProducer producer3 = HttpAsyncMethods.create(request3);
            AsyncCharConsumer<HttpResponse> consumer3 = new AsyncCharConsumer<HttpResponse>() {

                HttpResponse response;
                @Override
                protected void onResponseReceived(final HttpResponse response) {
                    this.response = response;
                }
                @Override
                protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl) throws IOException {
                    System.out.println(buf.toString() + " " + ioctrl.toString());
                }
                @Override
                protected void releaseResources() {
                }
                @Override
                protected HttpResponse buildResult(final HttpContext context) {
                    return this.response;
                }

            };

            httpclient.execute(producer3, consumer3, new FutureCallback<HttpResponse>() {

                public void completed(final HttpResponse response3) {
                    latch2.countDown();
                    System.out.println(request3.getRequestLine() + "->" + response3.getStatusLine());
                }

                public void failed(final Exception ex) {
                    latch2.countDown();
                    System.out.println(request3.getRequestLine() + "->" + ex);
                }

                public void cancelled() {
                    latch2.countDown();
                    System.out.println(request3.getRequestLine() + " cancelled");
                }

            });
            latch2.await();

        } catch(Exception e) {
            System.out.println("Exception in EmailStatsServlet " + e);
        }
        finally
         {
            httpclient.close();
         }

        //        try {
////            SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
////            System.out.println("EmailStatesServlet doPost /stats entry ");
////            String pattern = "yyyy-MM-dd";
////            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
////            String date = simpleDateFormat.format(new Date());
////
////            Request sgRequest = new Request();
////            sgRequest.setMethod(Method.GET);
////            sgRequest.setBaseUri("https://api.sendgrid.com/v3/stats?aggregated_by=day");
////            sgRequest.addHeader("Authorization", "Bearer" + System.getenv("SENDGRID_API_KEY"));
////            sgRequest.addHeader("Accept", "application/json");
////            sgRequest.setEndpoint("/stats");
////            sgRequest.setBody("{api_user=vinoses&api_key=" + System.getenv("SENDGRID_API_KEY") + "&start_date=2019-08-24&end_date=2019-08-25&data_type=global}");
////
////            Response sgresponse = new Response();
////
////            ExecutorService executor = Executors.newFixedThreadPool( 10 );
////
////            Future< Response > result = executor.submit( new Callable< Response >(sgRequest) {
////                @Override
////                public Response call() throws Exception {
////                    return sg.api(sgRequest);
////                }
////            } );
//
//            System.out.println("EmailStatesServlet doPost /stats status: " + result.get().getStatus());
//            System.out.println("sgResponse : " + fresponse.get().getHeaders());
//        }catch(Exception e){
//            System.out.println("Exception in EmailStatsServlet : " + e);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
