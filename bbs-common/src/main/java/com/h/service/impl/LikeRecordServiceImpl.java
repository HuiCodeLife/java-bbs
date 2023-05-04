package com.h.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.po.LikeRecord;
import com.h.mapper.LikeRecordMapper;
import com.h.service.LikeRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 点赞记录 服务实现类
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Service
public class LikeRecordServiceImpl extends ServiceImpl<LikeRecordMapper, LikeRecord> implements LikeRecordService {

}
