package com.hdbank.integration.service.restAccount;

import com.hdbank.integration.dto.response.AccountResponse;
import com.hdbank.integration.dto.response.BaseResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IRestAccount {
    Mono<BaseResponse<AccountResponse>> getAccount(String accountNo);

    Mono<BaseResponse<List<AccountResponse>>> getAccounts(String client_no);
}
