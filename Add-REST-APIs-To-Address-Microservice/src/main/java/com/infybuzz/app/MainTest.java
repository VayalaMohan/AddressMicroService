package com.infybuzz.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infybuzz.entity.DealInfo;
import com.infybuzz.entity.Person;

public class MainTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfiguration.class);
		Person p = (Person) context.getBean("getPerson");
		DealInfo p2 = (DealInfo) context.getBean(DealInfo.class);
		System.out.println(p2);
		
		
	}

}
