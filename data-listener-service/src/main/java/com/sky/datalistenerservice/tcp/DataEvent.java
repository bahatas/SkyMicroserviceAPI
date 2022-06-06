package com.sky.datalistenerservice.tcp;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class DataEvent extends ApplicationEvent {

    private String message;


    public DataEvent(Object data, String message) {
        super(data);
        this.message = message;


    }
// todo it needs to be add to be able to make healtthy print
//    @Override
//    public String toString() {
//        return "DataEvent{" +
//                "message='" + message + '\'' +
//                ", source=" + source +
//                '}';
//    }
}
