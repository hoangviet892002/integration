package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.client.request.getAccount.AccountClientRequest;
import com.hdbank.integration.dto.client.response.getAccount.AccountClientResponse;
import com.hdbank.integration.dto.server.response.AccountResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IRestAccount {
    Mono<AccountResponse> getAccount(String accountNo);

    Mono<List<AccountClientResponse>> getAccounts(AccountClientRequest request);
}
