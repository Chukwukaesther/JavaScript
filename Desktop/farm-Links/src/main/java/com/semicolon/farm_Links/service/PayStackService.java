package com.semicolon.farm_Links.service;

import com.semicolon.farm_Links.dto.request.PayStackRequest;
import com.semicolon.farm_Links.dto.request.VerifyPayStackRequest;
import com.semicolon.farm_Links.dto.response.PayStackResponse;
import com.semicolon.farm_Links.dto.response.VerifyPayStackResponse;
import org.springframework.stereotype.Service;

@Service
public interface PayStackService {
    PayStackResponse initializeTransaction(PayStackRequest payStackRequest);
    VerifyPayStackResponse verifyPayStackResponse(VerifyPayStackRequest verifyPayStackRequest);
}
