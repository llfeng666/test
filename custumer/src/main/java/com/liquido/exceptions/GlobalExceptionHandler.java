package com.liquido.exceptions;


import com.liquido.enums.ResultCode;
import com.liquido.enums.models.LqError;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.google.common.base.VerifyException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
public abstract class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_INVALID_REQUEST_MESSAGE = "Invalid request message";

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            final HttpMessageNotReadableException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request
    ) {
        String msg = null;
        final var cause = ex.getCause();

        if (cause instanceof JsonParseException) {
            final var jpe = (JsonParseException) cause;
            msg = jpe.getOriginalMessage();
        } else if (cause instanceof MismatchedInputException) {
            final var mie = (MismatchedInputException) cause;
            if (!CollectionUtils.isEmpty(mie.getPath())) {
                msg = "Invalid request field: " + mie.getPath().get(0).getFieldName();
            } else {
                msg = DEFAULT_INVALID_REQUEST_MESSAGE;
            }
        } else if (cause instanceof ValueInstantiationException) {
            final var vie = (ValueInstantiationException) cause;
            final var innerCause = vie.getCause();
            if (innerCause instanceof NullPointerException) {
                final var npe = (NullPointerException) innerCause;
                msg = npe.getMessage();
            } else {
                msg = DEFAULT_INVALID_REQUEST_MESSAGE;
            }
        } else if (cause instanceof JsonMappingException) {
            final var jme = (JsonMappingException) cause;
            final var originalMessage = jme.getOriginalMessage();
            if (!CollectionUtils.isEmpty(jme.getPath())) {
                msg = "Invalid request field: " + jme.getPath().get(0).getFieldName()
                        + ": " + originalMessage;
            } else {
                final var innerCause = cause.getCause();
                if (innerCause instanceof VerifyException) {
                    final var ve = (VerifyException) innerCause;
                    msg = ve.getMessage();
                } else if (innerCause instanceof IllegalStateException) {
                    final var ise = (IllegalStateException) innerCause;
                    msg = ise.getMessage();
                }
            }
        }

        log.warn("Http request not readable: request={}, msg={}", request, msg);
        final var lqError = LqError.toSingleError(ResultCode.INVALID_REQUEST, msg);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(lqError);
    }

    @ExceptionHandler(DuplicatedResourceException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected LqError handleDuplicatedResourceException(
            final DuplicatedResourceException ex,
            final WebRequest request
    ) {
        final var message = StringUtils.defaultIfEmpty(ex.getMessage(), "");
        return LqError.toSingleError(ResultCode.RESOURCE_DUPLICATED, message);
    }
}
