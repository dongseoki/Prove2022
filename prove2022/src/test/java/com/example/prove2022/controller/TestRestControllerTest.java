package com.example.prove2022.controller;

import com.example.prove2022.test.TestRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TestRestControllerTest {

    @InjectMocks
    private TestRestController testRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(testRestController).build();
    }

    @DisplayName("getproduct test")
    @Test
    void getProduct() throws Exception{
        //given

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/test-rest/product/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //then

        MvcResult mvcResult = resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
//                .andExpect(jsonPath("$.id").value("2"))
                .andReturn();


    }
}
