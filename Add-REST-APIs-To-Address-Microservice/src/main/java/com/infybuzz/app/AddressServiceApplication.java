package com.infybuzz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.google.common.collect.Lists;
import com.infybuzz.entity.Person;

@SpringBootApplication
@ComponentScan({"com.infybuzz.controller", "com.infybuzz.service", "com.infybuzz.entity"})
@EntityScan("com.infybuzz.entity")
@EnableJpaRepositories("com.infybuzz.repository")
@EnableEurekaClient
@EnableAspectJAutoProxy
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}
	
	@Bean
	public CacheManager cacheManager() {
		
		SimpleCacheManager manager = new SimpleCacheManager();
		manager.setCaches(Lists.newArrayList(new ConcurrentMapCache("address"), new ConcurrentMapCache("customer")));		
		return manager;
	}
	/*
		 * 
		 * @Bean("first") Person getPerson() { return new Person(14, "sri", "India"); }
		 * 
		 * @Bean
		 * 
		 * @Primary Person person() { return new Person(15, "Mohan", "India"); }
		 */

}
