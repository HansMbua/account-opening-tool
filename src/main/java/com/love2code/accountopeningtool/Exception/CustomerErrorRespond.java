package com.love2code.accountopeningtool.Exception;

public class CustomerErrorRespond implements ErrorResponds{

    private int status;
    private String message;
    private long timeStamp;

    public CustomerErrorRespond() {
    }

    public CustomerErrorRespond(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
      this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}