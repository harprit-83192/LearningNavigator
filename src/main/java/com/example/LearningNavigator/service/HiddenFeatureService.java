package com.example.LearningNavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiddenFeatureService {

    private static final String URL = "http://numbersapi.com/";

    private final RestTemplate restTemplate;

    public HiddenFeatureService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getFact(int number){
        String url = URL + number + "/trivia";
        return restTemplate.getForObject(url, String.class);
    }
}
