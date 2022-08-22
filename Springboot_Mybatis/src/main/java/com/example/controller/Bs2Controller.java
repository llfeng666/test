package com.example.controller;

import com.example.entity.BsFixByEidRequest;
import com.example.entity.BsRequest;
import com.example.entity.BsResponse;
import com.example.entity.PayInDukpay;
import com.example.service.Bs2QueryService;
import com.example.service.Bs2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理生产客户问题
 */
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
     * @param
     * @return
     */
    @PostMapping("/fixProblemByEidAndId")
    public BsResponse fixProblemByEidAndId(@RequestBody BsRequest request)
            throws InterruptedException {


        return bs2Service.fixProblemByEidAndId(request);
    }


    /**
     * 1.查询bs2 获取token
     * 2.根据E2Eid 返回结果 取
     * 3.根据id 查询 自己的库
     * 4.调自己接口
     * @param
     * @return
     */
    @PostMapping("/fixProblemByEid")
    public BsResponse fixProblemByEid(@RequestBody BsFixByEidRequest request)
            throws InterruptedException {

        return bs2Service.fixProblemByEidAndId(request);
    }

    @RequestMapping("getStatusById/{idempotencyKey}")
    public BsResponse getStatusById(@PathVariable String idempotencyKey){

        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayById(idempotencyKey);
        if (payInDukpay==null) {
            return BsResponse.builder().errorMsg("根据idempotencyKey 数据库中没查询到记录").errorCode("000000").build();
        }
        return  BsResponse.builder().status(payInDukpay.getTransferStatus()).errorCode("000000").build();
    }

    @RequestMapping("getStatusByEId/{eId}")
    public BsResponse getStatusByEid(@PathVariable String eId){

        PayInDukpay payInDukpay = bs2QueryService.queryPayInDukpayByEId(eId);
        if (payInDukpay==null) {
            return BsResponse.builder().errorMsg("根据eId 数据库中没查询到记录").errorCode("000000").build();
        }
        return  BsResponse.builder().status(payInDukpay.getTransferStatus()).errorCode("000000").build();
    }

}
