package com.GR3.demo.controller;

import com.GR3.demo.service.TestService;

import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${jwt.SIGNER_KEY}")
    private String signerKey;

    @GetMapping("/tests")
    String testLog(){
        return signerKey;
    }
}
