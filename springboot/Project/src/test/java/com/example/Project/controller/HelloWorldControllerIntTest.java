package com.example.Project.controller;

import com.example.Project.domain.dto.request.UserCreateRequestTest;
import com.example.Project.security.WithSecurity;
import com.example.Project.service.SiteUserService;
import com.example.Project.utils.IntegrationTestConfig;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * HelloWorldControllerIntTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = IntegrationTestConfig.appProperties)
@ActiveProfiles("test")
public class HelloWorldControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SiteUserService service;

    private static WithSecurity withSecurity;

    @Before
    public void getToken() throws Exception {
        if (HelloWorldControllerIntTest.withSecurity == null) {
            withSecurity = new WithSecurity(service, UserCreateRequestTest.usrValidEmail5);
        }
    }
    @Test
    public void should_return200() throws Exception {
        mockMvc.perform(withSecurity.AddToken(MockMvcRequestBuilders.get("/"))) // Executa
                .andDo(MockMvcResultHandlers.print()) // pega resultado
                .andExpect(MockMvcResultMatchers.status().isOk()); // faz a validação.
    }

    @Test
    public void should_returnList() throws Exception {
        mockMvc.perform(withSecurity.AddToken(MockMvcRequestBuilders.get("/simplelist"))) // Executa
                .andDo(MockMvcResultHandlers.print()) // pega resultado
                .andExpect(MockMvcResultMatchers.status().isOk()) // faz a validação.
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Hello"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").value("World"));
    }
} 