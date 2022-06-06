package com.sky.datalistenerservice.service;

import com.sky.datalistenerservice.model.BaseDto;
import com.sky.datalistenerservice.model.Dto;


public interface DataService {
    void startConnection(String ip, int port);
    void getDataFromStream();
    Dto getDtoObjectFromStream();

    void save(BaseDto baseDto);
}
