package com.hdbank.integration.dto.client.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
    @JsonProperty("acct_no")
    private String acct_no;
    @JsonProperty("branch ")
    private String branch ;

    // Constructor with default values
    public AccountResponse() {
        this.acct_no = "default_account_number";
        this.branch = "default_branch";
    }


}
