package com.example.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.api.domain.DispatchFilterBaseDTO;
import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.domain.DispatchFilterUpdateDTO;
import com.example.api.domain.result.DispatchFilterResultDTO;
import com.example.mapper.entity.DispatchFilterConfig;

import java.util.Date;
import java.util.List;

import static com.example.mapper.entity.DispatchFilterConfig.Column.parameterKeys;

/**
 * Description
 * Author ayt  on
 */
public class CoverUtils {
    public static DispatchFilterResultDTO convert2DispatchFilterResultDTO(DispatchFilterConfig dispatchFilterConfig) {
        DispatchFilterResultDTO dispatchFilterResultDTO = new DispatchFilterResultDTO();
        dispatchFilterResultDTO.setId(dispatchFilterConfig.getId());
        dispatchFilterResultDTO.setClassName(dispatchFilterConfig.getClassName());
        dispatchFilterResultDTO.setCode(dispatchFilterConfig.getCode());
        dispatchFilterResultDTO.setDescription(dispatchFilterConfig.getDescription());
        dispatchFilterResultDTO.setName(dispatchFilterResultDTO.getName());
        dispatchFilterResultDTO.setSort(dispatchFilterConfig.getSort());
        dispatchFilterResultDTO.setVersion(dispatchFilterConfig.getVersion());
        dispatchFilterResultDTO.setUsageScenario(dispatchFilterConfig.getUsageScenario());
        dispatchFilterResultDTO.setParameterKeys(JSONObject.parseArray(dispatchFilterConfig.getParameterKeys(), String.class));
        return dispatchFilterResultDTO;
    }


    public static DispatchFilterConfig conver2DispatchFilterConfig(DispatchFilterBaseDTO dispatchFilterBaseDTO) {
        String staffCode = null;
        List<String> parameterKeys = null;
        DispatchFilterConfig dispatchFilterConfig = new DispatchFilterConfig();
        if(dispatchFilterBaseDTO instanceof DispatchFilterUpdateDTO){
            DispatchFilterUpdateDTO dto = (DispatchFilterUpdateDTO) dispatchFilterBaseDTO;
            dispatchFilterConfig.setId(dto.getId());
            staffCode = dto.getStaffCode();
            parameterKeys = dto.getParameterKeys();
        }
        if(dispatchFilterBaseDTO instanceof DispatchFilterSaveDTO){
            DispatchFilterSaveDTO dto = (DispatchFilterSaveDTO) dispatchFilterBaseDTO;
            dispatchFilterConfig.setCreator(dto.getStaffCode());
            dispatchFilterConfig.setClassName(dto.getClassName());
            staffCode = dto.getStaffCode();
            parameterKeys = dto.getParameterKeys();
        }

        dispatchFilterConfig.setCode(dispatchFilterBaseDTO.getCode());
        dispatchFilterConfig.setModifier(staffCode);
        dispatchFilterConfig.setDescription(dispatchFilterBaseDTO.getDescription());
        dispatchFilterConfig.setIsActive(true);
        dispatchFilterConfig.setParameterKeys(JSONObject.toJSONString(parameterKeys));
        dispatchFilterConfig.setSort(dispatchFilterBaseDTO.getSort());
        dispatchFilterConfig.setName(dispatchFilterBaseDTO.getName());
        dispatchFilterConfig.setUsageScenario(dispatchFilterBaseDTO.getUsageScenario());

        return  dispatchFilterConfig;

    }
}
