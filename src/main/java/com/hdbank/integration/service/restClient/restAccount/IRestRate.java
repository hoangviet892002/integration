package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.server.response.RateInfo;
import reactor.core.publisher.Mono;

public interface IRestRate {
    Mono<RateInfo> retrieveRateInfo(String cyy);
}
