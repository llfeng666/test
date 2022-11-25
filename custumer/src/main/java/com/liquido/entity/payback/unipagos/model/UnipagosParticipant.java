package com.liquido.entity.payback.unipagos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class UnipagosParticipant {
    String type;    // 'clabe', 'mdn'
    String key;     // value
}
