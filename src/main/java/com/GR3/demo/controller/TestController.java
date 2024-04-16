package com.GR3.demo.controller;

import com.GR3.demo.service.TestService;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    //@Autowired
    //TelemetryClient telemetryClient;

    @GetMapping("/tests")
    String testLog(){
        testService.performAction();

        return "Log";
    }
}
