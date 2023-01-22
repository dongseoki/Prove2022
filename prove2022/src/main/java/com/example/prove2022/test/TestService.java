package com.example.prove2022.test;

import com.example.prove2022.test.domain.TestProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public void getHelloMessage(){
        LOGGER.info("Hello, this is getHelloMessage");
    }

  public void verifyNameAboutLimit(String anyString) {
      return;
  }

  public TestProduct getProduct(String testName) {
      return null;
  }
}
