package com.hdbank.integration.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdbank.integration.dto.client.response.AccountResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetrievesClientResponse {
    @JsonProperty("msg_code")
    private String msgCode;

    @JsonProperty("msg_name")
    private String msgName;

    @JsonProperty("record_set")
    private List<ClientResponse> recordset;
}
