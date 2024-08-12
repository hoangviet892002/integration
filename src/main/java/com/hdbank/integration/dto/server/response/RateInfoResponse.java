package com.hdbank.integration.dto.server.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateInfoResponse {
    @JsonProperty("msg_code")
    private String msgCode;

    @JsonProperty("msg_name")
    private String msgName;

    @JsonProperty("record_set")
    private RateInfo recordset;
}
