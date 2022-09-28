package com.liquido.facade.bs2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.liquido.enums.models.PaymentStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Bs2PayoutStatus {
    CREATED(
            "INICIADO",
            PaymentStatus.INITIAL_STATUS
    ),
    ERROR(
            "ERRO",
            PaymentStatus.FAILED
    ),
    SCHEDULED(
            "CONFIRMADO",
            PaymentStatus.IN_PROGRESS
    ),
    SUCCESS(
            "EFETIVADO",
            PaymentStatus.SETTLED
    ),
    REFUNDED(
            "EXPIRADO",
            PaymentStatus.FAILED
    );

    private final String status;
    private final PaymentStatus internalStatus;

    Bs2PayoutStatus(
            final String status,
            final PaymentStatus internalStatus
    ) {
        this.status = status;
        this.internalStatus = internalStatus;
    }

    public String getStatus() {
        return this.status;
    }

    public PaymentStatus getInternalStatus() {
        return this.internalStatus;
    }

    private static final Map<String, Bs2PayoutStatus> BY_STATUS =
            Arrays.stream(Bs2PayoutStatus.values()).collect(
                    Collectors.toMap(Bs2PayoutStatus::getStatus, Function.identity()));


    public static Bs2PayoutStatus toStatus(final String status) {
        if (!BY_STATUS.containsKey(status)) {
            log.error(
                    "Found unexpected payout status = {}",
                    status
            );
            return SCHEDULED;
        }
        return BY_STATUS.get(status);
    }

    public static boolean isFailed(final Bs2PayoutStatus status) {
        return REFUNDED.equals(status);
    }
}
