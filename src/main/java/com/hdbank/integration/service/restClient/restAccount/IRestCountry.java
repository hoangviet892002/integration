package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.client.request.getInfoCustomer.CountryClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CountryClientResponse;
import reactor.core.publisher.Mono;

public interface IRestCountry {
     Mono<CountryClientResponse> getCountry(CountryClientRequest request);
}
