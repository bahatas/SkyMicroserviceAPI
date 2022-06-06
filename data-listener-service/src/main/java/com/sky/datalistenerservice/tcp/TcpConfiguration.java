package com.sky.datalistenerservice.tcp;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.connection.TcpNetClientConnectionFactory;
import org.springframework.integration.ip.tcp.serializer.ByteArrayLfSerializer;

@Configuration
public class TcpConfiguration {

    final String HOST = "127.0.0.1";
    final int PORT = 8282;

    @Bean
    public TcpReceivingChannelAdapter demoTcpReceivingChannelAdapter(){

        TcpReceivingChannelAdapter adapter =new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(prepareTcpNetClientConnectionFactory());
        adapter.setClientMode(true);
        adapter.setOutputChannelName("feed me");

        return adapter;
    }


    private TcpNetClientConnectionFactory prepareTcpNetClientConnectionFactory(){
        TcpNetClientConnectionFactory factory = new TcpNetClientConnectionFactory(HOST,PORT);
//        factory.setDeserializer(new ByteArraySingleTerminatorSerializer((byte) '|'));
        factory.setDeserializer(new ByteArrayLfSerializer());
        return factory;
    }
}
