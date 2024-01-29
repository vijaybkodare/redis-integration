package com.fnaman.redisintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisIntegrationApplication.class, args);
	}

}
