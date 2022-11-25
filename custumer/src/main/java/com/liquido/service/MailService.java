package com.liquido.service;

public interface MailService {


    boolean sendWithHtml(String to, String subject, String html);

    /**
     * 发送带有图片的 html 的邮件
     * @param to
     * @param subject
     * @param html
     * @param cids
     * @param filePaths
     * @return
     */
    boolean sendWithImageHtml(String to, String subject, String html, String[] cids, String[] filePaths);


    /**
     * 发送带有附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePaths
     * @return
     */
    boolean sendWithWithEnclosure(String to, String subject, String content, String[] filePaths);

    boolean send(String to, String subject, String content);
}
