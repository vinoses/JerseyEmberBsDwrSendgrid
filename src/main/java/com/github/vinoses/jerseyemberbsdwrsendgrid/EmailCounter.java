package com.github.vinoses.jerseyemberbsdwrsendgrid;

public class EmailCounter {
    private int emailCount;
    private static EmailCounter ourInstance = new EmailCounter();

    public static EmailCounter getInstance() {
        return ourInstance;
    }

    private EmailCounter() {
        emailCount = 0;
    }

    public void addEmail(){
        emailCount++;
    }

    public int getEmailCount(){
        return emailCount;
    }

}
