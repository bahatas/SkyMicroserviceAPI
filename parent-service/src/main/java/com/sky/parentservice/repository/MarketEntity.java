package com.sky.parentservice.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoRepositories
public class MarketEntity {



    //header
    @Id
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
