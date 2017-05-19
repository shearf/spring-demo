package com.shearf.demo.spring.tests;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by xiahaihu on 17/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContextConfig.class, WebConfig.class})
public class ExampleMvcTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private WebClient webClient;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        webClient = MockMvcWebClientBuilder.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void mockMvcTest() {
        try {
            ResultActions resultActions = mockMvc.perform(get("/hello"))
                    .andExpect(status().isOk());

            MvcResult result = resultActions.andReturn();
            String content = result.getResponse().getContentAsString();
            System.out.println(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void htmlUnitTest() {
        try {
            HtmlPage page = webClient.getPage("http://localhost/hello");
            System.out.println(page.getBody().getTextContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockRestServiceServer = MockRestServiceServer.bindTo(restTemplate).build();

        mockRestServiceServer.expect(requestTo("/hello")).andRespond(withSuccess());

        mockRestServiceServer.verify();
    }
}
