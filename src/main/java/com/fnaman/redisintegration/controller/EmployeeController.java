package com.fnaman.redisintegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnaman.redisintegration.dao.Employee;
import com.fnaman.redisintegration.dao.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeRepository employeeRepository;

	@Autowired
	CacheManager cacheManager;

	
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping()
	String welcome() {
		return "welcome";
	}
	
	@GetMapping("/clearcache")
	String clearCache() throws InterruptedException {
		cacheManager.getCacheNames().stream()
	      .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
		return "Cache is cleared";
	}
	
	@GetMapping("/list")
	@Cacheable("employee")
	Iterable<Employee> all() throws InterruptedException {
		log.info("Fetching data from DB-1.");
		Thread.sleep(10000);
		log.info("Fetching data from DB-2.");
		return employeeRepository.findAll();
	}
	 
}
