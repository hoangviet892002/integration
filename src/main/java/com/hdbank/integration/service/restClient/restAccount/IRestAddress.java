package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.client.request.getInfoCustomer.AddressClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.AddressClientResponse;
import reactor.core.publisher.Mono;

public interface IRestAddress {
     Mono<AddressClientResponse> retrieveAddress(AddressClientRequest request);
}
