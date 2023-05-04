package com.h.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.h.entity.po.EmailCode;

/**
 * <p>
 * 邮箱验证码 服务类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
public interface EmailCodeService extends IService<EmailCode> {

    /**
     * 发送邮箱验证码
     * @param email 邮箱
     * @param type 类型
     */
    void sendEmailCode(String email, Integer type);
}
