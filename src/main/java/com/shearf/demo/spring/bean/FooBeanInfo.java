package com.shearf.demo.spring.bean;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

/**
 * Created by xiahaihu on 17/5/4.
 */
public class FooBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {

        PropertyEditor editor = new CustomNumberEditor(Integer.class, true);

        return super.getPropertyDescriptors();
    }
}
