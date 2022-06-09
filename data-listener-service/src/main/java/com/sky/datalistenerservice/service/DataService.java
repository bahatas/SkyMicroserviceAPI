package com.sky.datalistenerservice.service;


import com.sky.parentservice.model.BaseDto;

public interface DataService {
    void startConnection(String ip, int port);
    void getDataFromStream();
    void save(BaseDto baseDto);
}
