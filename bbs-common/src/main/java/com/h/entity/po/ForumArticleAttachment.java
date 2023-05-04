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
 * 文件信息
 * </p>
 *
 * @author lin
 * @since 2023-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ForumArticleAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件ID
     */
    @TableId(value = "file_id", type = IdType.AUTO)
    private String fileId;

    /**
     * 文章ID
     */
    private String articleId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件类型
     */
    private Integer fileType;

    /**
     * 下载所需积分
     */
    private Integer integral;


}
