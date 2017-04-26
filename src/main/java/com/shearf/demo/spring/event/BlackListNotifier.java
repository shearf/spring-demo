package com.shearf.demo.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * Created by xiahaihu2009@gmail on 2017/4/27.
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent blackListEvent) {
        System.out.println("BlackListEvent on");
    }

    @EventListener
    public void proccessBlacklistNotifyEvent(BlackListEvent blackListEvent) {
        System.out.println(notificationAddress + " in blacklist");
    }
}
