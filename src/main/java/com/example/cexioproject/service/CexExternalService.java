package com.example.cexioproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class CexExternalService {

    @Value("${cex.external.url}")
    private String externalUrl;


    private RestTemplate restTemplate;

    @Autowired
    public CexExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getAllData() {
        HttpHeaders headers2 = new HttpHeaders();
        headers2.set("Accept", "application/json");
        headers2.add("user-agent", "Mozilla/5.0 Firefox/26.0");

        return restTemplate.exchange(externalUrl, HttpMethod.GET, new HttpEntity(headers2),
                String.class).getBody();


    }

}
