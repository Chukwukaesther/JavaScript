package com.semicolon.farm_Links.controller;
import com.semicolon.farm_Links.dto.request.LoginUserRequest;
import com.semicolon.farm_Links.dto.request.PayStackRequest;
import com.semicolon.farm_Links.dto.response.ApiResponse;
import com.semicolon.farm_Links.dto.response.LoginUserResponse;
import com.semicolon.farm_Links.dto.response.PayStackResponse;
import com.semicolon.farm_Links.exception.FarmLinkException;
import com.semicolon.farm_Links.service.PayStackService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

import static javax.crypto.Cipher.SECRET_KEY;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@AllArgsConstructor
@NonNull
@RequestMapping("/api/payment")
public class PayStackController {
    @Autowired
    private PayStackService payStackService;
    @PostMapping("/initialize")
    public ResponseEntity<?> initializeTransaction(@RequestBody PayStackRequest payStackRequest) {
        try {
            PayStackResponse result = payStackService.initializeTransaction(payStackRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (FarmLinkException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), BAD_REQUEST);
        }
    }
}
