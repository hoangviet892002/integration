package com.hdbank.integration.dto.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfoResponse {
    @JsonProperty("msg_code")
    private String msgCode;

    @JsonProperty("msg_name")
    private String msgName;

    @JsonProperty("record_set")
    private CustomerInfo recordset;
}
