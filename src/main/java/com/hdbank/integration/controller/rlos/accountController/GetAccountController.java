package com.hdbank.integration.controller.rlos.accountController;


import com.hdbank.integration.dto.server.request.BaseRequest;
import com.hdbank.integration.dto.server.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RetrievesAccountResponse;
import com.hdbank.integration.service.restServer.RlosAccountQueryService;
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

    @GetMapping("/{clientNo}")
    public Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(@PathVariable("clientNo") String clientNo) {
       RetrievesAccountRequest retrievesAccountRequest = new RetrievesAccountRequest(clientNo);
       return rlosAccountQueryService.retrievesAccount(retrievesAccountRequest);
    }


}
