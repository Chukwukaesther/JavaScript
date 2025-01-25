package com.semicolon.farm_Links.dto.response;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderResponse {
    private Long orderId;
    private String message;

}
