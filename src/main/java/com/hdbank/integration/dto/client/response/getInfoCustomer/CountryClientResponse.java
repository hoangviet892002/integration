package com.hdbank.integration.dto.client.response.getInfoCustomer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryClientResponse {
    @JsonProperty("country_desc")
    private String country;

}
