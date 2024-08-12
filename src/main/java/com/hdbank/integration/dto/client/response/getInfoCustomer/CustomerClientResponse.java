package com.hdbank.integration.dto.client.response.getInfoCustomer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hdbank.integration.dto.server.response.CustomerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
@Getter
public class CustomerClientResponse {
    @JsonProperty("client_name")
    private String clientName;
    @JsonProperty("client_short")
    private String clientShort;
    @JsonProperty("client_type")
    private String clientType;
    @JsonProperty("state")
    private String state;
    @JsonProperty("client_no")
    private String clientNo;
    @JsonProperty("global_id")
    private String globalId;
    @JsonProperty("tax_file_no")
    private String taxFileNo;
    @JsonProperty("ctrl_branch")
    private String branch;
    @JsonProperty("dt_of_issuance")
    private String dateOfIssue;
    @JsonProperty("place_of_issuance")
    private String placeOfIssue;
    @JsonProperty("registered_capital")
    private String registeredCapital;
    @JsonProperty("name_contact_person")
    private String nameContactPerson;
    @JsonProperty("general_director_name")
    private String generalDirectorName;
    @JsonProperty("chief_accountant_name")
    private String chiefAccountantName;

    public CustomerClientResponse() {

    }



    public static CustomerClientResponse Default(){
        CustomerClientResponse customerInfoResponse = new CustomerClientResponse();
        customerInfoResponse.setClientName("Default Client");
        customerInfoResponse.setClientShort("Default Short");
        customerInfoResponse.setClientType("Default Type");
        customerInfoResponse.setState("Default State");
        customerInfoResponse.setClientNo("Default No");
        customerInfoResponse.setGlobalId("Default Global Id");
        customerInfoResponse.setTaxFileNo("Default Tax File No");
        customerInfoResponse.setBranch("Default Branch");
        customerInfoResponse.setDateOfIssue("Default Date of Issue");
        customerInfoResponse.setPlaceOfIssue("Default Place of Issue");
        customerInfoResponse.setRegisteredCapital("Default Registered Capital");
        customerInfoResponse.setNameContactPerson("Default Name Contact Person");
        customerInfoResponse.setGeneralDirectorName("Default General Director Name");
        customerInfoResponse.setChiefAccountantName("Default Chief Accountant Name");
        return customerInfoResponse;
    }

    public static CustomerInfo toCustomerInfo(CustomerClientResponse customerClientResponse) {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setClientName(customerClientResponse.getClientName());
        customerInfo.setClientShort(customerClientResponse.getClientShort());
        customerInfo.setClientType(customerClientResponse.getClientType());
        customerInfo.setState(customerClientResponse.getState());
        customerInfo.setClientNo(customerClientResponse.getClientNo());
        customerInfo.setGlobalId(customerClientResponse.getGlobalId());
        customerInfo.setTaxFileNo(customerClientResponse.getTaxFileNo());
        customerInfo.setBranch(customerClientResponse.getBranch());
        customerInfo.setDateOfIssue(customerClientResponse.getDateOfIssue());
        customerInfo.setPlaceOfIssue(customerClientResponse.getPlaceOfIssue());
        customerInfo.setRegisteredCapital(customerClientResponse.getRegisteredCapital());
        customerInfo.setNameContactPerson(customerClientResponse.getNameContactPerson());
        customerInfo.setGeneralDirectorName(customerClientResponse.getGeneralDirectorName());
        customerInfo.setChiefAccountantName(customerClientResponse.getChiefAccountantName());
        return customerInfo;
    }



    public  void setData (CustomerClientResponse customerInfo) {
        this.clientName = customerInfo.getClientName();
        this.clientShort = customerInfo.getClientShort();
        this.clientType = customerInfo.getClientType();
        this.state = customerInfo.getState();
        this.clientNo = customerInfo.getClientNo();
        this.globalId = customerInfo.getGlobalId();
        this.taxFileNo = customerInfo.getTaxFileNo();
        this.branch = customerInfo.getBranch();
        this.dateOfIssue = customerInfo.getDateOfIssue();
        this.placeOfIssue = customerInfo.getPlaceOfIssue();
        this.registeredCapital = customerInfo.getRegisteredCapital();
        this.nameContactPerson = customerInfo.getNameContactPerson();
        this.generalDirectorName = customerInfo.getGeneralDirectorName();
        this.chiefAccountantName = customerInfo.getChiefAccountantName();
    }



}
