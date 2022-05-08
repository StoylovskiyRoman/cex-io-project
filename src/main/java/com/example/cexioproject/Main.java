package com.example.cexioproject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.set("Accept", "application/json");
        headers2.add("user-agent", "Mozilla/5.0 Firefox/26.0");

        restTemplate.exchange("https://cex.io/api/currency_limits", HttpMethod.GET, new HttpEntity(headers2),
                String.class).getBody();

    }
}
