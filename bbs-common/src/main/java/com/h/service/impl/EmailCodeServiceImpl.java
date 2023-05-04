package com.h.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.h.config.WebConfig;
import com.h.core.Constants;
import com.h.core.exception.BusinessException;
import com.h.entity.po.EmailCode;
import com.h.entity.po.UserInfo;
import com.h.mapper.EmailCodeMapper;
import com.h.service.EmailCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * <p>
 * 邮箱验证码 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class EmailCodeServiceImpl extends ServiceImpl<EmailCodeMapper, EmailCode> implements EmailCodeService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private WebConfig webConfig;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendEmailCode(String email, Integer type) {
        if (Constants.ZERO.equals(type)) {
            UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getEmail, email));
            if (userInfo != null) {
                // 该邮箱已被注册
                throw new BusinessException("邮箱已经被注册了");
            }
        }
        String code = RandomUtil.randomString(RandomUtil.BASE_CHAR_NUMBER, 5);
        // 发送邮箱验证码
//        sendMailCode(email,code);
        // 验证码相关（TODO 此处可改为redis存储验证码）

        // 禁用之前的验证码
        baseMapper.disableEmailCode(email);

        // 保存验证码
        EmailCode emailCode = new EmailCode();
        emailCode.setCode(code);
        emailCode.setEmail(email);
        emailCode.setCreateTime(new Date());
        emailCode.setStatus(Constants.ZERO);
        baseMapper.insert(emailCode);
    }

    /**
     * 发送简单邮箱
     * @param toEmail 接收者
     * @param code 验证码
     */
    private void sendMailCode(String toEmail, String code) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            // 发件人
            helper.setFrom(webConfig.getMailUsername());
            // 接收人
            helper.setTo(toEmail);
            // 标题
            helper.setSubject("注册邮箱验证码");
            // 内容
            helper.setText("验证码:",code);
            helper.setSentDate(new Date());
        } catch (MessagingException e) {
            log.error("邮件发送失败");
        }

    }
}
