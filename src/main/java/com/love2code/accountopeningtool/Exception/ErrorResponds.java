package com.love2code.accountopeningtool.Exception;

public interface ErrorResponds {

    public int getStatus();
    public void setStatus(int status);

    public String getMessage();

    public void setMessage(String message);

    public long getTimeStamp();

    public void setTimeStamp(long timeStamp);

}
