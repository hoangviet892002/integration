package com.hdbank.integration.dto.client.request.getInfoCustomer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerClientRequest {
    @JsonProperty("clientNo")
    private String client_no;
}
