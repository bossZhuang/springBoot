package com.rivergame.fvgm.dao.farmaccounts;

import com.rivergame.fvgm.model.PlayerResource;
import com.rivergame.fvgm.model.PlayerResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerResourceMapper {
    int countByExample(PlayerResourceExample example);

    int deleteByExample(PlayerResourceExample example);

    int deleteByPrimaryKey(String uid);

    int insert(PlayerResource record);

    int insertSelective(PlayerResource record);

    List<PlayerResource> selectByExample(PlayerResourceExample example);

    PlayerResource selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") PlayerResource record, @Param("example") PlayerResourceExample example);

    int updateByExample(@Param("record") PlayerResource record, @Param("example") PlayerResourceExample example);

    int updateByPrimaryKeySelective(PlayerResource record);

    int updateByPrimaryKey(PlayerResource record);
}