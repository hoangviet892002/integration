package com.hdbank.integration.service.restClient.restAccount.impl;

import com.hdbank.integration.dto.client.request.getAccount.AccountClientRequest;
import com.hdbank.integration.dto.client.response.getAccount.AccountClientResponse;
import com.hdbank.integration.dto.server.response.AccountResponse;
import com.hdbank.integration.service.restClient.restAccount.IRestAccount;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class RestAccount implements IRestAccount {

    @Override
    public Mono<AccountResponse> getAccount(String accountNo) {
        // Create an Account list object with default values
        AccountResponse accountResponse = new AccountResponse("default_account_number", "default_branch");
        return Mono.just(accountResponse);
    }

    @Override
    public Mono<List<AccountClientResponse>> getAccounts(AccountClientRequest request) {
         return Mono.just(List.of(
                new AccountClientResponse("default_account_number", "Acc No 1"),
                new AccountClientResponse("default_account_number", "Acc No 2"),
                new AccountClientResponse("default_account_number ","Acc No 3")
        ));
    }
}
