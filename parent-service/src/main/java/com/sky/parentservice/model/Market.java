package com.sky.parentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Market  implements BaseDto{
    //header
    private Integer msgId;
    private String operation;
    private String type;
    private String timeStamp;

    //body
    private String eventId;
    private String marketId;
    private String name;
    private String displayed;
    private String suspended;

    @Override
    public String toString() {
        return "MarketEntity{" +
                "msgId=" + msgId +
                ", operation='" + operation + '\'' +
                ", type='" + type + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", eventId='" + eventId + '\'' +
                ", marketId='" + marketId + '\'' +
                ", name='" + name + '\'' +
                ", displayed='" + displayed + '\'' +
                ", suspended='" + suspended + '\'' +
                '}';
    }
}
