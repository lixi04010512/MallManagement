package com.jide.tools.service;

import com.jide.tools.service.dto.EmailDto;

/**
 * 邮箱服务接口
 *
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param emailDto 邮箱列表
     */
    void send(EmailDto emailDto);
}
