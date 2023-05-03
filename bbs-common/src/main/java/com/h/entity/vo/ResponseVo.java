package com.h.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: Lin
 * @since: 2023-05-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseVo<T> {
    private String status;
    private Integer code;
    private String info;
    private T data;
}
