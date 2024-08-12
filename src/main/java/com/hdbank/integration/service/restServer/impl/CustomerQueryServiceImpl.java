package com.hdbank.integration.service.restServer.impl;

import com.hdbank.integration.dto.client.request.getInfoCustomer.AddressClientRequest;
import com.hdbank.integration.dto.client.request.getInfoCustomer.BranchInfoClientRequest;
import com.hdbank.integration.dto.client.request.getInfoCustomer.CountryClientRequest;
import com.hdbank.integration.dto.client.request.getInfoCustomer.CustomerClientRequest;
import com.hdbank.integration.dto.client.response.getInfoCustomer.AddressClientResponse;
import com.hdbank.integration.dto.client.response.getInfoCustomer.BranchInfoClientResponse;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CountryClientResponse;
import com.hdbank.integration.dto.client.response.getInfoCustomer.CustomerClientResponse;
import com.hdbank.integration.dto.server.request.CustomerInfoRequest;
import com.hdbank.integration.dto.server.response.BaseResponse;
import com.hdbank.integration.dto.server.response.CustomerInfo;
import com.hdbank.integration.dto.server.response.CustomerInfoResponse;
import com.hdbank.integration.service.restClient.restAccount.impl.*;
import com.hdbank.integration.service.restServer.CustomerQueryService;
import com.hdbank.integration.share.enums.ResponseEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

import static com.hdbank.integration.dto.server.response.BaseResponse.baseResponse;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_NOT_FOUND;
import static com.hdbank.integration.share.enums.ResponseEnum.DATA_SUCCESS;


@Service
@RequiredArgsConstructor
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final RestBranch restBranch;
    private final RestAddress restAddress;
    private final RestCountry restCountry;
    private final RestCustomer restCustomer;
    @Override
    public Mono<BaseResponse<CustomerInfoResponse>> getInfoCustomer(CustomerInfoRequest request) {
        return  validateRequest(request).then(
                Mono.deferContextual(ctx -> {
                    CustomerInfoResponse response = new CustomerInfoResponse();
                    response.setMsgCode(DATA_NOT_FOUND.getResponseCode());
                    response.setMsgName(DATA_NOT_FOUND.getDescription());
                    BaseResponse<CustomerInfoResponse> baseResponse = baseResponse("requestId",
                            ResponseEnum.SUCCESS);
                    baseResponse.setData(response);
                    return Mono.just(baseResponse);
                })
        );
//        return validateRequest(request)
//                .then(Mono.deferContextual(ctx -> {
//                    CustomerClientRequest customerClientRequest = new CustomerClientRequest(request.getClientNo());
//                    // transfer api request to rest client
//                    Mono<CustomerClientResponse>  customerClientResponseMono = restCustomer.getCustomerInfo(customerClientRequest);
//                    AddressClientRequest address1ClientRequest = new AddressClientRequest(customerClientRequest.getClient_no(), "PO1");
//                    AddressClientRequest address2ClientRequest = new AddressClientRequest(customerClientRequest.getClient_no(), "PO2");
//                    AddressClientRequest address3ClientRequest = new AddressClientRequest(customerClientRequest.getClient_no(), "PO3");
//                    Mono<AddressClientResponse> address1ClientResponseMono = restAddress.retrieveAddress(address1ClientRequest);
//                    Mono<AddressClientResponse> address2ClientResponseMono = restAddress.retrieveAddress(address2ClientRequest);
//                    Mono<AddressClientResponse> address3ClientResponseMono = restAddress.retrieveAddress(address3ClientRequest);
//                    BranchInfoClientRequest branchInfoClientRequest = new BranchInfoClientRequest(customerClientRequest.getClient_no());
//                    Mono<BranchInfoClientResponse> branchInfoClientResponseMono = restBranch.getBranchInfo(branchInfoClientRequest);
//                    CountryClientRequest countryClientRequest = new CountryClientRequest(customerClientRequest.getClient_no());
//                    Mono<CountryClientResponse> countryClientResponseMono = restCountry.getCountry(countryClientRequest);
//                    BaseResponse<CustomerInfoResponse> baseResponse = BaseResponse.baseResponse("requestId", null);
//                    CustomerInfoResponse response = new CustomerInfoResponse();
////                    if (customerClientResponseMono == null) {
////                        response.setMsgCode(DATA_NOT_FOUND.getResponseCode());
////                        response.setMsgName(DATA_NOT_FOUND.getDescription());
////                        baseResponse.setData(null);
////                        return Mono.just(baseResponse);
////                    }
//                     Mono.zip(customerClientResponseMono, address1ClientResponseMono, address2ClientResponseMono, address3ClientResponseMono, branchInfoClientResponseMono, countryClientResponseMono)
//                            .flatMap(tuple -> {
//                                CustomerClientResponse customerClientResponse = tuple.getT1();
//                                AddressClientResponse address1ClientResponse = tuple.getT2();
//                                AddressClientResponse address2ClientResponse = tuple.getT3();
//                                AddressClientResponse address3ClientResponse = tuple.getT4();
//                                BranchInfoClientResponse branchInfoClientResponse = tuple.getT5();
//                                CountryClientResponse countryClientResponse = tuple.getT6();
//                                CustomerInfo customerInfo = CustomerClientResponse.toCustomerInfo(customerClientResponse);
//                                customerInfo.setAddressPo1(address1ClientResponse.getAddress());
//                                customerInfo.setAddressPo2(address2ClientResponse.getAddress());
//                                customerInfo.setAddressPo3(address3ClientResponse.getAddress());
//                                customerInfo.setBranch(branchInfoClientResponse.getBranchName());
//                                customerInfo.setCountry(countryClientResponse.getCountry());
//                                response.setRecordset(customerInfo);
//                                response.setMsgCode(DATA_SUCCESS.getResponseCode());
//                                response.setMsgName(DATA_SUCCESS.getDescription());
//                                baseResponse.setData(response);
//                                return Mono.just(baseResponse);
//                            });
//                    return Mono.just(baseResponse);
//                }));
    }


    Mono<Void> validateRequest(CustomerInfoRequest request) {
        return Mono.empty();
    }
}
