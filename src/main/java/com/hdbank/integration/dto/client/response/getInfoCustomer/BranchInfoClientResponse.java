package com.hdbank.integration.dto.client.response.getInfoCustomer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchInfoClientResponse {
    @JsonProperty("branch_name")
    private String branchName;
}
