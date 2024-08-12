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
public class RateInfo {
    @JsonProperty("cyy")
    private String cyy;

    @JsonProperty("ccy_name")
    private String ccy_rate;
}
