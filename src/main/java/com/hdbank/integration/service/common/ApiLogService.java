package com.hdbank.integration.service.common;

import com.hdbank.integration.dto.ApiLogInformation;
import reactor.core.publisher.Mono;

public interface ApiLogService {
    Mono<Void> addApiInfoLog(ApiLogInformation logInfo);
}
