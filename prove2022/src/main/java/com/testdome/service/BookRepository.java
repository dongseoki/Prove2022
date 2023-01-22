package com.testdome.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {
  public List<String> getBooks(){
    return new ArrayList<>();
  }
}
