package com.github.vinoses.jerseyemberbsdwrsendgrid;

public class DWRSendgridEmailCounterHandler {
    SendgridEmailSingletonCounter emailCounter;

    public DWRSendgridEmailCounterHandler() {
        emailCounter = SendgridEmailSingletonCounter.getInstance();
    }

    public int getEmailCountSent(){
        return emailCounter.getEmailCountSent();
    }

    public int getEmailCountProcessed(){
        return emailCounter.getEmailCountProcessed();
    }

    public int getEmailCountDelivered(){
        return emailCounter.getEmailCountDelivered();
    }


    public int getEmailCountOpened(){
        return emailCounter.getEmailCountOpened();
    }

    public int getEmailCountClicked(){
        return emailCounter.getEmailCountClicked();
    }

    public int getEmailCountFailed(){
        return emailCounter.getEmailCountFailed();
    }

}
