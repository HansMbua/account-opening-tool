package com.love2code.accountopeningtool.Exception;

public interface Responds {

   int getStatus();
   void setStatus(int status);

   String getMessage();

    void setMessage(String message);

    long getTimeStamp();

     void setTimeStamp(long timeStamp);

}
