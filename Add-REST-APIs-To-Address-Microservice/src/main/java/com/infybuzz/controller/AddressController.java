package com.infybuzz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.request.CreateAddressRequest;
import com.infybuzz.response.AddressResponse;
import com.infybuzz.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public ResponseEntity<AddressResponse> createAddress (@Valid @RequestBody CreateAddressRequest createAddressRequest) {		
		return new ResponseEntity<AddressResponse>(addressService.createAddress(createAddressRequest), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public AddressResponse updateAddress (@Valid @RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.updateAddress(createAddressRequest);
	}	
	
	@GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@DeleteMapping("/getById")
	public AddressResponse deleteById(@RequestParam(value="id", required = false) long id) {
		return addressService.deleteAddressById(id);
	}
	
	@GetMapping(value = "/getByNo")
	public AddressResponse getByNo(@RequestParam(value="id", required = false) long id) {
		return addressService.getById(id);
	}
	
	
	
}
