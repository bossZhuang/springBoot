package com.rivergame.fvgm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantConfig {

    public static String profile;

    @Value("${spring.profiles.active}")
    public void setProfile(String profile){
        ConstantConfig.profile = profile;
    }

}
