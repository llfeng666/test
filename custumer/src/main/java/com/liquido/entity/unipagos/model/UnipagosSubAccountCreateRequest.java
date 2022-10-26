package com.liquido.entity.unipagos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/*
 * https://unipagos.atlassian.net/wiki/spaces/UDW/pages/2727477257/merchants+sub-accounts#merchants/sub-accounts-POST
 */
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
public class UnipagosSubAccountCreateRequest {
    // [required] The sub-account id, the format must be: "sba-" prefix plus at least 24 hex UUID
    @NonNull
    String id;
    UnipagosSubAccountName formalName;
    // [optional] The user's gender (male or female)
    String gender;
    // [optional] The user main activity or occupation
    String occupation;
    // [required] The user's birth date
    @Builder.Default
    @NonNull
    String birthDate = "1980-01-01";
    // [required] The sub-account country Code.
    // This parameter helps to define the currency Code to generate the monetary account associated
    @NonNull
    String countryCode = "MX";

}
