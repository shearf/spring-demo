package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.config.WebConfig;
import com.shearf.demo.spring.web.controller.SearchController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiahaihu2009@gmail on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContextConfig.class, WebConfig.class})
public class WebMvcTests {

    @Autowired
    private SearchController searchController;

    @Autowired
    private MockServletContext mockServletContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }

    @Test
    public void searchTest() {
        try {

            Map<String, Object> map = new HashMap<>();
            map.put("enable", 1);
            ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/search"));
            MvcResult mvcResult = resultActions.andReturn();
            String responseContent = mvcResult.getResponse().getContentAsString();
            System.out.println(responseContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
