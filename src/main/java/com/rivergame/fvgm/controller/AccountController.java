package com.rivergame.fvgm.controller;

import com.rivergame.fvgm.model.Account;
import com.rivergame.fvgm.model.AuthUser;
import com.rivergame.fvgm.service.IAccountService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/login")
    public String login(AuthUser account, Model model, HttpSession session){
        logger.info("account:{}",account.toString());
        AuthUser authUser = accountService.login(account);
        if (authUser == null){
            model.addAttribute("account",null);
            session.setAttribute("account",null);
            return "login";
        }
        model.addAttribute("account",account);
        session.setAttribute("account",authUser);
        return "home";
    }

    @RequestMapping("/addManager")
    public String addManager(AuthUser authUser, Model model){
        logger.info("authUser:{}",authUser.toString());
        accountService.insertManager(authUser);
        List<AuthUser> authUserList = accountService.getAuthUserList();
        model.addAttribute("authUserList",authUserList);
        return "manager";
    }

    @RequestMapping("/updateManager")
    public String updateManager(String id, Model model){
        model.addAttribute("authUser",accountService.selectById(id));
        return "updateManager";
    }

    @RequestMapping("/doUpdateManager")
    public String doUpdateManager(AuthUser authUser, Model model){
        logger.info("updateAuth:{}",authUser.toString());
        accountService.update(authUser);

        List<AuthUser> authUserList = accountService.getAuthUserList();
        model.addAttribute("authUserList",authUserList);
        return "manager";
    }

    @RequestMapping("/deleteManager")
    public String deleteManager(String id, Model model){
        logger.info("deleteManager-id:{}",id);
        accountService.deleteById(id);

        List<AuthUser> authUserList = accountService.getAuthUserList();
        model.addAttribute("authUserList",authUserList);
        return "manager";
    }
}
