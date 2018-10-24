package com.rivergame.fvgm.model;

public class PlayerInfo {
    private String uid;

    private String name;

    private String avatar;

    private String version;

    private String country;

    private String lang;

    private Long bantime;

    private Long regtime;

    private Long lastlogintime;

    private Long lastlogouttime;

    private String ip;

    private Integer exp;

    private Integer level;

    private Integer gold;

    private Integer money;

    private String guide;

    private String inviter;

    private String info;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }

    public Long getBantime() {
        return bantime;
    }

    public void setBantime(Long bantime) {
        this.bantime = bantime;
    }

    public Long getRegtime() {
        return regtime;
    }

    public void setRegtime(Long regtime) {
        this.regtime = regtime;
    }

    public Long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Long getLastlogouttime() {
        return lastlogouttime;
    }

    public void setLastlogouttime(Long lastlogouttime) {
        this.lastlogouttime = lastlogouttime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide == null ? null : guide.trim();
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter == null ? null : inviter.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", version='" + version + '\'' +
                ", country='" + country + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}