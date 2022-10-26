package com.liquido.entity.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UnipagosSubAccountName {
    // [optional] A friendly name, or alias for the account
    String friendly;
    // [required] The user's given name or names, that owns the sub-account
    @NonNull
    String given;
    // [required] The user's paternal name, that owns the sub-account
    @NonNull
    String paternal;
    // [optional] The user's paternal name, that owns the sub-account
    String maternal;
}
