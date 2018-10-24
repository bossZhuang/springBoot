package com.rivergame.fvgm.service;

import com.rivergame.fvgm.model.PayOrder;
import com.rivergame.fvgm.model.PlayerInfo;
import com.rivergame.fvgm.model.PlayerResource;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.HashMap;
import java.util.List;

public interface IGameService {
    List<PlayerInfo> selectList();
    //分页查找数据
    AdminPageVo selectListPage(AdminPageVo pageVo);

    HashMap<String,Object> getDetailInfoByPlayerId(String uid);

    PlayerResource getPlayerResourceById(String uid);

    AdminPageVo selectPayOrderPage(AdminPageVo pageVo);

    AdminPageVo selectLoginHistoryPage(AdminPageVo pageVo);
}
