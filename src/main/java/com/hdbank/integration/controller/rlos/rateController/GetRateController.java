package com.hdbank.integration.controller.rlos.rateController;


import com.hdbank.integration.dto.server.request.BaseRequest;
import com.hdbank.integration.dto.server.request.RateRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RateInfoResponse;
import com.hdbank.integration.service.restServer.RlosRateQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rate")
@RequiredArgsConstructor
@Tag(name = "Rate")
public class GetRateController {

    private final RlosRateQueryService rlosRateQueryService;
    @PostMapping("")
    public Mono<BaseResponse<RateInfoResponse>> getRate(@RequestBody BaseRequest<RateRequest> request) {
        return rlosRateQueryService.retrieveRateInfo(request);
    }
}
