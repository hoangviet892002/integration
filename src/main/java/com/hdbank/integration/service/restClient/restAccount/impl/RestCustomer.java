package com.hdbank.integration.service.restClient.restAccount.impl;


import com.hdbank.integration.dto.client.request.getInfoCustomer.CustomerClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CustomerClientResponse;
import com.hdbank.integration.service.restClient.restAccount.IRestCustomer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RestCustomer implements IRestCustomer {
    @Override
    public Mono<CustomerClientResponse> getCustomerInfo(CustomerClientRequest request) {
        CustomerClientResponse customerClientResponse =  new CustomerClientResponse();
        customerClientResponse.setData(CustomerClientResponse.Default());
        return Mono.just(customerClientResponse);
    }
}
