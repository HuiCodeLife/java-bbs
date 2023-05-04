package com.h.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 点赞记录
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LikeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "op_id", type = IdType.AUTO)
    private Integer opId;

    /**
     * 操作类型0:文章点赞 1:评论点赞
     */
    private Integer opType;

    /**
     * 主体ID
     */
    private String objectId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 发布时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 主体作者ID
     */
    private String authorUserId;


}
