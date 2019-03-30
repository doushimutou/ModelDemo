package com.example.api.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Description
 * Author ayt  on
 */
@Data
public class DispatchFilterUpdateDTO extends DispatchFilterBaseDTO implements Serializable {

    private static final long serialVersionUID = 1343896825559814227L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 操作人
     */
    private String staffCode;
}
