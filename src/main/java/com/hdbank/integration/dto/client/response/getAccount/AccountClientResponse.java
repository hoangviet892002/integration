package com.hdbank.integration.dto.client.response.getAccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AccountClientResponse {

    @JsonProperty("branch_no")
    private String branchNo;
    @JsonProperty("acct_no")
    private String acctNo;
}
