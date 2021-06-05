package com.arqueodata.ArqueodataBack;
/**
 * Proyecto final.
 * 
 * @author Isabel Orozco Puerto
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ArqueodataBackApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ArqueodataBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
