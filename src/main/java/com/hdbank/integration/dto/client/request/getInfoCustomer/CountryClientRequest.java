package com.hdbank.integration.dto.client.request.getInfoCustomer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryClientRequest {
    @JsonProperty("country_citizen")
    private String countryCitizen;
}
