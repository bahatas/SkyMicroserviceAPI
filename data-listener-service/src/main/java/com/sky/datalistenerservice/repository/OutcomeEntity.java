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
public class OutcomeEntity implements BaseDto {
    //header
    @Id
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
        return "OutcomeEntity{" +
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
