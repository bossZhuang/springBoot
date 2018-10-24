package com.rivergame.fvgm.dao.farmplayers;


import com.rivergame.fvgm.model.PlayerAnimal;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface PlayerAnimalMapper {

    List<PlayerAnimal> selectListByQueryParams(AdminPageVo pageVo);
}