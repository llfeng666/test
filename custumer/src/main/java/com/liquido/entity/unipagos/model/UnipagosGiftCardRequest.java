package com.liquido.entity.unipagos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UnipagosGiftCardRequest {
    @NonNull
    private String externalId;
    @NonNull
    private String sku;
}

/**
 * {
 * // [required] The SKU of the "gift_card" service to sale
 * "sku": "NINT00200",
 * // [required] The unique ID provided by the client that is used to match future settlements
 * "externalId": "1234010",
 * }
 */
