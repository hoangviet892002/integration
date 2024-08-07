package com.hdbank.integration.share.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseStatusType {
    DATA_SUCCESS("Success", "1930", 1930, "Getting data success."),
    DATA_NOT_FOUND("Decline", "1931", 1931, "No information found");
    private final String status;
    private final String code;
    private final Integer codeAsInt;
    private final String description;
}
