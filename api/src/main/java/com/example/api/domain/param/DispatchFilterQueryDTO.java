package com.example.api.domain.param;

import com.dianwoba.wireless.paging.PagingSearchable;
import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * Description
 * Author ayt  on
 */
@Data
public class DispatchFilterQueryDTO  extends PagingSearchable  {

    private static final long serialVersionUID = 5559661591900072295L;
    @NotNull
    String name;
    @NotNull
    String className;

}
