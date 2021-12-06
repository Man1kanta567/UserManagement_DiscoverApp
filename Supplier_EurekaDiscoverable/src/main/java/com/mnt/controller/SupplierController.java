package com.mnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.service.SupplierService;

@RestController
public class SupplierController 
{
	
	@Autowired
	SupplierService service;
	
	@GetMapping("/getOne/{id}")
	public String getOneUserId(@PathVariable("id") Integer id)
	{
	  return service.getUserDetailsById(id);
	}
	
	@GetMapping("/providerSample")
	public String getProviderInfo()
	{
		return service.getSampleProvider();
	}

}
