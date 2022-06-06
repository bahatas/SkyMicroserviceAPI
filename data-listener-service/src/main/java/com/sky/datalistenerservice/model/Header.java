package com.sky.datalistenerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Header {
    //header
    private Integer msgId;
    private String operation;
    private String type;
    private String timeStamp;
}
