package com.sky.datalistenerservice.service;




public interface DataService {
    void startConnection(String ip, int port);
    void getDataFromStream();
    Dto getDtoObjectFromStream();

    void save(BaseDto baseDto);
}
