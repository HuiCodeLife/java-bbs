package com.h.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import com.h.core.BaseController;
import com.h.core.Constants;
import com.h.core.ResponseCodeEnum;
import com.h.core.exception.BusinessException;
import com.h.entity.vo.ResponseVo;
import com.h.service.EmailCodeService;
import com.h.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Lin
 * @since: 2023-05-04
 */
@RestController
public class AccountController extends BaseController {

    @Autowired
    private EmailCodeService emailCodeService;

    @GetMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws IOException {
        //定义图形验证码的长和宽
        GifCaptcha vCode = CaptchaUtil.createGifCaptcha(200, 100);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        if (type == null || type == 0) {
            session.setAttribute(Constants.CHECK_CODE_KEY_REGISTER, code);
        } else {
            session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
        }
        vCode.write(response.getOutputStream());
    }


    @GetMapping("/sendEmailCode")
    public ResponseVo<String> sendEmailCode(HttpSession session, String email, String checkCode, Integer type) {
        try {
            if (StringTools.isEmpty(email) || StringTools.isEmpty(checkCode) || type == null) {
                throw new BusinessException(ResponseCodeEnum.CODE_600);
            }
            if (!checkCode.equalsIgnoreCase((String)session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))){
                throw new BusinessException("验证码错误");
            }
            // 发送验证码
            emailCodeService.sendEmailCode(email,type);
            return getSuccessResponseVo(null);
        } finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
        }
    }


    @GetMapping("/register")
    public ResponseVo<String> checkCode(HttpSession session, String checkCode) {
        if (checkCode == null || "".equals(checkCode)) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        String sessionCode = (String) session.getAttribute(Constants.CHECK_CODE_KEY_REGISTER);
        if (sessionCode.equalsIgnoreCase(checkCode)) {
            return getSuccessResponseVo("验证成功");
        } else {
            throw new BusinessException("验证失败");
        }
    }

}
