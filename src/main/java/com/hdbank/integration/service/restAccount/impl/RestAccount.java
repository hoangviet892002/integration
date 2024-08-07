package com.hdbank.integration.service.restAccount.impl;

import com.hdbank.integration.dto.response.AccountResponse;
import com.hdbank.integration.dto.response.BaseResponse;
import com.hdbank.integration.service.restAccount.IRestAccount;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class RestAccount implements IRestAccount {

    @Override
    public Mono<BaseResponse<AccountResponse>> getAccount(String accountNo) {
        // Create an AccountResponse object with default values
        AccountResponse accountResponse = new AccountResponse("default_account_number", "default_branch");

        // Create a BaseResponse object and set the AccountResponse object
        BaseResponse<AccountResponse> baseResponse = new BaseResponse<>();
        baseResponse.setData(accountResponse);

        // Return the BaseResponse wrapped in a Mono
        return Mono.just(baseResponse);
    }

    @Override
    public Mono<BaseResponse<List<AccountResponse>>> getAccounts(String client_no) {
        // Create a list of AccountResponse objects with default values
        List<AccountResponse> accountResponses = List.of(
                new AccountResponse("default_account_number_1", "default_branch_1"),
                new AccountResponse("default_account_number_2", "default_branch_2")
        );

        // Create a BaseResponse object and set the list of AccountResponse objects
        BaseResponse<List<AccountResponse>> baseResponse = new BaseResponse<>();
        baseResponse.setData(accountResponses);

        // Return the BaseResponse wrapped in a Mono
        return Mono.just(baseResponse);
    }
}
