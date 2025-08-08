package com.infybuzz.service;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {
	
	Logger logg = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Around(value = "execution(* com.infybuzz.service.*.*(..))")
	public Object callLogger(ProceedingJoinPoint jointPoint) throws Throwable {
		
		logg.info("Enter methog " +jointPoint.getSignature().toLongString());
		Instant start = Instant.now();
		
		Object res = jointPoint.proceed();
		
		Instant end = Instant.now();
		
		logg.info("Ttoal time to execution " +Duration.between(start, end).toMillis());
		
		return res;
	}

}
