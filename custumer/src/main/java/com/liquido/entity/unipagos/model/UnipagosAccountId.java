package com.liquido.entity.unipagos.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class UnipagosAccountId {
    String type;
    String key;
}
