package com.example.controller;

import java.util.List;

import com.example.entity.SubAccountsNanopay;
import com.example.entity.SubAccountsNanopayExample;
import com.example.entity.UnipagosRequest;
import com.example.entity.vo.BasicResultVO;
import com.example.mapper.SubAccountsNanopayMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UnipagosController {

    @Autowired
    private SubAccountsNanopayMapper subAccountsNanopayMapper;

    @PostMapping("/unipagos")
    public BasicResultVO queryStatus(@RequestBody UnipagosRequest request)
            throws Exception {
        SubAccountsNanopayExample subAccountsExample = new SubAccountsNanopayExample();
        SubAccountsNanopayExample.Criteria criteria = subAccountsExample.createCriteria();
        criteria.andAccountIdEqualTo(request.getAccountId());

        final List<SubAccountsNanopay> subAccountsNanopays =
                subAccountsNanopayMapper.selectByExample(subAccountsExample);
        return BasicResultVO.success(subAccountsNanopays);
    }
}
