package com.infybuzz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
	
	private String name;
	private int accno;
	private String address;
	private int sal;
	
	public static void main(String[] args) {
		
		Account acc =  Account.builder().accno(200).build();
		System.out.println(acc.toString());
	}

}
