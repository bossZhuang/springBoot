package com.rivergame.fvgm.service;

import com.rivergame.fvgm.model.AuthUser;

import java.util.List;

public interface IAccountService {

    AuthUser login(AuthUser authUser);

    void insertManager(AuthUser authUser);

    List<AuthUser> getAuthUserList();

    AuthUser selectById(String id);

    void update(AuthUser authUser);

    void deleteById(String id);
}
