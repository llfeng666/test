package com.example.controller;


import com.example.entity.WorkItemResponse;
import com.example.service.WorkItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *查询回调信息
 */
@Slf4j
@RestController
@RequestMapping("/getCallBackInfo")
public class CallBackInfoController {

    @Autowired
    private WorkItemService workItemService;

    /**
     * 根据商户和幂等键 获取回调信息
     * @param idempotencyKey
     * @param coName
     * @return
     * @throws Exception
     */
    @GetMapping("queryCallBackInfo/{idempotencyKey}/{coName}")
    public WorkItemResponse queryCallBackInfo(@PathVariable String idempotencyKey,
                                              @PathVariable String coName) {

        return workItemService.queryCallBackInfo(idempotencyKey,coName);
    }

}
