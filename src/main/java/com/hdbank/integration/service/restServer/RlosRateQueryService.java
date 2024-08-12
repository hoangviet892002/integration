package com.hdbank.integration.service.restServer;

import com.hdbank.integration.dto.server.request.BaseRequest;
import com.hdbank.integration.dto.server.request.RateRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RateInfoResponse;
import reactor.core.publisher.Mono;

public interface RlosRateQueryService {
     Mono<BaseResponse<RateInfoResponse>> retrieveRateInfo(BaseRequest<RateRequest> request);
}
