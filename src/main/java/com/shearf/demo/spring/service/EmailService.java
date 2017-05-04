package com.shearf.demo.spring.service;

import com.shearf.demo.spring.event.BlackListEvent;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * Created by xiahaihu2009@gmail on 2017/4/27.
 */
public class EmailService implements ApplicationEventPublisherAware {

    @Setter
    private List<String> blackList;
    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String text) {
        if (blackList.contains(address)) {
            BlackListEvent blackListEvent = new BlackListEvent(this, address, text);
            publisher.publishEvent(blackListEvent);
        }
    }
}
