package com.shearf.demo.spring.interceptor;

/**
 * Created by xiahaihu on 17/5/11.
 */
public interface Lockable {
    void lock();

    void unlock();

    boolean locked();
}
