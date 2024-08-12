package com.hdbank.integration.dto.client.request.getAccount;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class BranchClientRequest {
    @JsonProperty("clientNo")
    private String client_no;
    @JsonProperty("ctrlBranch")
    private String ctrl_branch;
}
