package com.mnt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class SupplierService {

	Logger logger = LoggerFactory.getLogger(SupplierService.class);
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EurekaClient eurekaServerInstances;

	public String getUserDetailsById(Integer id) {
		InstanceInfo instanceInfo = eurekaServerInstances.getNextServerFromEureka("USERMANAGEMENT-SUPPLIER", false);
		String url = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = restTemplate.getForEntity(url + "/one/" + id, String.class);
		logger.info("response-->", response.getBody());
		logger.info("response status", response.getStatusCode());
		return response.getBody();
	}
	
	
	public String getSampleProvider() {
		InstanceInfo instanceInfo = eurekaServerInstances.getNextServerFromEureka("PROVIDERAPP", false);
		String url = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = restTemplate.getForEntity(url + "/sample", String.class);
		logger.info("response-->", response.getBody());
		logger.info("response status", response.getStatusCode());	
		return response.getBody();
	}

}
