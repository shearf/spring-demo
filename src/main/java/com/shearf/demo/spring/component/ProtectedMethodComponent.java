package com.shearf.demo.spring.component;

import org.springframework.stereotype.Component;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@Component
public class ProtectedMethodComponent {

    public void invoke() {
        System.out.println("invoke called");
        this.protectedMethod("Test");
    }

    protected void protectedMethod(Object object) {

        System.out.println("protected method called");
        System.out.println(object);
    }
}
