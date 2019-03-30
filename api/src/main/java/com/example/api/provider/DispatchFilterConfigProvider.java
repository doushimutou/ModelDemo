package com.example.api.provider;


import com.dianwoba.wireless.paging.Pagination;
import com.example.api.domain.DispatchFilterSaveDTO;
import com.example.api.domain.DispatchFilterUpdateDTO;
import com.example.api.domain.param.DispatchFilterQueryDTO;
import com.example.api.domain.result.DispatchFilterResultDTO;

import java.util.List;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public interface DispatchFilterConfigProvider {
    /**
     * 查询接口
     * @param dispatchFilterQueryDTO
     * @return
     */
    Pagination<DispatchFilterResultDTO> queryPage(DispatchFilterQueryDTO dispatchFilterQueryDTO);

    /**
     * 添加接口
     * @param dispatchFilterSaveDTO
     * @return
     */
    Boolean save (DispatchFilterSaveDTO dispatchFilterSaveDTO);

    /**
     * 更新接口
     * @param dispatchFilterUpdateDTO
     * @return
     */
    Boolean update(DispatchFilterUpdateDTO dispatchFilterUpdateDTO);

    /**
     * 查询所有过滤器
     * @return
     */
    List<DispatchFilterResultDTO> queryAll();



}
