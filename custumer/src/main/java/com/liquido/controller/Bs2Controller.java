package com.liquido.controller;

import java.util.Objects;

import javax.validation.Valid;

import com.liquido.entity.BsRequest;
import com.liquido.entity.BsResponse;
import com.liquido.entity.PayInDukpay;
import com.liquido.enums.PayInTableNames;
import com.liquido.service.Bs2QueryService;
import com.liquido.service.Bs2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理生产客户问题
 */
@Slf4j
@RestController
@RequestMapping("/deal")
public class Bs2Controller {

    @Autowired
    private Bs2Service bs2Service;

    @Autowired
    private Bs2QueryService bs2QueryService;

    /**
     * 1.查询bs2 获取token
     * 2.根据E2Eid 返回结果 取
     * 3.根据id 查询 自己的库
     * 4.调自己接口
     *
     * @param
     * @return
     */
    @PostMapping("/fixProblemByEidAndId")
    public BsResponse fixProblemByEidAndId(@Valid @RequestBody BsRequest request)
            throws Exception {

        return bs2Service.fixProblemByEidAndId(request);
    }


    @GetMapping("getStatusById/{idempotencyKey}/{coName}")
    public BsResponse getStatusById(@PathVariable String idempotencyKey,
                                    @PathVariable String coName) {
        String tableName = PayInTableNames.findTableName(coName);
        if (Objects.isNull(tableName)) {
            log.error("暂不支持传入对商户名称");
            return BsResponse.builder().errorMsg("暂不支持传入对商户名称").build();
        }

        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey, tableName);
        if (payInDukpay == null) {
            return BsResponse.builder().errorMsg("根据idempotencyKey 数据库中没查询到记录")
                    .errorCode("000000").build();
        }
        return BsResponse.builder().status(payInDukpay.getTransferStatus()).errorCode("000000")
                .build();
    }

    @GetMapping("getStatusByEId/{eId}/{coName}")
    public BsResponse getStatusByEid(@PathVariable String eId, @PathVariable String coName) {
        String tableName = PayInTableNames.findTableName(coName);
        if (Objects.isNull(tableName)) {
            log.error("暂不支持传入对商户名称");
            return BsResponse.builder().errorMsg("暂不支持传入对商户名称").build();
        }
        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayByEId(eId, tableName);
        if (payInDukpay == null) {
            return BsResponse.builder().errorMsg("根据eId 数据库中没查询到记录").errorCode("000000")
                    .build();
        }
        return BsResponse.builder().status(payInDukpay.getTransferStatus()).errorCode("000000")
                .build();
    }


    /**
     * 退款
     * 用户提供幂等键 或者eid
     */
    @PostMapping("/refund")
    public BsResponse refund(@RequestBody BsRequest request)
            throws Exception {

        return bs2Service.refund(request);
    }

    @GetMapping("queryRefund/{e2eId}")
    public BsResponse queryRefund(@PathVariable String e2eId){
        return bs2Service.queryRefund(e2eId);
    }

}
