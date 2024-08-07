package com.hdbank.integration.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffInfo {
    @JsonProperty("emp_code")
    private String empCode;

    @JsonProperty("emp_name")
    private String empName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("gender_desc")
    private String genderDesc;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("emp_phone")
    private String empPhone;

    @JsonProperty("emp_email")
    private String empEmail;

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_desc")
    private String statusDesc;
}
