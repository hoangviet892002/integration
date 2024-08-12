package com.hdbank.integration.service.restServer.impl;

import com.hdbank.integration.dto.client.request.getAccount.AccountClientRequest;
import com.hdbank.integration.dto.client.request.getAccount.BranchClientRequest;
import com.hdbank.integration.dto.client.response.getAccount.AccountClientResponse;
import com.hdbank.integration.dto.server.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.server.response.AccountResponse;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.RetrievesAccountResponse;
import com.hdbank.integration.service.restClient.restAccount.impl.RestAccount;
import com.hdbank.integration.service.restClient.restAccount.impl.RestBranch;
import com.hdbank.integration.service.restServer.RlosAccountQueryService;
import com.hdbank.integration.share.constant.CustomerConstant;
import com.hdbank.integration.share.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.hdbank.integration.dto.server.response.BaseResponse.baseResponse;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_NOT_FOUND;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_SUCCESS;




@Service
@RequiredArgsConstructor
public class RlosAccountQueryServiceImpl implements RlosAccountQueryService {

    private final RestAccount restAccount;

    private final RestBranch restBranch;
    @Override
    public Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(RetrievesAccountRequest request) {
        AccountClientRequest accountClientRequest = new AccountClientRequest(request.getClientNo(), "C", "C", "VND");
        return  validateRequest(request).then(Mono.deferContextual(ctx -> {
            //transfer cai requestID tu context sang de su dung

            Mono<List<AccountClientResponse>> accountResponseClientMono = checkValidAccount(accountClientRequest);
            BaseResponse<RetrievesAccountResponse> baseResponse = baseResponse("requestId",
                    ResponseEnum.SUCCESS);
            RetrievesAccountResponse response = new RetrievesAccountResponse();
            return accountResponseClientMono
                    .flatMap(accountClientResponses -> {
                        if (accountClientResponses != null && !accountClientResponses.isEmpty()) {
                            // Handle non-empty case

//                            List<AccountResponse> accountResponses = accountResponseList(accountResponse);
//
                            Mono<List<AccountResponse>> accountsResponseMono = Flux.fromIterable(accountClientResponses)
                                    .flatMap(accountClientResponse -> {
                                        BranchClientRequest branchClientRequest = new BranchClientRequest(request.getClientNo(),accountClientResponse.getBranchNo());
                                        return restBranch.getBranch(branchClientRequest)
                                                .map(branchClientResponse -> AccountResponse.builder()
                                                        .acctNo(accountClientResponse.getAcctNo())
                                                        .branch(branchClientResponse.getBranch())
                                                        .build());
                                    })
                                    .collectList();
                            response.setRecordset(accountsResponseMono.block());
                            response.setMsgCode(DATA_SUCCESS.getResponseCode());
                            response.setMsgName(DATA_SUCCESS.getDescription());


                        } else {
                            // Handle empty case
                            response.setMsgCode(DATA_NOT_FOUND.getResponseCode());
                            response.setMsgName(DATA_NOT_FOUND.getDescription());
                        }
                        baseResponse.setData(response);
                        return Mono.just(baseResponse);
                    });

        }));
    }
    private Mono<Void> validateRequest(RetrievesAccountRequest request) {
        if (StringUtils.hasLength(request.getClientNo()) && request.getClientNo().length() < CustomerConstant.LENGTH_CLIENT) {
            return Mono.error(new BadRequestException("Client reference must be at least 6 characters long"));
        }
        return Mono.empty();
    }
    private Mono<List<AccountClientResponse>> checkValidAccount(AccountClientRequest request) {
        return restAccount.getAccounts(request);
    }
//    private Mono<List<AccountResponse>> validAccounts (String clientNo) {
//        var result = restAccount.getAccounts(new AccountClientRequest(clientNo, "C", "C", "VND"));
//        Mono<List<AccountResponse>> monoListAccountResponse = result.map(Collections::singletonList);
//        return monoListAccountResponse.flatMapMany(Flux::fromIterable)
//                .filter(accountResponse -> accountResponse.getAcctNo() != null)
//                .collectList();
//    }


    private List<AccountResponse> accountResponseList(List<AccountResponse> accountResponse) {
        return accountResponse.stream().map(this::getAccountResponse).collect(Collectors.toList());
    }
    private AccountResponse getAccountResponse(AccountResponse accountResponse) {
        return AccountResponse.builder()
                .acctNo(accountResponse.getAcctNo())
                .branch(accountResponse.getBranch())
                .build();
    }
}
