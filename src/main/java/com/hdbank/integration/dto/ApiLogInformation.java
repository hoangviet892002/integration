package com.hdbank.integration.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiLogInformation {
    private String requestId;
    private String traceId;
    private long startTime;
    private long endTime;
    private Boolean hasError;
}
