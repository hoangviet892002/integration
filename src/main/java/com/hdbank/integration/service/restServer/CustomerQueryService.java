package com.hdbank.integration.service.restServer;

import com.hdbank.integration.dto.server.request.CustomerInfoRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.CustomerInfoResponse;
import reactor.core.publisher.Mono;

public interface CustomerQueryService {
    Mono<BaseResponse<CustomerInfoResponse>> getInfoCustomer(CustomerInfoRequest request);
}
