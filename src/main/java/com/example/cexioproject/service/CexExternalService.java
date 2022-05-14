package com.example.cexioproject.service;

import com.example.cexioproject.dto.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private ObjectMapper objectMapper;

    @Autowired
    public CexExternalService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Root getAllData() throws JsonProcessingException {
        HttpHeaders headers2 = new HttpHeaders();
        headers2.set("Accept", "application/json");
        headers2.add("user-agent", "Mozilla/5.0 Firefox/26.0");

        String body = restTemplate.exchange(externalUrl, HttpMethod.GET, new HttpEntity(headers2),
                String.class).getBody();
        return objectMapper.readValue(body, Root.class);


    }

}
