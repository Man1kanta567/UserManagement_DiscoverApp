package com.mnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.mnt.config.MainConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@Import(MainConfiguration.class)
public class SupplierEurekaDiscoverableApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierEurekaDiscoverableApplication.class, args);
	}

}
