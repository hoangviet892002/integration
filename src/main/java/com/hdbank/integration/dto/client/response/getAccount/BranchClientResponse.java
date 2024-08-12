package com.hdbank.integration.dto.client.response.getAccount;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchClientResponse {
    @JsonProperty("branch")
    private String branch;
}
