package com.example.prove2022.config.aspect;

import com.jam2in.arcus.app.common.aop.ArcusCacheAspect;
import com.jam2in.arcus.app.common.config.ArcusConfiguration;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/*
Annotation 기반의 캐싱을 위한 Aspect class 정의.
캐시 대상에 해당되는 {POINTCUT_EXPRESSION} 설정이 요구됨.
이 기능을 사용하지 않을 경우 아래의 내용을 생략한다
*/
@Aspect
public class ArcusAnnotationAspect extends ArcusCacheAspect {
    public ArcusAnnotationAspect(ArcusConfiguration configuration) {
        super(configuration);
    }
 /*
 @Pointcut("@annotation(com.jam2in.arcus.app.common.aop.ArcusCache &&
execution(!void org.jam2in.arcus.commontest.*Service.get*(..))))")
*/
    @Pointcut("@annotation(com.jam2in.arcus.app.common.aop.ArcusCache &&
            {POINTCUT_EXPRESSION} )")
    public void pointcut() {}
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return super.around(joinPoint);
    }
}