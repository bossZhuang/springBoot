package com.rivergame.fvgm.service.impl;

import com.rivergame.fvgm.dao.farmaccounts.PlayerInfoMapper;
import com.rivergame.fvgm.dao.farmaccounts.PlayerResourceMapper;
import com.rivergame.fvgm.dao.farmbigdata.UserLoginMapper;
import com.rivergame.fvgm.dao.farmplayers.PlayerAnimalMapper;
import com.rivergame.fvgm.dao.farmplayers.PlayerBuildingMapper;
import com.rivergame.fvgm.dao.farmplayers.PlayerCropMapper;
import com.rivergame.fvgm.dao.farmplayers.PlayerItemMapper;
import com.rivergame.fvgm.dao.farmtime.PayOrderMapper;
import com.rivergame.fvgm.model.*;
import com.rivergame.fvgm.model.vo.AdminPageVo;
import com.rivergame.fvgm.service.IGameService;
import com.rivergame.fvgm.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CRC32;

@Service("IGameService")
public class GameServiceImpl implements IGameService {

    private Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    @Resource
    private PlayerInfoMapper playerInfoMapper;
    @Resource
    private PlayerResourceMapper playerResourceMapper;
    @Resource
    private PlayerBuildingMapper playerBuildingMapper;
    @Resource
    private PlayerItemMapper playerItemMapper;
    @Resource
    private PlayerCropMapper playerCropMapper;
    @Resource
    private PlayerAnimalMapper playerAnimalMapper;
    @Resource
    private PayOrderMapper payOrderMapper;
    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public List<PlayerInfo> selectList() {
        PlayerInfoExample example = new PlayerInfoExample();
        List<PlayerInfo> playerInfoList = playerInfoMapper.selectByExample(example);
        return playerInfoList;
    }

    @Override
    public AdminPageVo selectListPage(AdminPageVo pageVo) {
        pageVo.setList(playerInfoMapper.selectListPage(pageVo));

        pageVo.setCount((long)playerInfoMapper.selectCountNum(pageVo));
        return pageVo;
    }

    @Override
    public HashMap<String,Object> getDetailInfoByPlayerId(String uid) {

        //拿到玩家资源数据
        PlayerResource playerResource = getPlayerResourceById(uid);

        int tableId = getTableIdByUid(uid);
        //分表拿
        AdminPageVo pageVo = new AdminPageVo();
        pageVo.addQueryPram("tableId",tableId);
        pageVo.addQueryPram("queryId",uid);

        List<PlayerBuilding> playerBuildingList = new ArrayList<>();
        List<PlayerCrop> playerCropList = new ArrayList<>();
        List<PlayerItem> playerItemList = new ArrayList<>();
        List<PlayerAnimal> playerAnimalList = new ArrayList<>();
        try {
            // -玩家建筑
            playerBuildingList = getPlayerBuildingByQueryParams(pageVo);
            // -玩家作物
            playerCropList = getPlayerCropByQueryParams(pageVo);
            // -玩家物品
            playerItemList = getPlayerItemByQueryParams(pageVo);
            // -玩家动物
            playerAnimalList = getPlayerAnimalByQueryParams(pageVo);
        }catch (Exception e){
            logger.error("", e);
        }
        HashMap<String,Object> dataMap = new HashMap<>();
        dataMap.put("resource",playerResource);
        dataMap.put("building",playerBuildingList);
        dataMap.put("crop",playerCropList);
        dataMap.put("item",playerItemList);
        dataMap.put("animal",playerAnimalList);
        return dataMap;
    }

    private List<PlayerAnimal> getPlayerAnimalByQueryParams(AdminPageVo pageVo) {
        return playerAnimalMapper.selectListByQueryParams(pageVo);
    }

    private List<PlayerItem> getPlayerItemByQueryParams(AdminPageVo pageVo) {
        return playerItemMapper.selectListByQueryParams(pageVo);
    }

    private List<PlayerCrop> getPlayerCropByQueryParams(AdminPageVo pageVo) {
        return playerCropMapper.selectListByQueryParams(pageVo);
    }

    private List<PlayerBuilding> getPlayerBuildingByQueryParams(AdminPageVo pageVo) {
        return playerBuildingMapper.selectListByQueryParams(pageVo);
    }

    @Override
    public PlayerResource getPlayerResourceById(String uid) {
        return playerResourceMapper.selectByPrimaryKey(uid);
    }

    @Override
    public AdminPageVo selectPayOrderPage(AdminPageVo pageVo) {
        pageVo.setList(payOrderMapper.selectListByQueryParams(pageVo));

        pageVo.setCount((long)payOrderMapper.selectCountNum(pageVo));
        return pageVo;
    }

    @Override
    public AdminPageVo selectLoginHistoryPage(AdminPageVo pageVo) {
        //将日期进行换算
        String startTime = (String) pageVo.getQueryParam().get("startTime");
        String endTime = (String) pageVo.getQueryParam().get("endTime");
        //将字符串转换成date的long类型
        long startLong = DateUtils.string2Date(startTime).getTime();
        long endLong = DateUtils.string2Date(endTime).getTime();
        logger.info("long:{},{}", startLong, endLong);

        String start = startTime.replaceFirst("-","").split("-")[0];
        String end = endTime.replaceFirst("-","").split("-")[0];
        //更具查找的时间寻找要查的表
        logger.info("start:{}",start);
        logger.info("end:{}",end);

        List<UserLogin> userLoginList = new ArrayList<>();
        int totalDataNum = 0;
        pageVo.addQueryPram("startLong", startLong);
        pageVo.addQueryPram("endLong", endLong);
        if (!start.equals(end)){
            logger.info("不相等");
            int startInt = Integer.parseInt(start);
            int endInt = Integer.parseInt(end);
            for(int tableId = startInt; tableId <= endInt; tableId++){
                logger.info("for-tableId:{}",tableId);
                pageVo.addQueryPram("tableId", tableId);
                try {
                    userLoginList.addAll(userLoginMapper.selectListByQueryParams(pageVo));
                    totalDataNum = totalDataNum + userLoginMapper.selectCountNum(pageVo);
                }catch (Exception e){
                    logger.error("", e);
                }
                if (tableId%100 == 12){
                    logger.info("head:{}", tableId/100);
                    int head = tableId/100 + 1;
                    tableId = head * 100;
                }
            }
        }else {
            logger.info("相等");
            pageVo.addQueryPram("tableId", Integer.parseInt(start));
            logger.info("tableId:{}", start);
            pageVo.addQueryPram("startLong", startLong);
            pageVo.addQueryPram("endLong", endLong);
            userLoginList.addAll(userLoginMapper.selectListByQueryParams(pageVo));
            totalDataNum = userLoginMapper.selectCountNum(pageVo);
        }
        pageVo.setList(userLoginList);
        logger.info("count:{}",totalDataNum);
        pageVo.setCount((long)totalDataNum);
        return pageVo;
    }

    public int getTableIdByUid(String uid){
        CRC32 crc32 = new CRC32();
        crc32.update(uid.getBytes());
        long tableId = crc32.getValue()%100;
        logger.info("crc32:{}",tableId);
        return (int) tableId;
    }
}
