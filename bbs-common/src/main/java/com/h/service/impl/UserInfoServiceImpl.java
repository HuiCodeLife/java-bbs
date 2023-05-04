package com.h.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.po.UserInfo;
import com.h.mapper.UserInfoMapper;
import com.h.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
