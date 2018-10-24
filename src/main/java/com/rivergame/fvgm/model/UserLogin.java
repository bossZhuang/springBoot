package com.rivergame.fvgm.model;

public class UserLogin {
    private String uid;

    private Byte serverid;

    private Long time;

    private Long disconnect;

    private String pf;

    private String country;

    private String ip;

    private String appversion;

    private String scenceid;

    private String adid;

    private String admaterial;

    private String brand;

    private String system;

    private String model;

    private String version;

    private String info;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Byte getServerid() {
        return serverid;
    }

    public void setServerid(Byte serverid) {
        this.serverid = serverid;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getDisconnect() {
        return disconnect;
    }

    public void setDisconnect(Long disconnect) {
        this.disconnect = disconnect;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf == null ? null : pf.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion == null ? null : appversion.trim();
    }

    public String getScenceid() {
        return scenceid;
    }

    public void setScenceid(String scenceid) {
        this.scenceid = scenceid == null ? null : scenceid.trim();
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid == null ? null : adid.trim();
    }

    public String getAdmaterial() {
        return admaterial;
    }

    public void setAdmaterial(String admaterial) {
        this.admaterial = admaterial == null ? null : admaterial.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}