package com.github.vinoses.jerseyemberbsdwrsendgrid;

public class SendgridEmailSingletonCounter {
    private int emailCountSent;
    private int emailCountOpened;
    private int emailCountClicked;
    private int emailCountFailed;
    private int emailCountDelivered;
    private int emailCountProcessed;

    private static SendgridEmailSingletonCounter ourInstance = new SendgridEmailSingletonCounter();

    public static SendgridEmailSingletonCounter getInstance() {
        return ourInstance;
    }

    private SendgridEmailSingletonCounter() {
        emailCountSent = 0;
        emailCountDelivered = 0;
        emailCountOpened = 0;
        emailCountFailed = 0;
        emailCountClicked = 0;
        emailCountProcessed = 0;
    }

    public void addEmailProcessed(){
        emailCountProcessed++;
    }

    public void addEmailDelivered(){
        emailCountDelivered++;
    }

    public void addEmailSent(){
        emailCountSent++;
    }

    public void addOpened(){
        emailCountOpened++;
    }

    public void addClicked(){
        emailCountClicked++;
    }

    public void addFailed(){
        emailCountFailed++;
    }

    public int getEmailCountProcessed(){
        return emailCountProcessed;
    }

    public int getEmailCountDelivered(){
        return emailCountDelivered;
    }

    public int getEmailCountClicked(){
        return emailCountClicked;
    }

    public int getEmailCountFailed(){
        return emailCountFailed;
    }

    public int getEmailCountOpened(){
        return emailCountOpened;
    }

    public int getEmailCountSent(){
        return emailCountSent;
    }

}
