package com.liquido.controller;

import com.liquido.entity.vo.Email;
import com.liquido.service.MailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/send")
public class SendEmail {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public void sendEmail(@RequestBody Email email){
        log.info("email:{}",email);
//        boolean send = mailService.send(email.getWho(),
////                email.getTitle()
////                , email.getContent());
        String[] attachments = new String[]{
                email.getAttachments()
        };
        boolean send = mailService.sendWithWithEnclosure(
                email.getWho(),
                email.getTitle(),
                email.getContent(),
                attachments
        );
        if (send) {
            log.info("发送成功");
        }


    }

}
