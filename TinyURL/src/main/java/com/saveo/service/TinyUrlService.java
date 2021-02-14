package com.saveo.service;


import java.nio.charset.StandardCharsets;

import javax.transaction.Transactional;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.google.common.hash.Hashing;
import com.saveo.model.UrlBean;
import com.saveo.repository.UrlRepository;

@Service
public class TinyUrlService {
	
	@Autowired
	UrlRepository urlRepo;
	
	

    public String getUrl(String id) {
		String url = urlRepo.findById(id).get().getUrl();
        System.out.println("URL Retrieved: " + url);
        if (url == null) {
            throw new RuntimeException("Unable to retrieve URL");
        }
        return url;
    }

    	
    	@Transactional
		public String create(String url) {			
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if (urlValidator.isValid(url))

        {
        	String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
            System.out.println("URL Id generated: "+ id);
            UrlBean urlBean= new UrlBean();
            urlBean.setId(id);
            urlBean.setUrl(url);
            urlRepo.save(urlBean);
            return id;
        }

        throw new RuntimeException("Invalid URL: " + url);
    }
	
	
}
