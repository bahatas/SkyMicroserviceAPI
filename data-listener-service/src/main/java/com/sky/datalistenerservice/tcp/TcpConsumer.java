package com.sky.datalistenerservice.tcp;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@MessageEndpoint
@Component
@Slf4j
public class TcpConsumer {


    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;



    @ServiceActivator(inputChannel = "feed me")
    public void dataConsumertoString(byte[] dataBytes) {
        log.info("publishing incoming stream data");
        String data = new String(dataBytes);
        DataEvent dataEvent = new DataEvent(data, "new Data");
        applicationEventPublisher.publishEvent(dataEvent);




    }




}


/*

146669
update
outcome
1653042879923
d89862e6-53f4-4b3b-86d4-ed79ae2e4626
2395a236-91ef-4872-b586-380e3f101000
\
Wigan\
 +2
3/1
1
0


146670
update
outcome
1653042880069
a2ab7030-039d-4b99-9c72-376ae2a7415f
c686db4a-6c15-4a50-a9b2-b3caf1da3a5f
\
Rafael Nadal\

8/1
1
0
 */