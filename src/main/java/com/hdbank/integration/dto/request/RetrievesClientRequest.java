package com.hdbank.integration.dto.request;

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
public class RetrievesClientRequest {
    @JsonProperty("client_no")
    private String clientNo;

    @JsonProperty("client_type")
    private String clientType;

    @JsonProperty("id_number")
    private String idNumber;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("id_type")
    private String idType;

    @JsonProperty("registration_number")
    private String registrationNumber;

    @JsonProperty("is_absolute")
    private Integer pIsAbsolute;
}
