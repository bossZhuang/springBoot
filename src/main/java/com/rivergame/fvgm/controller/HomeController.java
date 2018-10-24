package com.rivergame.fvgm.controller;


import com.rivergame.fvgm.model.AuthUser;
import com.rivergame.fvgm.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("account");
        return "login";
    }

    @RequestMapping("/manager")
    public String manager(Model model){
        List<AuthUser> authUserList = accountService.getAuthUserList();
        model.addAttribute("authUserList",authUserList);
        return "manager";
    }
}
