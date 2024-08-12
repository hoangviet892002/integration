package com.hdbank.integration.dto.client.response.getInfoCustomer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class AddressClientResponse {
    @JsonProperty("address")
    private String address;
}
