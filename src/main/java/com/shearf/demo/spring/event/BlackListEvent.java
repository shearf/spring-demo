package com.shearf.demo.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by xiahaihu2009@gmail on 2017/4/27.
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;

    private final String text;

    public BlackListEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }
}
