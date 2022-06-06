package com.sky.datalistenerservice.repository;


import com.sky.datalistenerservice.model.BaseDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoRepositories
public class MarketEntity implements BaseDto {
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
