package com.hdbank.integration.service.common.impl;

import com.hdbank.integration.dto.ApiLogInformation;
import com.hdbank.integration.service.common.ApiLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class ApiLogServiceImpl implements ApiLogService {

    @Override
    public Mono<Void> addApiInfoLog(ApiLogInformation logInfo) {
        log.debug("Get log information: {}", logInfo);
        return Mono.empty();
    }
}
