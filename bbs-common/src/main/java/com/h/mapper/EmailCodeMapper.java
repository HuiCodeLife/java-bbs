package com.h.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h.entity.po.EmailCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 邮箱验证码 Mapper 接口
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Mapper
public interface EmailCodeMapper extends BaseMapper<EmailCode> {

    /**
     * 禁用之前的验证码
     * @param email 邮箱
     */
    void disableEmailCode(@Param("email") String email);
}
