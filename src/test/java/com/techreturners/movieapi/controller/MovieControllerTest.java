package com.techreturners.movieapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetHome() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "Welcome to the Movie API!";

        //Make a GET request to the '/' endpoint
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

}
