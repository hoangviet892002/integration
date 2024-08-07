package com.hdbank.integration.controller.rlos.accountController;


import com.hdbank.integration.dto.request.BaseRequest;
import com.hdbank.integration.dto.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.request.TestRequest;
import com.hdbank.integration.dto.response.BaseResponse;
import com.hdbank.integration.dto.response.RetrievesAccountResponse;
import com.hdbank.integration.service.rlos.RlosAccountQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Tag(name = "Account")
public class GetAccountController {

    private final RlosAccountQueryService rlosAccountQueryService;

    @PostMapping
    public Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(@RequestBody BaseRequest<RetrievesAccountRequest> request) {
        System.out.println(rlosAccountQueryService.retrievesAccount(request));
        return rlosAccountQueryService.retrievesAccount(request);
    }

    @PostMapping("/test")
    public String test(@RequestBody BaseRequest<TestRequest> request) {
        return "test";
    }
    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

}
