package com.rivergame.fvgm.dao.farmaccounts;

import com.rivergame.fvgm.model.PlayerInfo;
import com.rivergame.fvgm.model.PlayerInfoExample;
import com.rivergame.fvgm.model.vo.AdminPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerInfoMapper {
    int countByExample(PlayerInfoExample example);

    int deleteByExample(PlayerInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(PlayerInfo record);

    int insertSelective(PlayerInfo record);

    List<PlayerInfo> selectByExample(PlayerInfoExample example);

    PlayerInfo selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") PlayerInfo record, @Param("example") PlayerInfoExample example);

    int updateByExample(@Param("record") PlayerInfo record, @Param("example") PlayerInfoExample example);

    int updateByPrimaryKeySelective(PlayerInfo record);

    int updateByPrimaryKey(PlayerInfo record);

    //自己写的函数
    List<PlayerInfo> selectListPage(AdminPageVo pageVo);

    int selectCountNum(AdminPageVo pageVo);
}