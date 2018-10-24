package com.rivergame.fvgm.service.impl;

import com.rivergame.fvgm.dao.AuthUserMapper;
import com.rivergame.fvgm.model.AuthUser;
import com.rivergame.fvgm.model.AuthUserExample;
import com.rivergame.fvgm.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service("IAccountService")
public class AccountServiceImpl implements IAccountService {

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final String slat = "sdfsdfsdf8979ADSF";

    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUser login(AuthUser authUser) {
        AuthUserExample example = new AuthUserExample();
        example.createCriteria()
                .andNameEqualTo(authUser.getName())
                .andPwdEqualTo(getMD5(authUser.getPwd()));
        List<AuthUser> authUserList = authUserMapper.selectByExample(example);
        if (authUserList.size() == 0){
            logger.error("账户不存在!");
            return null;
        }
        return authUserList.get(0);
    }

    @Override
    public void insertManager(AuthUser authUser){
        authUser.setId(UUID.randomUUID().toString());
        logger.info("加密后:{}",getMD5(authUser.getPwd()));
        authUser.setPwd(getMD5(authUser.getPwd()));
        authUser.setCreateTime(System.currentTimeMillis());
        authUser.setUpdateTime(System.currentTimeMillis());
        int num = authUserMapper.insert(authUser);
        logger.info("num:{}",num);
    }

    @Override
    public List<AuthUser> getAuthUserList() {
        AuthUserExample example = new AuthUserExample();
        List<AuthUser> authUserList = authUserMapper.selectByExample(example);

//        int num = testMapper.count();
//        logger.info("num:{}",num);
        return authUserList;
    }

    @Override
    public AuthUser selectById(String id) {
        return authUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(AuthUser authUser) {
        AuthUser authUserUpdate = authUserMapper.selectByPrimaryKey(authUser.getId());

        authUserUpdate.setName(authUser.getName());
        authUserUpdate.setPwd(getMD5(authUser.getPwd()));
        authUserUpdate.setUpdateTime(System.currentTimeMillis());

        int num = authUserMapper.updateByPrimaryKey(authUserUpdate);
    }

    @Override
    public void deleteById(String id) {
        int num = authUserMapper.deleteByPrimaryKey(id);
        logger.info("删除结果:{}",num);
    }

    private String getMD5(String passWord){
        String base = passWord + "/" +slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
