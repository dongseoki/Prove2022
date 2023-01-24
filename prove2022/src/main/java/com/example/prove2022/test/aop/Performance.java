package com.example.prove2022.test.aop;


import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@AllArgsConstructor
@Component
public class Performance {
    private final ServiceCallback serviceCallback;
    private final SearchCallback searchCallback;
    private final RepositoryCallback repositoryCallback;


    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.example.prove2022.test.TestService.getHelloMessage(..))")
    public Object calculatePerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : "+ (end - start));
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }
        return result;
    }

    @Before("execution(* com.example.prove2022.test.*.*(..))")
    public void serviceAdvice(JoinPoint jp) {
        serviceCallback.callback(jp.getSignature().getName());
    }

    @Before("execution(* com.example.prove2022.test.BookRepository.getBooks(..))")
    public void repositoryAdvice(JoinPoint jp) {
        repositoryCallback.callback();
    }
    @Before("execution(* com.example.prove2022.test.BookSearchService.*(..))")
    public void searchServiceAdvice(JoinPoint joinPoint) throws Throwable {
        searchCallback.callback((String) joinPoint.getArgs()[0]);
    }
}
