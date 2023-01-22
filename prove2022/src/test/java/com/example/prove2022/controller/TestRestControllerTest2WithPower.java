package com.example.prove2022.controller;

import com.example.prove2022.test.TestService;
import com.example.prove2022.test.domain.TestProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TestService.class)
public class TestRestControllerTest2WithPower {

    @DisplayName("getproduct service test")
    @Test
    void getProduct_service() throws Exception{
        TestService testService = PowerMockito.spy(new TestService());
        //given
        String testName = "AAA";

        PowerMockito.doNothing().when(testService).verifyNameAboutLimit(ArgumentMatchers.anyString());
        PowerMockito.doNothing().when(testService, "verifyName", ArgumentMatchers.anyString());

        //when
        TestProduct testProduct = testService.getProduct(testName);

        //then
        Assertions.assertEquals(testProduct.getName(), testName);
    }
}
