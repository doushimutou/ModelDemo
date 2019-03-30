package com.example.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Data
public class DispatchFilterBaseDTO implements Serializable {

    private static final long serialVersionUID = 8534915133316600401L;
    /**
     *排序值
     */
    private Integer sort;

    /**
     *过滤器名称
     */
    private String name;

    /**
     *过滤器类名称
     */
    private String className;

    /**
     *code
     */
    private Integer code;

    /**
     *版本号
     */
    private String version;

    /**
     *描述
     */
    private String description;

    /**
     * 使用场景描述
     */
    private String usageScenario;

    /**
     * 绑定参数服务key列表
     */
    private List<String> parameterKeys;
}
