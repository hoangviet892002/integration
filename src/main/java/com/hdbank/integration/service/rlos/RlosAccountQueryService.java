package com.hdbank.integration.service.rlos;

import com.hdbank.integration.dto.request.BaseRequest;
import com.hdbank.integration.dto.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.response.BaseResponse;
import com.hdbank.integration.dto.response.RetrievesAccountResponse;
import reactor.core.publisher.Mono;

public interface RlosAccountQueryService {
    public Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(BaseRequest<RetrievesAccountRequest> request);
}
