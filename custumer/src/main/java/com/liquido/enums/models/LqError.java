package com.liquido.enums.models;

import java.util.List;

import com.liquido.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder
@AllArgsConstructor
public class LqError {
    @NonNull
    List<BaseError> errors;

    public static LqError toSingleError(final ResultCode resultCode, final String message) {
        return LqError.builder()
                .errors(List.of(
                        BaseError.builder()
                                .code(resultCode)
                                .errorMessage(StringUtils.defaultIfBlank(message,
                                        resultCode.getMessage()))
                                .build()))
                .build();
    }
}
