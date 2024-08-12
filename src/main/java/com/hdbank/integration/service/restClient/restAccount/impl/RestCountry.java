package com.hdbank.integration.service.restClient.restAccount.impl;

import com.hdbank.integration.dto.client.request.getInfoCustomer.CountryClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CountryClientResponse;
import com.hdbank.integration.service.restClient.restAccount.IRestCountry;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class RestCountry implements IRestCountry {
    @Override
    public Mono<CountryClientResponse> getCountry(CountryClientRequest request) {
        CountryClientResponse countryClientResponse = new CountryClientResponse("country");
        return Mono.just(countryClientResponse);
    }
}
