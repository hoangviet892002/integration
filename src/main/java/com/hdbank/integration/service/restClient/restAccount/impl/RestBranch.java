package com.hdbank.integration.service.restClient.restAccount.impl;

import com.hdbank.integration.dto.client.request.getAccount.BranchClientRequest;
import com.hdbank.integration.dto.client.request.getInfoCustomer.BranchInfoClientRequest;
import com.hdbank.integration.dto.client.response.getAccount.BranchClientResponse;
import com.hdbank.integration.dto.client.response.getInfoCustomer.BranchInfoClientResponse;
import com.hdbank.integration.service.restClient.restAccount.IRestBranch;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class RestBranch implements IRestBranch {
    @Override
    public Mono<BranchClientResponse> getBranch(BranchClientRequest request) {
        BranchClientResponse branchClientResponse = new BranchClientResponse("Default Branch");
        return Mono.just(branchClientResponse);
    }

    @Override
    public Mono<BranchInfoClientResponse> getBranchInfo(BranchInfoClientRequest request) {
        BranchInfoClientResponse branchInfoClientRequest = new BranchInfoClientResponse("Default Branch Info");
        return Mono.just(branchInfoClientRequest);
    }
}
