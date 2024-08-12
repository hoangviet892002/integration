package com.hdbank.integration.dto.client.request.getInfoCustomer;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BranchInfoClientRequest {
    @JsonProperty("ctrl_Branch")
    private String ctrlBranch;
}
