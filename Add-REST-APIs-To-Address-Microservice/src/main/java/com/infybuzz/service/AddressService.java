package com.infybuzz.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Address;
import com.infybuzz.entity.Person;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.request.Status;
import com.infybuzz.response.AddressResponse;

@EnableScheduling
@EnableCaching
@Service
public class AddressService {

	Logger logger = LoggerFactory.getLogger(AddressService.class);
	@Autowired
	CacheManager cacheManager;	
	
	@Autowired
	AddressRepository addressRepository;
	
	String name;
	
	@PostConstruct
	public void getBean() {
		this.name = "Vayala Mohan";
	}

	@PreDestroy
	public void removeBean() {
		this.name = "Sri";
	}
	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		
		logger.info("### createAddress reuest received ");
		
		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.save(address);
		
		return new AddressResponse(address, new Status("SUCCESS", "Address created successfully"));
		
	}
	
   public AddressResponse updateAddress(CreateAddressRequest createAddressRequest) {
		
		Address address = addressRepository.findById(createAddressRequest.getAddressId()).get();
		
		if(Objects.isNull(address)) {
			return new AddressResponse(address, new Status("FAILED", "Failed to Updated Address"));
		}
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.saveAndFlush(address);
		
		return new AddressResponse(address, new Status("SUCCESS", "Address Updated successfully"));
		
	}
	
   @Cacheable(value = "address")
	public AddressResponse getById (long id) {
	   
		logger.info("Inside getById " + id);
		
		logger.info("Name : " + name);
		Address address = addressRepository.findById(id).get();
		
		return new AddressResponse(address, new Status("SUCCESS", "Address retrieved successfully"));
	}
   
  // @Scheduled(fixedRate = 60000)
   public void scheduledFixedRate() throws InterruptedException {
	   Instant start = Instant.now();	   
	   System.out.println("Fixed rate time : "+ Duration.between(start, Instant.now()));
	   Thread.sleep(70000);
   }
   
   //@Scheduled(fixedDelay = 60000)
   public void scheduledFixedDelay() throws InterruptedException {
	   Instant start = Instant.now();	   
	   System.out.println("Fixed Delay time : "+ Duration.between(start, Instant.now()));
	   
	   Thread.sleep(70000);
   }
   
   
	
    public AddressResponse deleteAddressById (long id) {
		
		logger.info("Inside deleteAddressById " + id);
		
		Address address = addressRepository.findById(id).get();
		if(Objects.isNull(address)) {
			return new AddressResponse(address, new Status("FAILED", "Failed to Delete Address"));
		}
		addressRepository.deleteById(id);
		
		return new AddressResponse(address, new Status("SUCCESS", "Address retrieved successfully"));
	}
	
}
