package com.hdbank.integration.dto.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class AccountResponse {
    @JsonProperty("acct_no")
    private String acctNo;
    @JsonProperty("branch")
    private String branch ;

    // Constructor with default values
}
