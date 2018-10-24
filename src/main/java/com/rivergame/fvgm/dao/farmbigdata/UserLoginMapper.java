package com.rivergame.fvgm.dao.farmbigdata;


import com.rivergame.fvgm.model.UserLogin;
import com.rivergame.fvgm.model.vo.AdminPageVo;

import java.util.List;

public interface UserLoginMapper {
    List<UserLogin> selectListByQueryParams(AdminPageVo pageVo);

    int selectCountNum(AdminPageVo pageVo);
}