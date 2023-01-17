package com.example.prove2022.test;

import com.example.prove2022.test.domain.TestProduct;

public class TestService {

  public TestProduct getProduct(String name){
    verifyNameAboutLimit(name);
    verifyName(name);
    TestProduct testProduct = TestProduct.builder().name(name).build();
    return testProduct;
  }

  public void verifyNameAboutLimit(String name) {
    if(name.length()>1){
      throw new IllegalArgumentException();
    }
  }

  private void verifyName(String name) {
    if(name == null || name.length()>0){
      throw new IllegalArgumentException();
    }
  }

}
