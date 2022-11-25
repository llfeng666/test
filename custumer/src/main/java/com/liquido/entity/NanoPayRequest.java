package com.liquido.entity;


import java.util.Optional;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class NanoPayRequest {

    @NotNull(message = "accountId不能为空")
    private String accountId;

    @NotNull(message = "amount不能为空")
    private String amount;

    private String trackingId;

    public Optional<String> getTrackingId(){
        return Optional.ofNullable(trackingId);
    }

}