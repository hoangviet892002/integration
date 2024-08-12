package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.client.request.getInfoCustomer.CustomerClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CustomerClientResponse;
import reactor.core.publisher.Mono;

public interface IRestCustomer {
    Mono<CustomerClientResponse> getCustomerInfo(CustomerClientRequest request);

}
