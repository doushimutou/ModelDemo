package com.example.impl.provider;

import com.dianwoba.wireless.paging.Pagination;
import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.domain.DispatchFilterUpdateDTO;
import com.example.api.domain.param.DispatchFilterQueryDTO;
import com.example.api.domain.result.DispatchFilterResultDTO;
import com.example.api.provider.DispatchFilterConfigProvider;
import com.example.impl.ValidationUtil;
import com.example.impl.service.DispatchFilterConfigService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * @Author ayt  on
 */
@Component
public class DispatchFilterProviderConfigImpl implements DispatchFilterConfigProvider {
    @Resource
    DispatchFilterConfigService dispatchFilterConfigService;
    @Override
    public Pagination<DispatchFilterResultDTO> queryPage(DispatchFilterQueryDTO dispatchFilterQueryDTO) {

       return dispatchFilterConfigService.queryByPage(dispatchFilterQueryDTO);

    }

    @Override
    public Boolean save(DispatchFilterSaveDTO dispatchFilterSaveDTO) {
        ValidationUtil.validate(dispatchFilterSaveDTO);
        return dispatchFilterConfigService.save(dispatchFilterSaveDTO);
    }

    @Override
    public Boolean update(DispatchFilterUpdateDTO dispatchFilterUpdateDTO) {

        return dispatchFilterConfigService.update(dispatchFilterUpdateDTO);
    }

    @Override
    public List<DispatchFilterResultDTO> queryAll() {

        return dispatchFilterConfigService.queryAll();
    }

}
