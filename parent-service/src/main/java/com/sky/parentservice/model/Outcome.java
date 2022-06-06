package com.sky.parentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Outcome implements BaseDto{
    //header
    private Integer msgId;
    private String operation;
    private String type;
    private String timeStamp;

    //body
    private String marketId;
    private String outcomeId;
    private String name;
    private String price;
    private String displayed;
    private String suspended;


    @Override
    public String toString() {
        return "Outcome{" +
                "msgId=" + msgId +
                ", operation='" + operation + '\'' +
                ", type='" + type + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", marketId='" + marketId + '\'' +
                ", outcomeId='" + outcomeId + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", displayed='" + displayed + '\'' +
                ", suspended='" + suspended + '\'' +
                '}';
    }
}
