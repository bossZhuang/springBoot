package com.rivergame.fvgm.dao.farmtime;


import com.rivergame.fvgm.model.PayOrder;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface PayOrderMapper {
    List<PayOrder> selectListByQueryParams(AdminPageVo pageVo);

    int selectCountNum(AdminPageVo pageVo);
}