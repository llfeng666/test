package com.liquido.enums.models;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;


public enum LqEntity {
    PAYIN("100", true),
    PAYOUT("200", true),
    USER("U", false),
    MERCHANT("M", false),
    ;

    @Getter
    private final String id;

    @Getter
    private final boolean isProductFacing;

    LqEntity(final String id, final boolean isProductFacing) {
        this.id = id;
        this.isProductFacing = isProductFacing;
    }

    private static final Map<String, LqEntity> BY_ID = Arrays.stream(LqEntity.values())
            .collect(Collectors.toMap(LqEntity::getId, lqEntity -> lqEntity));

    private static final Set<LqEntity> PRODUCT_FACING_ENTITIES = Arrays.stream(LqEntity.values())
            .filter(LqEntity::isProductFacing)
            .collect(Collectors.toCollection(() -> EnumSet.noneOf(LqEntity.class)));

    public static Optional<LqEntity> getById(final String id) {
        return Optional.of(BY_ID.getOrDefault(id, null));
    }

    public static Set<LqEntity> getProductFacingEntities() {
        return PRODUCT_FACING_ENTITIES;
    }

}
