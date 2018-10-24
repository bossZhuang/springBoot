package com.rivergame.fvgm.controller;

import com.rivergame.fvgm.model.PlayerInfo;
import com.rivergame.fvgm.model.vo.AdminPageVo;
import com.rivergame.fvgm.service.IGameService;
import com.rivergame.fvgm.service.impl.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {
    private Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private IGameService gameService;

    @RequestMapping("/getPlayerInfoList")
    public String getPlayerInfoList(AdminPageVo pageVo, Model model, String curPage, String queryId, String queryName){

        if (curPage != null){
            pageVo.setCurPage(Integer.parseInt(curPage));
        }
        if (queryId != null && !"".equals(queryId)){
            pageVo.addQueryPram("queryId",queryId);
        }
        if (queryName != null && !"".equals(queryName)){
            pageVo.addQueryPram("queryName",queryName);
        }
        if ((queryId != null && !"".equals(queryId))||(queryName != null && !"".equals(queryName))){
            pageVo = gameService.selectListPage(pageVo);
            model.addAttribute("page",pageVo);
        }
        return "playerInfo";
    }

    @RequestMapping("/getPlayerDetailInfoById")
    public String getPlayerInfoById(String uid, Model model, HttpSession session){
        HashMap<String,Object> dataMap = gameService.getDetailInfoByPlayerId(uid);

        model.addAttribute("uid",uid);

        model.addAttribute("resource",dataMap.get("resource"));
        model.addAttribute("buildings",dataMap.get("building"));
        model.addAttribute("crops",dataMap.get("crop"));
        model.addAttribute("items",dataMap.get("item"));
        model.addAttribute("animals",dataMap.get("animal"));

        return "playerDetailInfo";
    }

    @RequestMapping("/getPlayerLoginHistory")
    public String getPlayerLoginHistory(AdminPageVo pageVo,String startTime, String endTime, String queryId, Model model){
        logger.info("Time:{},{}",startTime, endTime);
        if ((startTime != null && !"".equals(startTime)) && (endTime != null && !"".equals(endTime))&& (queryId != null && !"".equals(queryId))){
            pageVo.addQueryPram("startTime",startTime);
            pageVo.addQueryPram("endTime",endTime);
            pageVo.addQueryPram("queryId",queryId);
            pageVo = gameService.selectLoginHistoryPage(pageVo);
            model.addAttribute("page", pageVo);
        }
        return "playerLoginHistory";
    }

    @RequestMapping("/getPlayerOrder")
    public String getPlayerOrder(AdminPageVo pageVo, String queryId, Model model){
        if (queryId != null && !"".equals(queryId)){
            pageVo.addQueryPram("queryId",queryId);
            model.addAttribute("page",gameService.selectPayOrderPage(pageVo));
        }
        return "playerOrder";
    }
}
