package com.example.prove2022.test.aop;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

interface ServiceCallback {
  public void callback(String methodName);
}
interface SearchCallback {
  public void callback(String searchedBook);
}
interface RepositoryCallback {
  public void callback();
}
@Configuration
public class Config {
  @Bean
  public ServiceCallback serviceCallback() {
    return (methodName) -> System.out.println(methodName);
  }
  @Bean
  public SearchCallback searchCallback() {
    return (book) -> System.out.println(book);
  }
  @Bean
  public RepositoryCallback repositoryCallback() {
    return () -> System.out.println("Repository called!");
  }
}
