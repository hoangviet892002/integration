package com.hdbank.integration.dto.client.request.getInfoCustomer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressClientRequest {
    @JsonProperty("client_no")
    private String clientNo;
    @JsonProperty("contact_type")
    private String contactType;
}
