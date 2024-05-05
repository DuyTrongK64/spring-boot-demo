package com.GR3.demo.controller;

import com.GR3.demo.dto.ApiRespose;
import com.GR3.demo.dto.request.AuthenticationRequest;
import com.GR3.demo.dto.request.IntrospectTokenRequest;
import com.GR3.demo.dto.response.AuthenticationResponse;
import com.GR3.demo.dto.response.IntrospectTokenResponse;
import com.GR3.demo.entity.User;
import com.GR3.demo.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiRespose<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiRespose.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiRespose<IntrospectTokenResponse> login(@RequestBody IntrospectTokenRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspectToken(request);
        return ApiRespose.<IntrospectTokenResponse>builder()
                .result(result)
                .build();
    }
}
