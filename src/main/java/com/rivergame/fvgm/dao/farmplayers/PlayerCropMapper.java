package com.rivergame.fvgm.dao.farmplayers;


import com.rivergame.fvgm.model.PlayerCrop;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface PlayerCropMapper {

    List<PlayerCrop> selectListByQueryParams(AdminPageVo pageVo);
}