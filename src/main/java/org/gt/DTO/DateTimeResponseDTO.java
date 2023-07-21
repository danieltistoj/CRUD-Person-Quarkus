package org.gt.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeResponseDTO {
    private String message;
    private String date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void TimeDate(){
        LocalDateTime currentDateTime= LocalDateTime.now();
        String currentTimeDateFormatted = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.date = currentTimeDateFormatted;
    }
}
