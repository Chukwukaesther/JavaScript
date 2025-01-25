package com.semicolon.farm_Links.dto.request;


import lombok.Data;

@Data
public class PayStackRequest {
    private String email;
    private String amount;
    private String currency;
    private String reference;
    private String firstName;
    private String lastName;

}

