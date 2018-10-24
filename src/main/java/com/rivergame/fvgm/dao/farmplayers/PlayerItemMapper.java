package com.rivergame.fvgm.dao.farmplayers;


import com.rivergame.fvgm.model.PlayerItem;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface PlayerItemMapper {

    List<PlayerItem> selectListByQueryParams(AdminPageVo pageVo);
}