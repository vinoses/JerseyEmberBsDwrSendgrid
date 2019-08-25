package com.github.vinoses.jerseyemberbsdwrsendgrid;

public class EmailHandler {

    public EmailHandler() {}

    public int getEmailCount(){
        EmailCounter emailCounter = EmailCounter.getInstance();
        return emailCounter.getEmailCount();
    }

}
