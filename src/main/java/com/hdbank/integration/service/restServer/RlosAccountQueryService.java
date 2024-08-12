package com.hdbank.integration.service.restServer;

import com.hdbank.integration.dto.server.request.BaseRequest;
import com.hdbank.integration.dto.server.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RetrievesAccountResponse;
import reactor.core.publisher.Mono;

public interface RlosAccountQueryService {

     Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(RetrievesAccountRequest request);
}
