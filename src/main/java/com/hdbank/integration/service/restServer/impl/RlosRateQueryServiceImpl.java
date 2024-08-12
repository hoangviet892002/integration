package com.hdbank.integration.service.restServer.impl;

import com.hdbank.integration.dto.server.request.BaseRequest;
import com.hdbank.integration.dto.server.request.RateRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RateInfo;
import com.hdbank.integration.dto.server.response.RateInfoResponse;
import com.hdbank.integration.service.restClient.restAccount.impl.RestRate;
import com.hdbank.integration.service.restServer.RlosRateQueryService;
import com.hdbank.integration.share.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.hdbank.integration.dto.server.response.BaseResponse.baseResponse;


@Service
@RequiredArgsConstructor
public class RlosRateQueryServiceImpl implements RlosRateQueryService {

    private final RestRate restRate;
    @Override
    public Mono<BaseResponse<RateInfoResponse>> retrieveRateInfo(BaseRequest<RateRequest> request) {
       return validateRequest(request.getData())
               .then(Mono.deferContextual(ctx -> {
                   // transfer api request to rest client
                   Mono<RateInfo> rateInfoMono = retrieveRateInfo(request.getData().getCcy());
                   BaseResponse<RateInfoResponse> baseResponse =  baseResponse(request.getRequestId(),
                           ResponseEnum.SUCCESS);
                   RateInfoResponse response = new RateInfoResponse();
                     return rateInfoMono
                             .flatMap(rateInfo -> {
                               if (rateInfo != null) {
                                   response.setMsgCode(ResponseEnum.DATA_SUCCESS.getMessage());
                                   response.setMsgName(ResponseEnum.DATA_SUCCESS.getDescription());
                                   response.setRecordset(rateInfo);
                               } else {
                                   response.setMsgCode(ResponseEnum.DATA_NOT_FOUND.getMessage());
                                   response.setMsgName(ResponseEnum.DATA_NOT_FOUND.getDescription());
                               }
                               baseResponse.setData(response);
                               return Mono.just(baseResponse);
                             });
               }));
    }

    private Mono<Void> validateRequest(RateRequest request) {
        return Mono.empty();
    }

    private Mono<RateInfo> retrieveRateInfo(String cyy) {
        return restRate.retrieveRateInfo(cyy);
    }

}
