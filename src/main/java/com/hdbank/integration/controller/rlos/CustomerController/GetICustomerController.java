package com.hdbank.integration.controller.rlos.CustomerController;


import com.hdbank.integration.dto.server.request.CustomerInfoRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.CustomerInfoResponse;
import com.hdbank.integration.service.restServer.CustomerQueryService;
import com.hdbank.integration.share.enums.ResponseEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.hdbank.integration.dto.server.response.BaseResponse.baseResponse;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_NOT_FOUND;

@RestController
@Tag(name = "Customer")
@RequiredArgsConstructor
@RequestMapping("/customer")
public class GetICustomerController {


    private CustomerQueryService customerQueryService;
    @GetMapping("/{clientNo}")
    public Mono<BaseResponse<CustomerInfoResponse>> getInfoCus(@PathVariable("clientNo") String clientNo) {
        return customerQueryService.getInfoCustomer(new CustomerInfoRequest(clientNo));

    }
}
