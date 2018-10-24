package com.rivergame.fvgm.model;

public class PlayerAnimal {
    private String uuid;

    private String uid;

    private String animalid;

    private Integer createtime;

    private String position;

    private Integer lastfeedtime;

    private Integer growstep;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getAnimalid() {
        return animalid;
    }

    public void setAnimalid(String animalid) {
        this.animalid = animalid == null ? null : animalid.trim();
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getLastfeedtime() {
        return lastfeedtime;
    }

    public void setLastfeedtime(Integer lastfeedtime) {
        this.lastfeedtime = lastfeedtime;
    }

    public Integer getGrowstep() {
        return growstep;
    }

    public void setGrowstep(Integer growstep) {
        this.growstep = growstep;
    }
}