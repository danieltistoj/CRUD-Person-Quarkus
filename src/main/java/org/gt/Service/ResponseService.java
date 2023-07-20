package org.gt.Service;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Date;
@ApplicationScoped
public class ResponseService {
    private int code;
    private Date date;

    public Object Request(boolean status, String message){
        if(status){
            code = 200;
        }else{
            code = 401;
        }
        date = new Date();
        JsonObject json = new JsonObject();
        json.put("StatusCode", code);
        json.put("message",message);
        json.put("timestamp",date.toString());
        return json;
    }

}
