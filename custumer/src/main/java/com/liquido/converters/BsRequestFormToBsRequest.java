package com.liquido.converters;

import com.liquido.entity.BsRequest;
import com.liquido.entity.vo.BsRequestForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 2022/8/30.
 */
@Component
public class BsRequestFormToBsRequest implements Converter<BsRequestForm, BsRequest> {

    @Override
    public BsRequest convert(BsRequestForm source) {
        return  BsRequest.builder().e2eId(source.getE2eId()).coName(source.getCoName())
                .idempotencyKey(source.getIdempotencykey()).build();

    }
}
