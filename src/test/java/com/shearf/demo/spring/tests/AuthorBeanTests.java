package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.Author;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiahaihu on 17/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class AuthorBeanTests {

    @Autowired
    private Author author;

    @Test
    public void authorInfoTest() {
        Assert.assertTrue(author.getEmail().equals("shearf@shearf.com"));
    }
}
