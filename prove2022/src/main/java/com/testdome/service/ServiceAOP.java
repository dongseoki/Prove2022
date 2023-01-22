package com.testdome.service;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.testdome.service.BookSearchService;

interface ServiceCallback {
  public void callback(String methodName);
}
interface SearchCallback {
  public void callback(String searchedBook);
}
interface RepositoryCallback {
  public void callback();
}

@Aspect
public class ServiceAOP {
//  @Autowired ServiceCallback serviceCallback;
//  @Autowired SearchCallback searchCallback;
//  @Autowired RepositoryCallback repositoryCallback;
  ServiceCallback serviceCallback;
  SearchCallback searchCallback;
  RepositoryCallback repositoryCallback;

  public ServiceAOP(ServiceCallback serviceCallback, SearchCallback searchCallback, RepositoryCallback repositoryCallback) {
    this.serviceCallback = serviceCallback;
    this.searchCallback = searchCallback;
    this.repositoryCallback = repositoryCallback;
  }

  @Before("execution(* com.testdome.service.*.*(..))")
  public void serviceAdvice(JoinPoint jp) {
    serviceCallback.callback(jp.getSignature().getName());
  }

  @Before("execution(* com.testdome.service.BookRepository.getBooks(..))")
  public void repositoryAdvice(JoinPoint jp) {
    repositoryCallback.callback();
  }
  @Before("execution(* com.testdome.service.BookSearchService.*(..))")
  public void searchServiceAdvice(JoinPoint joinPoint) throws Throwable {
    searchCallback.callback((String) joinPoint.getArgs()[0]);
  }
}

@Configuration
@EnableAspectJAutoProxy
//@Import(ServiceAOP.class)
//@ComponentScan(basePackages="com.testdome.service")
class Config {
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