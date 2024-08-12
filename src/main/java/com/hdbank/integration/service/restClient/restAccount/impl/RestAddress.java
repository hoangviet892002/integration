package com.hdbank.integration.service.restClient.restAccount.impl;

import com.hdbank.integration.dto.client.request.getInfoCustomer.AddressClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.AddressClientResponse;
import com.hdbank.integration.service.restClient.restAccount.IRestAddress;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class RestAddress implements IRestAddress {
    @Override
    public Mono<AddressClientResponse> retrieveAddress(AddressClientRequest request) {
        AddressClientResponse addressClientResponse = new AddressClientResponse("address");
        return Mono.just(addressClientResponse);
    }
}
