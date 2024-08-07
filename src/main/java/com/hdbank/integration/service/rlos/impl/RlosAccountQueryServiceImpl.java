package com.hdbank.integration.service.rlos.impl;

import com.hdbank.integration.dto.request.BaseRequest;
import com.hdbank.integration.dto.request.RetrievesAccountRequest;
import com.hdbank.integration.dto.response.AccountResponse;
import com.hdbank.integration.dto.response.BaseResponse;
import com.hdbank.integration.dto.response.RetrievesAccountResponse;
import com.hdbank.integration.service.restAccount.impl.RestAccount;
import com.hdbank.integration.service.rlos.RlosAccountQueryService;
import com.hdbank.integration.share.constant.CustomerConstant;
import com.hdbank.integration.share.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.hdbank.integration.dto.response.BaseResponse.baseResponse;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_NOT_FOUND;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_SUCCESS;




@Service
@RequiredArgsConstructor
public class RlosAccountQueryServiceImpl implements RlosAccountQueryService {

    private final RestAccount restAccount;
    @Override
    public Mono<BaseResponse<RetrievesAccountResponse>> retrievesAccount(BaseRequest<RetrievesAccountRequest> request) {
        return validateRequest(request.getData()).then(Mono.defer(() -> {
            Mono<List<AccountResponse>> accountResponseMono = checkValidAccount(request.getData());
            BaseResponse<RetrievesAccountResponse> baseResponse = baseResponse(request.getRequestId(),
                    ResponseEnum.SUCCESS);
            RetrievesAccountResponse response = new RetrievesAccountResponse();
            return accountResponseMono
                    .flatMap(accountResponse -> {
                        if (accountResponse != null && !accountResponse.isEmpty()) {
                            // Handle non-empty case
                            response.setMsgCode(DATA_SUCCESS.getResponseCode());
                            response.setMsgName(DATA_SUCCESS.getDescription());
                            List<AccountResponse> accountResponses = accountResponseList(accountResponse);
                            response.setRecordset(accountResponses);

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
    private Mono<List<AccountResponse>> checkValidAccount(RetrievesAccountRequest request) {
        return restAccount.getAccounts(request.getClientNo()).map(BaseResponse::getData);
    }
    private List<AccountResponse> accountResponseList(List<AccountResponse> accountResponse) {
        return accountResponse.stream().map(this::getAccountResponse).collect(Collectors.toList());
    }
    private AccountResponse getAccountResponse(AccountResponse accountResponse) {
        return AccountResponse.builder()
                .acct_no(accountResponse.getAcct_no())
                .branch(accountResponse.getBranch())
                .build();
    }
}
