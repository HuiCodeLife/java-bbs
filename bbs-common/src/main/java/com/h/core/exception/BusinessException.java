package com.h.core.exception;

import com.h.core.ResponseCodeEnum;
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
public class BusinessException extends RuntimeException{
    private ResponseCodeEnum codeEnum;
    private Integer code;
    private String message;

}
