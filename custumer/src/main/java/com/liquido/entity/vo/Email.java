package com.liquido.entity.vo;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
    private String who;

    private String title;

    private String content;

    private String html;

    private String attachments;

}
