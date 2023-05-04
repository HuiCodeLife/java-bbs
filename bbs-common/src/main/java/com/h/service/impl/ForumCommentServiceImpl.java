package com.h.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.po.ForumComment;
import com.h.mapper.ForumCommentMapper;
import com.h.service.ForumCommentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class ForumCommentServiceImpl extends ServiceImpl<ForumCommentMapper, ForumComment> implements ForumCommentService {

}
