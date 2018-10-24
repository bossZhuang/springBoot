package com.rivergame.fvgm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.rivergame.fvgm.service.IApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("IApiService")
public class ApiServiceImpl implements IApiService {

    private Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    private final String secret = "L7jGUhsxt54Rs2gxz";

    @Value("${spring.profiles.active}")
    private String env;

    @Override
    public void addGold(String uid, String gold) {
    //url=http://farmvilleservertest.elexapp.com/admin/method?secret=L7jGUhsxt54Rs2gxz&method=player.addGold&uid=15357040421902830&num=100
        logger.info("env:{}",env);
        String urlHead = "http://farmvilleservertest.elexapp.com/admin/method";
        if ("online".equals(env)){
            urlHead = "http://diaochan.rivergame.net/admin/method";
        }
        String urlLast = urlHead +
                "?secret=" + secret +
                "&method=player.addGold&uid=" + uid +
                "&num=" + gold;
        logger.info("url:{}", urlLast);
        JSONObject ret = sendHttpUrl(urlLast).getJSONObject("ret");
        logger.info("nowGold:{}",ret.get("gold"));
    }

    @Override
    public void addMoney(String uid, String money) {
        String urlHead = "http://farmvilleservertest.elexapp.com/admin/method";
        if ("online".equals(env)){
            urlHead = "http://diaochan.rivergame.net/admin/method";
        }
        String urlLast = urlHead +
                "?secret=" + secret +
                "&method=player.addMoney&uid=" + uid +
                "&num=" + money;
        logger.info("url:{}", urlLast);
        JSONObject ret = sendHttpUrl(urlLast).getJSONObject("ret");
        logger.info("nowMoney:{}",ret.get("money"));
    }

    @Override
    public void reset(String uid) {
        String urlHead = "http://farmvilleservertest.elexapp.com/admin/method";
        if ("online".equals(env)){
            urlHead = "http://diaochan.rivergame.net/admin/method";
        }
        String urlLast = urlHead +
                "?secret=" + secret +
                "&method=player.reset&uid=" + uid;
        logger.info("url:{}", urlLast);
        JSONObject ret = sendHttpUrl(urlLast).getJSONObject("ret");
        logger.info("reset-ret:{}",ret);
    }

    public JSONObject sendHttpUrl(String url){
        RestTemplate restTemplate = new RestTemplate();
        String text = restTemplate.getForEntity(url, String.class).getBody();
        logger.info("text:{}", text);
        return JSONObject.parseObject(text);
    }


}
