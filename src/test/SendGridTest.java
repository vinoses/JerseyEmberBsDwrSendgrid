import com.sendgrid.*;
import org.junit.Assert;
import org.junit.Test;

import javax.json.*;
import javax.json.stream.JsonParser;
import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class SendGridTest {

    private final String SENDGRID_API_KEY = System.getenv("SENDGRID_API_KEY");

    public Map<String,String> buildDefaultHeaders() {
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Map<String,String> requestHeaders = new HashMap<String, String>();
        requestHeaders.put("Authorization", "Bearer " + SENDGRID_API_KEY);
        String USER_AGENT = "sendgrid/" + sg.getLibraryVersion() + ";java";
        requestHeaders.put("User-agent", USER_AGENT);
        requestHeaders.put("Accept", "application/json");
        return requestHeaders;
    }

    public String getMockJsonString(){
        return "[ { \"email\": \"vinoses@hotmail.com\", \"event\": \"processed\", \"send_at\": 0, \"sg_event_id\": \"cHJvY2Vzc2VkLTEyMjQ2MjY5LWRXQWdET1hhUTRxU0NnSWN5YzFfT3ctMA\", \"sg_message_id\": \"dWAgDOXaQ4qSCgIcyc1_Ow.filter0121p3las1-29797-5D655C8E-25.0\", \"smtp-id\": \"<dWAgDOXaQ4qSCgIcyc1_Ow@ismtpd0014p1las1.sendgrid.net>\", \"timestamp\": 1566923918 }, { \"email\": \"vinoses@hotmail.com\", \"event\": \"delivered\", \"ip\": \"167.89.105.232\", \"response\": \"250 2.6.0 <dWAgDOXaQ4qSCgIcyc1_Ow@ismtpd0014p1las1.sendgrid.net> [InternalId=37297496069442, Hostname=BN3NAM04HT102.eop-NAM04.prod.protection.outlook.com] 9764 bytes in 0.141, 67.260 KB/sec Queued mail for delivery -> 250 2.1.5\", \"sg_event_id\": \"ZGVsaXZlcmVkLTAtMTIyNDYyNjktZFdBZ0RPWGFRNHFTQ2dJY3ljMV9Pdy0w\", \"sg_message_id\": \"dWAgDOXaQ4qSCgIcyc1_Ow.filter0121p3las1-29797-5D655C8E-25.0\", \"smtp-id\": \"<dWAgDOXaQ4qSCgIcyc1_Ow@ismtpd0014p1las1.sendgrid.net>\", \"timestamp\": 1566923919, \"tls\": 1 } ]";
    }

    @Test
    public void testAPIKey(){
        System.out.println(SENDGRID_API_KEY);
    }

    @Test
    public void testJsonP(){

        JsonReader jsonReader = Json.createReader(new StringReader(getMockJsonString()));

        JsonArray json = jsonReader.readArray();

        jsonReader.close();

        for(int i =0; i<json.size(); i++){
            System.out.println(json.get(i));
            for(String key : json.get(i).asJsonObject().keySet()){
                System.out.println(key + " : " + json.getJsonObject(i).get(key));
            }
        }


    }

    @Test
    public void testAsyncJsonParsing() {
        final String result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":false}";
        final JsonParser parser = Json.createParser(new StringReader(getMockJsonString()));
        String key = null;
        String value = null;
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    key = parser.getString();
                    System.out.println(key);
                    break;
                case VALUE_STRING:
                    value = parser.getString();
                    System.out.println(value);
                    break;
            }
        }
        parser.close();
        assert(true);
    }

    @Test
    public void testInitialization() {
        try {
            SendGrid sg = new SendGrid(SENDGRID_API_KEY);
            Assert.assertEquals(sg.getHost(), "api.sendgrid.com");
            Assert.assertEquals(sg.getVersion(), "v3");

            Map<String, String> requestHeaders = buildDefaultHeaders();
            Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);

            Client client = mock(Client.class);
            sg = new SendGrid(SENDGRID_API_KEY, client);
            Request request = new Request();
            sg.makeCall(request);
            verify(client).api(request);

            Assert.assertEquals(sg.getLibraryVersion(), "3.0.0");

            sg.addRequestHeader("Test", "one");
            requestHeaders.put("Test", "one");
            Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);

            sg.removeRequestHeader("Test");
            requestHeaders.remove("Test");
            Assert.assertEquals(sg.getRequestHeaders(), requestHeaders);

            sg.setHost("api.new.com");
            Assert.assertEquals(sg.getHost(), "api.new.com");

            sg.setRateLimitRetry(100);
            Assert.assertEquals(sg.getRateLimitRetry(), 100);

            sg.setRateLimitSleep(999);
            Assert.assertEquals(sg.getRateLimitSleep(), 999);

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
//
//    @Test
//    public void test_async() {
//        final Object sync = new Object();
//        SendGrid sg = null;
//
//        sg = new SendGrid("SENDGRID_API_KEY", true);
//        sg.addRequestHeader("X-Mock", "200");
//        Request request = new Request();
//
//        request.setMethod(Method.POST);
//        request.setBaseUri("https://api.sendgrid.com/v3/stats?aggregated_by=day");
//        request.setEndpoint("access_settings/activity");
//        request.addQueryParam("limit", "1");
//        request.setBody("{api_user=vinoses&api_key=" + System.getenv("SENDGRID_API_KEY") + "&start_date=2019-08-24&end_date=2019-08-25&data_type=global}");
//
//        sg.attempt(request, new APICallback() {
//            @Override
//            public void error(Exception e) {
//                System.out.println(e);
//                Assert.fail();
//                synchronized(sync) {
//                    sync.notify();
//                }
//            }
//
//            @Override
//            public void response(Response response) {
//                Assert.assertEquals(200, response.getStatusCode());
//
//                synchronized(sync) {
//                    System.out.println(response.getHeaders());
//                    sync.notify();
//                }
//            }
//        });
//
//        try {
//            synchronized(sync) {
//                sync.wait(80000);
//            }
//        } catch(InterruptedException ex) {
//            Assert.fail(ex.toString());
//        }
//    }
//
//    @Test
//    public void test_async_rate_limit() {
//        final Object sync = new Object();
//        SendGrid sg = null;
//
//        sg = new SendGrid("SENDGRID_API_KEY", true);
//        sg.setHost("localhost:4010");
//
//        sg.addRequestHeader("X-Mock", "429");
//
//        Request request = new Request();
//
//        request.setMethod(Method.GET);
//        request.setEndpoint("access_settings/activity");
//        request.addQueryParam("limit", "1");
//        sg.attempt(request, new APICallback() {
//            @Override
//            public void error(Exception e) {
//                Assert.assertEquals(e.getClass(), RateLimitException.class);
//                sync.notify();
//            }
//
//            @Override
//            public void response(Response response) {
//                Assert.fail();
//                sync.notify();
//            }
//        });
//
//        try {
//            synchronized(sync) {
//                sync.wait(2000);
//            }
//        } catch(InterruptedException ex) {
//            Assert.fail(ex.toString());
//        }
//    }
//
//    @Test
//    public void test_access_settings_activity_get() {
//        try {
//            SendGrid sg = new SendGrid("SENDGRID_API_KEY", true);
//
//            Request request = new Request();
//            request.setMethod(Method.GET);
//            request.setEndpoint("/stats");
//            request.setBaseUri("https://api.sendgrid.com/v3/categories/stats?start_date=2015-01-01&end_date=2015-01-02&categories=cat1&categories=cat2");
//            request.setBody("{}");
//            request.addHeader("Authorization", "Bearer " + SENDGRID_API_KEY);
//            request.addQueryParam("limit", "1");
//            Response response = sg.api(request);
//            Assert.assertEquals(200, response.getStatusCode());
//        } catch(Exception e){
//            System.out.println("Exception : " + e);
//        }
//    }


}