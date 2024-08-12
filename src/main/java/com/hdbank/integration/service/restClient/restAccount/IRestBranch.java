package com.hdbank.integration.service.restClient.restAccount;

import com.hdbank.integration.dto.client.request.getAccount.BranchClientRequest;
import com.hdbank.integration.dto.client.request.getInfoCustomer.BranchInfoClientRequest;
import com.hdbank.integration.dto.client.response.getAccount.BranchClientResponse;

import com.hdbank.integration.dto.client.response.getInfoCustomer.BranchInfoClientResponse;
import reactor.core.publisher.Mono;

public interface IRestBranch {
    Mono<BranchClientResponse> getBranch(BranchClientRequest request);

    Mono<BranchInfoClientResponse> getBranchInfo(BranchInfoClientRequest request);
}
