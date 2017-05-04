package com.shearf.demo.spring.web.advice;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Created by xiahaihu on 17/5/4.
 */
@ControllerAdvice
public class BooleanAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
    }
}
