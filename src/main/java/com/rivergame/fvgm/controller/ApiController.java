package com.rivergame.fvgm.controller;

import com.rivergame.fvgm.model.vo.AdminPageVo;
import com.rivergame.fvgm.service.IApiService;
import com.rivergame.fvgm.service.IGameService;
import com.rivergame.fvgm.service.impl.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private IGameService gameService;
    @Autowired
    private IApiService apiService;

    @RequestMapping("/addGold")
    public String addGold(AdminPageVo pageVo, Model model, String uid, String gold){

        logger.info("加金币-info:{},{}",uid,gold);
        apiService.addGold(uid, gold);
        if (uid != null && !"".equals(uid)){
            pageVo.addQueryPram("queryId",uid);
        }
        pageVo = gameService.selectListPage(pageVo);
        model.addAttribute("page",pageVo);
        return "playerInfo";
    }

    @RequestMapping("/addMoney")
    public String addMoney(AdminPageVo pageVo, Model model, String uid, String money){

        logger.info("加农币-info:{},{}", uid, money);
        apiService.addMoney(uid, money);
        if (uid != null && !"".equals(uid)){
            pageVo.addQueryPram("queryId",uid);
        }
        pageVo = gameService.selectListPage(pageVo);
        model.addAttribute("page",pageVo);
        return "playerInfo";
    }

    @RequestMapping("/reset")
    public String reset(String uid){
        logger.info("删除账号-info:{}", uid);
        apiService.reset(uid);
        return "playerInfo";
    }
}
