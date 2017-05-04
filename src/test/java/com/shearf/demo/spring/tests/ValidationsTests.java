package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.Person;
import com.shearf.demo.spring.validator.PersonValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * Created by xiahaihu on 17/4/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class ValidationsTests {

    @Test
    public void validateTest() {

        Person person = new Person();
        person.setName("test user");

        DataBinder dataBinder = new DataBinder(person);
        dataBinder.setValidator(new PersonValidator());
        dataBinder.validate();
        BindingResult result = dataBinder.getBindingResult();

        System.out.println(result);
    }

}
