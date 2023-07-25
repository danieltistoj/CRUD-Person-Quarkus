package org.gt.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeResponseDTO {
    private Object message;
    private String date;
    private int statusCode;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void TimeDate(){
        LocalDateTime currentDateTime= LocalDateTime.now();
        String currentTimeDateFormatted = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.date = currentTimeDateFormatted;
    }
}
