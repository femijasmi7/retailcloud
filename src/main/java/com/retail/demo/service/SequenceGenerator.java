package com.retail.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {

	// generate random numbers
	public Long getNextID() {
		Random random = new Random();
		Long x = random.nextLong(123456789);
		return x;
	}
}
