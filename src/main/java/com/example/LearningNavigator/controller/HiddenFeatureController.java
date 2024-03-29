package com.example.LearningNavigator.controller;

import com.example.LearningNavigator.service.HiddenFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hidden-feature")
public class HiddenFeatureController {

    private final HiddenFeatureService hiddenFeatureService;

    public HiddenFeatureController(HiddenFeatureService hiddenFeatureService){
        this.hiddenFeatureService = hiddenFeatureService;
    }

    @GetMapping("/{number}")
    public String getFact(@PathVariable int number){
        return hiddenFeatureService.getFact(number);
    }
}
