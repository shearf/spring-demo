package com.shearf.demo.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by xiahaihu on 17/4/26.
 */
@Component
public class CustomNotifyEvent implements ApplicationEventPublisherAware {

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }

    @EventListener(ContextStartedEvent.class)
    public void startEvent() {
        System.out.println("Application Started");
    }

    @EventListener(ContextStoppedEvent.class)
    public void stopEvent() {
        System.out.println("Application Stopped");
    }

    @EventListener(ContextRefreshedEvent.class)
    public void refreshEvent() {
        System.out.println("Application Refresh");
    }
}
