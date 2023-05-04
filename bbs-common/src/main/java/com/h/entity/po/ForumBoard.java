package com.h.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章板块信息
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ForumBoard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 板块ID
     */
    @TableId(value = "board_id", type = IdType.AUTO)
    private Integer boardId;

    /**
     * 父级板块ID
     */
    private Integer pBoardId;

    /**
     * 板块名
     */
    private String boardName;

    /**
     * 封面
     */
    private String cover;

    /**
     * 描述
     */
    private String boardDesc;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 0:只允许管理员发帖 1:任何人可以发帖
     */
    private Boolean postType;


}
