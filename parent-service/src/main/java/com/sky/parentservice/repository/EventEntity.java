package com.sky.parentservice.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoRepositories
public class EventEntity {
    //header
    @Id
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
