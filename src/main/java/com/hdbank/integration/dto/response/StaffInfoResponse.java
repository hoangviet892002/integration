package com.hdbank.integration.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffInfoResponse {
    @JsonProperty("msg_code")
    private String msgCode;

    @JsonProperty("msg_name")
    private String msgName;

    @JsonProperty("record_set")
    private StaffInfo recordset;
}
