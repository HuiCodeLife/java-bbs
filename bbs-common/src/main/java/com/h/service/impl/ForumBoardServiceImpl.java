package com.h.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.po.ForumBoard;
import com.h.mapper.ForumBoardMapper;
import com.h.service.ForumBoardService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章板块信息 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class ForumBoardServiceImpl extends ServiceImpl<ForumBoardMapper, ForumBoard> implements ForumBoardService {

}
