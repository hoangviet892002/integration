package com.hdbank.integration.service.restClient.restAccount.impl;

import com.hdbank.integration.dto.server.response.RateInfo;
import com.hdbank.integration.service.restClient.restAccount.IRestRate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class RestRate implements IRestRate {
    @Override
    public Mono<RateInfo> retrieveRateInfo(String cyy) {
        RateInfo rateInfo = new RateInfo("cyy", "rate");
        return Mono.just(rateInfo);
    }
}
