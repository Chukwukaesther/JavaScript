package com.semicolon.farm_Links.dto.response;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayStackResponse {
    private boolean status;
    private String message;
    private ResponseData data;
}
