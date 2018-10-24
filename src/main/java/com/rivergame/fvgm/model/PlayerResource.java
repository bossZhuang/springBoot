package com.rivergame.fvgm.model;

public class PlayerResource {
    private String uid;

    private Integer feed;

    private Integer fertilizer;

    private Integer water;

    private Integer maxwater;

    private Integer fire;

    private Integer maxfire;

    private Integer lastwatertime;

    private Integer lastfiretime;

    private String unlockareas;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getFeed() {
        return feed;
    }

    public void setFeed(Integer feed) {
        this.feed = feed;
    }

    public Integer getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(Integer fertilizer) {
        this.fertilizer = fertilizer;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getMaxwater() {
        return maxwater;
    }

    public void setMaxwater(Integer maxwater) {
        this.maxwater = maxwater;
    }

    public Integer getFire() {
        return fire;
    }

    public void setFire(Integer fire) {
        this.fire = fire;
    }

    public Integer getMaxfire() {
        return maxfire;
    }

    public void setMaxfire(Integer maxfire) {
        this.maxfire = maxfire;
    }

    public Integer getLastwatertime() {
        return lastwatertime;
    }

    public void setLastwatertime(Integer lastwatertime) {
        this.lastwatertime = lastwatertime;
    }

    public Integer getLastfiretime() {
        return lastfiretime;
    }

    public void setLastfiretime(Integer lastfiretime) {
        this.lastfiretime = lastfiretime;
    }

    public String getUnlockareas() {
        return unlockareas;
    }

    public void setUnlockareas(String unlockareas) {
        this.unlockareas = unlockareas == null ? null : unlockareas.trim();
    }
}