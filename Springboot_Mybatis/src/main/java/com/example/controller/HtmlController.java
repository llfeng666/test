package com.example.controller;

import com.example.converters.BsRequestFormToBsRequest;
import com.example.entity.BsResponse;
import com.example.entity.Proof;
import com.example.entity.vo.BsRequestForm;
import com.example.enums.PayOutTableNames;
import com.example.service.Bs2QueryService;
import com.example.service.Bs2Service;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HtmlController {

    @Autowired
    private Bs2QueryService bs2QueryService;

    @Autowired
    private Bs2Service bs2Service;


    @Autowired
    private BsRequestFormToBsRequest bsRequestFormToBsRequest;





    @RequestMapping({"/bs2/list", "/bs"})
    public String listProducts(Model model){
        model.addAttribute("bsRequestForm", new BsRequestForm());
        return "bs/createProof";
    }



    //生成凭证界面
    @RequestMapping(value = "/bs2/show",method = RequestMethod.POST)
    public String createProof( BsRequestForm bsRequestForm,Model model){
        //前端判断非空  合作方必输
        final String e2eId = bsRequestForm.getE2eId();
        final String idempotencyKey = bsRequestForm.getIdempotencykey();
        if (StringUtils.isEmpty(e2eId)&&StringUtils.isEmpty(idempotencyKey)) {
            //e2eId 和 idempotencyKey 必输

        }

        //查询db 将数据返回出去
        final String tableName = PayOutTableNames.findTableName(bsRequestForm.getCoName());

        final Proof ploofInfo = bs2QueryService.getPloofInfo(bsRequestForm.getIdempotencykey(),
                bsRequestForm.getE2eId(), tableName);
        //将组装等数据 反显到界面 todo
        model.addAttribute("ploofInfo", ploofInfo);
        return "bs/BS2 Empresas";
    }


    //打开form表单
    @RequestMapping("/")
    public String submitFixInfo(Model model){
        model.addAttribute("bsRequestForm", new BsRequestForm());
        return "bs/fixProblems";
    }



   //提交表单事件  将原本信息带回来 并且返回成功 交易状况
    @RequestMapping(value ="/bs2/HandlerResult",method = RequestMethod.POST)
    public String fixProblems(BsRequestForm bsRequestForm,Model model) throws Exception {

        BsResponse bsResponse =
                bs2Service.fixProblemByEidAndId(bsRequestFormToBsRequest.convert(bsRequestForm));

        model.addAttribute("bsRequestForm", bsRequestForm);
        model.addAttribute("bsResponse", bsResponse);
        return "bs/fixProblems";
    }





}
