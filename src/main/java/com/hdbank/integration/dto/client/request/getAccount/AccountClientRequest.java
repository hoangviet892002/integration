package com.hdbank.integration.dto.client.request.getAccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountClientRequest {
    @JsonProperty("client_no")
    private String clientNo;
    @JsonProperty("acct_status")
    private String acctStatus;
    @JsonProperty("depositType")
    private String deposit_type;
    @JsonProperty("acctCcy")
    private String acct_ccy;

}
