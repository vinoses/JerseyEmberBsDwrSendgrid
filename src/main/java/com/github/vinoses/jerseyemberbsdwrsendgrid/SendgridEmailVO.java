package com.github.vinoses.jerseyemberbsdwrsendgrid;

public class SendgridEmailVO {
    private String email;
    private String event;
    private String ip;
    private String response;
    private String sg_event_id;
    private String smtp_id;
    private String sg_message_id;
    private String timestamp;
    private String tls;

    @Override
    public String toString() {
        return "SendgridEmailVO{" +
                "email='" + email + '\'' +
                ", event='" + event + '\'' +
                ", ip='" + ip + '\'' +
                ", response='" + response + '\'' +
                ", sg_event_id='" + sg_event_id + '\'' +
                ", smtp_id='" + smtp_id + '\'' +
                ", sg_message_id='" + sg_message_id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", tls='" + tls + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getSg_event_id() {
        return sg_event_id;
    }

    public void setSg_event_id(String sg_event_id) {
        this.sg_event_id = sg_event_id;
    }

    public String getSmtp_id() {
        return smtp_id;
    }

    public void setSmtp_id(String smtp_id) {
        this.smtp_id = smtp_id;
    }

    public String getSg_message_id() {
        return sg_message_id;
    }

    public void setSg_message_id(String sg_message_id) {
        this.sg_message_id = sg_message_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTls() {
        return tls;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    public SendgridEmailVO(String email, String event, String ip, String response, String sg_event_id, String smtp_id, String sg_message_id, String timestamp, String tls) {
        this.email = email;
        this.event = event;
        this.ip = ip;
        this.response = response;
        this.sg_event_id = sg_event_id;
        this.smtp_id = smtp_id;
        this.sg_message_id = sg_message_id;
        this.timestamp = timestamp;
        this.tls = tls;
    }

    public SendgridEmailVO() {
    }
}
