package com.saveo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saveo.model.UrlBean;
import com.saveo.repository.UrlRepository;
import com.saveo.service.TinyUrlService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class ApplicationController {
	
	@Autowired
	UrlRepository urlRepo;
	
	@Autowired
	TinyUrlService urlService;
	
	@Autowired
	UrlBean urlBean;
	
	 
	
	 @GetMapping("/get/{key}")
	    public String getUrl(@PathVariable String key) {
		return urlService.getUrl(key);
	 }
	 
	 @PostMapping("/create/**")
	    public String create(HttpServletRequest request) {
		 String fullUrl = request.getRequestURL().toString();
		    String input_url = fullUrl.split("/create/")[1];
		return urlService.create(input_url); 
		    
		
	 }


}
