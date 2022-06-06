package com.sky.parentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event implements BaseDto {
    //header
    private Integer msgId;
    private String operation;
    private String type;
    private String timeStamp;

    //body
    private String eventId;
    private String category;
    private String subCategory;
    private String name;
    private String startTime;
    private String displayed;
    private String suspended;

    @Override
    public String toString() {
        return "EventEntity{" +
                "msgId=" + msgId +
                ", operation='" + operation + '\'' +
                ", type='" + type + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", eventId='" + eventId + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", displayed='" + displayed + '\'' +
                ", suspended='" + suspended + '\'' +
                '}';
    }
}
