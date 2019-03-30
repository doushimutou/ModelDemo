package com.example.impl;

import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.exception.DispatchFilterConfigException;
import org.apache.commons.lang3.StringUtils;


/**
 * Description
 * Author ayt  on
 */
public class ValidationUtil {
    public static void validate (DispatchFilterSaveDTO dispatchFilterSaveDTO){
        if (dispatchFilterSaveDTO == null) {
            throw new DispatchFilterConfigException("过滤器设计保存参数不能为null");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getStaffCode())){
            throw new DispatchFilterConfigException("操作人不能为空");
        }
        if (dispatchFilterSaveDTO.getSort() == null) {
            throw new DispatchFilterConfigException("排序值不能为空");
        }
        if (dispatchFilterSaveDTO.getSort() < 0) {
            throw new DispatchFilterConfigException("排序值不能为负数");
        }
        if (dispatchFilterSaveDTO.getSort().toString().length() > 6) {
            throw new DispatchFilterConfigException("排序值不能超过6位数");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getName())) {
            throw new DispatchFilterConfigException("过滤器名称不能为空");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getClassName())) {
            throw new DispatchFilterConfigException("过滤器类名称不能为空");
        }
        if (dispatchFilterSaveDTO.getCode() == null) {
            throw new DispatchFilterConfigException("过滤器code不能为空");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getVersion())) {
            throw new DispatchFilterConfigException("版本号不能为空");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getDescription())) {
            throw new DispatchFilterConfigException("描述不能为空");
        }
        if (StringUtils.isBlank(dispatchFilterSaveDTO.getUsageScenario())) {
            throw new DispatchFilterConfigException("使用场景描述不能为空");
        }
        
    }
    
}
