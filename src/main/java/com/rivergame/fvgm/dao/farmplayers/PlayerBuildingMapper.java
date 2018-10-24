package com.rivergame.fvgm.dao.farmplayers;


import com.rivergame.fvgm.model.PlayerBuilding;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface PlayerBuildingMapper {

    List<PlayerBuilding> selectListByQueryParams(AdminPageVo pageVo);
}