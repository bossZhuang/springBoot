package com.rivergame.fvgm.service;

public interface IApiService {

    void addGold(String uid, String gold);

    void addMoney(String uid, String money);

    void reset(String uid);
}
