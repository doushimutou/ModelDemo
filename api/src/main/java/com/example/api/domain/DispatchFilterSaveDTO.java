package com.example.api.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Description
 * Author ayt  on
 */
@Data
public class DispatchFilterSaveDTO extends DispatchFilterBaseDTO implements Serializable {

    private static final long serialVersionUID = 7218923039924946290L;

    /**
     * 操作人
     */
    private String staffCode;
}
