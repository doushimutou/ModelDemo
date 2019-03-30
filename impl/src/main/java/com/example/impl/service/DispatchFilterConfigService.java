package com.example.impl.service;

import com.dianwoba.wireless.paging.Pagination;
import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.domain.DispatchFilterUpdateDTO;
import com.example.api.domain.param.DispatchFilterQueryDTO;
import com.example.api.domain.result.DispatchFilterResultDTO;
import com.example.impl.CoverUtils;
import com.example.impl.manager.DispatchFilterConfigManager;
import com.example.mapper.entity.DispatchFilterConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Component
public class DispatchFilterConfigService {
    @Resource
    DispatchFilterConfigManager dispatchFilterConfigManager;

    public Pagination<DispatchFilterResultDTO> queryByPage(DispatchFilterQueryDTO dispatchFilterQueryDTO) {

        Pagination pagination = new Pagination<>();
        pagination.setCurrentPage(dispatchFilterQueryDTO.getCurrentPage());
        pagination.setPageSize(dispatchFilterQueryDTO.getPageSize());
        pagination.setTotalCount(dispatchFilterConfigManager.count(dispatchFilterQueryDTO));

        List<DispatchFilterConfig> dispatchFilterConfigs = dispatchFilterConfigManager.queryByPage(dispatchFilterQueryDTO);
        List<DispatchFilterResultDTO> dispatchFilterResultDTOS = new ArrayList<>();
        dispatchFilterConfigs.forEach(dispatchFilterConfig ->
                dispatchFilterResultDTOS.add(CoverUtils.convert2DispatchFilterResultDTO(dispatchFilterConfig)));

        pagination.setList(dispatchFilterResultDTOS);

        return pagination;
    }

    public Boolean save(DispatchFilterSaveDTO dispatchFilterSaveDTO) {

       return dispatchFilterConfigManager.save(dispatchFilterSaveDTO);
    }

    public Boolean update(DispatchFilterUpdateDTO dispatchFilterUpdateDTO) {
        return dispatchFilterConfigManager.update(dispatchFilterUpdateDTO);
    }

    public List<DispatchFilterResultDTO> queryAll() {
        List<DispatchFilterResultDTO> dispatchFilterResultDTOS = new ArrayList<>();
        List<DispatchFilterConfig> dispatchFilterConfigList =  dispatchFilterConfigManager.queryAll();
        dispatchFilterConfigList.forEach( dispatchFilterConfig ->
                dispatchFilterResultDTOS.add(CoverUtils.convert2DispatchFilterResultDTO(dispatchFilterConfig))
        );
        return dispatchFilterResultDTOS;
    }
}
