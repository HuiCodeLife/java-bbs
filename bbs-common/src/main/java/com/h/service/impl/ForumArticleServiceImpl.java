package com.h.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.po.ForumArticle;
import com.h.mapper.ForumArticleMapper;
import com.h.service.ForumArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章信息 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class ForumArticleServiceImpl extends ServiceImpl<ForumArticleMapper, ForumArticle> implements ForumArticleService {

}
