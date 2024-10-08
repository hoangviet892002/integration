package com.hdbank.integration.dto.server.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BaseRequest<T> {
    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("request_date")
    private String requestDate;

    @JsonProperty("request_user")
    private String requestUser;

    @JsonProperty("request_channel")
    private String requestChannel;

    @JsonProperty("data")
    private T data;
}
