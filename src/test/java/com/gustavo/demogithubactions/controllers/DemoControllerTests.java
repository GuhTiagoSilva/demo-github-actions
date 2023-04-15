package com.gustavo.demogithubactions.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class DemoControllerTests {

    @InjectMocks
    private DemoController demoController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    @DisplayName("It should return hello world message")
    void itShouldReturnHelloWorldMessage() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        String message = mvcResult.getResponse().getContentAsString();

        assertEquals(message, "Hello World!");
    }

    @Test
    @DisplayName("It should return goodbye message")
    void itShouldReturnGoodbyeMessage() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/goodbye"))
                .andExpect(status().isOk())
                .andReturn();

        String message = mvcResult.getResponse().getContentAsString();

        assertEquals(message, "Goodbye!");
    }

}
