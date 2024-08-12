package com.hdbank.integration.dto.server.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
public class CustomerInfo {
    @JsonProperty("client_name")
    private String clientName;
    @JsonProperty("client_short")
    private String clientShort;
    @JsonProperty("client_type")
    private String clientType;
    @JsonProperty("country_desc")
    private String country;
    @JsonProperty("state_loc")
    private String state;
    @JsonProperty("client_no")
    private String clientNo;
    @JsonProperty("global_id")
    private String globalId;
    @JsonProperty("tax_file_no")
    private String taxFileNo;
    @JsonProperty("ctrl_branch")
    private String branch;
    @JsonProperty("branch_name")
    private String branchName;
    @JsonProperty("dt_of_issuance")
    private String dateOfIssue;
    @JsonProperty("place_of_issuance")
    private String placeOfIssue;
    @JsonProperty("registered_capital")
    private String registeredCapital;
    @JsonProperty("acct_exec")
    private String acctExec;
    @JsonProperty("fccpo1.address")
    private String addressPo1;
    @JsonProperty("fccpo2.address")
    private String addressPo2;
    @JsonProperty("fccpo3.address")
    private String addressPo3;
    @JsonProperty("name_contact_person")
    private String nameContactPerson;
    @JsonProperty("general_director_name")
    private String generalDirectorName;
    @JsonProperty("president_name")
    private String presidentName;
    @JsonProperty("chief_accountant_name")
    private String chiefAccountantName;


}
