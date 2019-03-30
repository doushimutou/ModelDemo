package com.example.impl.manager;

import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.domain.DispatchFilterUpdateDTO;
import com.example.api.domain.param.DispatchFilterQueryDTO;
import com.example.impl.CoverUtils;
import com.example.mapper.entity.DispatchFilterConfig;
import com.example.mapper.entity.DispatchFilterConfigExample;
import com.example.mapper.entity.DispatchFilterConfigExample.Criteria;
import com.example.mapper.mappers.DispatchFilterConfigMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 * Author ayt  on
 */
@Component
public class DispatchFilterConfigManager {
    @Resource
    DispatchFilterConfigMapper dispatchFilterConfigMapper;

    public List<DispatchFilterConfig> queryByPage(DispatchFilterQueryDTO dispatchFilterQueryDTO){
        DispatchFilterConfigExample dispatchFilterConfigExample = new DispatchFilterConfigExample();
        Criteria criteria = dispatchFilterConfigExample.createCriteria();
        criteria.andNameEqualTo(dispatchFilterQueryDTO.getName());
        criteria.andClassNameEqualTo(dispatchFilterQueryDTO.getClassName());
        criteria.andIsActiveEqualTo(true);
        if(dispatchFilterQueryDTO.isPaging()){
            dispatchFilterConfigExample.page(dispatchFilterQueryDTO.getCurrentPage()-1,dispatchFilterQueryDTO.getPageSize());
        }
        if(null!=dispatchFilterQueryDTO.getOrderByClause()){
            dispatchFilterConfigExample.orderBy(dispatchFilterQueryDTO.getOrderByClause());
        }else{
            dispatchFilterConfigExample.orderBy(DispatchFilterConfig.Column.sort.asc(), DispatchFilterConfig.Column.id.desc());
        }
        return  dispatchFilterConfigMapper.selectByExample(dispatchFilterConfigExample);
    }

    public long count(DispatchFilterQueryDTO dispatchFilterQueryDTO) {
        DispatchFilterConfigExample dispatchFilterConfigExample = new DispatchFilterConfigExample();
        Criteria criteria = dispatchFilterConfigExample.createCriteria();
        criteria.andNameEqualTo(dispatchFilterQueryDTO.getName());
        criteria.andClassNameEqualTo(dispatchFilterQueryDTO.getClassName());
        criteria.andIsActiveEqualTo(true);

        return dispatchFilterConfigMapper.countByExample(dispatchFilterConfigExample);

    }

    public Boolean save(DispatchFilterSaveDTO dispatchFilterSaveDTO) {
        DispatchFilterConfig dispatchFilterConfig = CoverUtils.conver2DispatchFilterConfig(dispatchFilterSaveDTO);
        return dispatchFilterConfigMapper.insert(dispatchFilterConfig)>0;
    }

    public Boolean update(DispatchFilterUpdateDTO dispatchFilterUpdateDTO) {
        DispatchFilterConfig dispatchFilterConfig = CoverUtils.conver2DispatchFilterConfig(dispatchFilterUpdateDTO);
        DispatchFilterConfigExample dispatchFilterConfigExample = new DispatchFilterConfigExample();
        Criteria criteria= dispatchFilterConfigExample.createCriteria();
        criteria.andIdEqualTo(dispatchFilterUpdateDTO.getId());
        criteria.andIsActiveEqualTo(true);
        return dispatchFilterConfigMapper.updateByExampleSelective(dispatchFilterConfig,dispatchFilterConfigExample)>0;
    }

    public List<DispatchFilterConfig> queryAll() {
        DispatchFilterConfigExample dispatchFilterConfigExample = new DispatchFilterConfigExample();
        Criteria criteria = dispatchFilterConfigExample.createCriteria();
        criteria.andIsActiveEqualTo(true);

        return dispatchFilterConfigMapper.selectByExample(dispatchFilterConfigExample);
    }
}
