package com.shearf.demo.spring.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Created by xiahaihu on 17/5/11.
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {

    private boolean locked;

    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public void unlock() {
        locked = false;
    }

    @Override
    public boolean locked() {
        return locked;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (locked() && mi.getMethod().getName().indexOf("info") == 0) {
            throw new Exception("locked");
        }
        System.out.println("Lockmixin invoke");
        return super.invoke(mi);
    }
}
