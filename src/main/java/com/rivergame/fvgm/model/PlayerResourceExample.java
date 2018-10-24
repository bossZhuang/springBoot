package com.rivergame.fvgm.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayerResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andFeedIsNull() {
            addCriterion("feed is null");
            return (Criteria) this;
        }

        public Criteria andFeedIsNotNull() {
            addCriterion("feed is not null");
            return (Criteria) this;
        }

        public Criteria andFeedEqualTo(Integer value) {
            addCriterion("feed =", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedNotEqualTo(Integer value) {
            addCriterion("feed <>", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedGreaterThan(Integer value) {
            addCriterion("feed >", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("feed >=", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedLessThan(Integer value) {
            addCriterion("feed <", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedLessThanOrEqualTo(Integer value) {
            addCriterion("feed <=", value, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedIn(List<Integer> values) {
            addCriterion("feed in", values, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedNotIn(List<Integer> values) {
            addCriterion("feed not in", values, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedBetween(Integer value1, Integer value2) {
            addCriterion("feed between", value1, value2, "feed");
            return (Criteria) this;
        }

        public Criteria andFeedNotBetween(Integer value1, Integer value2) {
            addCriterion("feed not between", value1, value2, "feed");
            return (Criteria) this;
        }

        public Criteria andFertilizerIsNull() {
            addCriterion("fertilizer is null");
            return (Criteria) this;
        }

        public Criteria andFertilizerIsNotNull() {
            addCriterion("fertilizer is not null");
            return (Criteria) this;
        }

        public Criteria andFertilizerEqualTo(Integer value) {
            addCriterion("fertilizer =", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerNotEqualTo(Integer value) {
            addCriterion("fertilizer <>", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerGreaterThan(Integer value) {
            addCriterion("fertilizer >", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerGreaterThanOrEqualTo(Integer value) {
            addCriterion("fertilizer >=", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerLessThan(Integer value) {
            addCriterion("fertilizer <", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerLessThanOrEqualTo(Integer value) {
            addCriterion("fertilizer <=", value, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerIn(List<Integer> values) {
            addCriterion("fertilizer in", values, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerNotIn(List<Integer> values) {
            addCriterion("fertilizer not in", values, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerBetween(Integer value1, Integer value2) {
            addCriterion("fertilizer between", value1, value2, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andFertilizerNotBetween(Integer value1, Integer value2) {
            addCriterion("fertilizer not between", value1, value2, "fertilizer");
            return (Criteria) this;
        }

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(Integer value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(Integer value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(Integer value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(Integer value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(Integer value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<Integer> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<Integer> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(Integer value1, Integer value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(Integer value1, Integer value2) {
            addCriterion("water not between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andMaxwaterIsNull() {
            addCriterion("maxWater is null");
            return (Criteria) this;
        }

        public Criteria andMaxwaterIsNotNull() {
            addCriterion("maxWater is not null");
            return (Criteria) this;
        }

        public Criteria andMaxwaterEqualTo(Integer value) {
            addCriterion("maxWater =", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterNotEqualTo(Integer value) {
            addCriterion("maxWater <>", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterGreaterThan(Integer value) {
            addCriterion("maxWater >", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxWater >=", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterLessThan(Integer value) {
            addCriterion("maxWater <", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterLessThanOrEqualTo(Integer value) {
            addCriterion("maxWater <=", value, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterIn(List<Integer> values) {
            addCriterion("maxWater in", values, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterNotIn(List<Integer> values) {
            addCriterion("maxWater not in", values, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterBetween(Integer value1, Integer value2) {
            addCriterion("maxWater between", value1, value2, "maxwater");
            return (Criteria) this;
        }

        public Criteria andMaxwaterNotBetween(Integer value1, Integer value2) {
            addCriterion("maxWater not between", value1, value2, "maxwater");
            return (Criteria) this;
        }

        public Criteria andFireIsNull() {
            addCriterion("fire is null");
            return (Criteria) this;
        }

        public Criteria andFireIsNotNull() {
            addCriterion("fire is not null");
            return (Criteria) this;
        }

        public Criteria andFireEqualTo(Integer value) {
            addCriterion("fire =", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotEqualTo(Integer value) {
            addCriterion("fire <>", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireGreaterThan(Integer value) {
            addCriterion("fire >", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireGreaterThanOrEqualTo(Integer value) {
            addCriterion("fire >=", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireLessThan(Integer value) {
            addCriterion("fire <", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireLessThanOrEqualTo(Integer value) {
            addCriterion("fire <=", value, "fire");
            return (Criteria) this;
        }

        public Criteria andFireIn(List<Integer> values) {
            addCriterion("fire in", values, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotIn(List<Integer> values) {
            addCriterion("fire not in", values, "fire");
            return (Criteria) this;
        }

        public Criteria andFireBetween(Integer value1, Integer value2) {
            addCriterion("fire between", value1, value2, "fire");
            return (Criteria) this;
        }

        public Criteria andFireNotBetween(Integer value1, Integer value2) {
            addCriterion("fire not between", value1, value2, "fire");
            return (Criteria) this;
        }

        public Criteria andMaxfireIsNull() {
            addCriterion("maxFire is null");
            return (Criteria) this;
        }

        public Criteria andMaxfireIsNotNull() {
            addCriterion("maxFire is not null");
            return (Criteria) this;
        }

        public Criteria andMaxfireEqualTo(Integer value) {
            addCriterion("maxFire =", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireNotEqualTo(Integer value) {
            addCriterion("maxFire <>", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireGreaterThan(Integer value) {
            addCriterion("maxFire >", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxFire >=", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireLessThan(Integer value) {
            addCriterion("maxFire <", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireLessThanOrEqualTo(Integer value) {
            addCriterion("maxFire <=", value, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireIn(List<Integer> values) {
            addCriterion("maxFire in", values, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireNotIn(List<Integer> values) {
            addCriterion("maxFire not in", values, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireBetween(Integer value1, Integer value2) {
            addCriterion("maxFire between", value1, value2, "maxfire");
            return (Criteria) this;
        }

        public Criteria andMaxfireNotBetween(Integer value1, Integer value2) {
            addCriterion("maxFire not between", value1, value2, "maxfire");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeIsNull() {
            addCriterion("lastWaterTime is null");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeIsNotNull() {
            addCriterion("lastWaterTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeEqualTo(Integer value) {
            addCriterion("lastWaterTime =", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeNotEqualTo(Integer value) {
            addCriterion("lastWaterTime <>", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeGreaterThan(Integer value) {
            addCriterion("lastWaterTime >", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastWaterTime >=", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeLessThan(Integer value) {
            addCriterion("lastWaterTime <", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeLessThanOrEqualTo(Integer value) {
            addCriterion("lastWaterTime <=", value, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeIn(List<Integer> values) {
            addCriterion("lastWaterTime in", values, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeNotIn(List<Integer> values) {
            addCriterion("lastWaterTime not in", values, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeBetween(Integer value1, Integer value2) {
            addCriterion("lastWaterTime between", value1, value2, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastwatertimeNotBetween(Integer value1, Integer value2) {
            addCriterion("lastWaterTime not between", value1, value2, "lastwatertime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeIsNull() {
            addCriterion("lastFireTime is null");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeIsNotNull() {
            addCriterion("lastFireTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeEqualTo(Integer value) {
            addCriterion("lastFireTime =", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeNotEqualTo(Integer value) {
            addCriterion("lastFireTime <>", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeGreaterThan(Integer value) {
            addCriterion("lastFireTime >", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastFireTime >=", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeLessThan(Integer value) {
            addCriterion("lastFireTime <", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeLessThanOrEqualTo(Integer value) {
            addCriterion("lastFireTime <=", value, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeIn(List<Integer> values) {
            addCriterion("lastFireTime in", values, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeNotIn(List<Integer> values) {
            addCriterion("lastFireTime not in", values, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeBetween(Integer value1, Integer value2) {
            addCriterion("lastFireTime between", value1, value2, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andLastfiretimeNotBetween(Integer value1, Integer value2) {
            addCriterion("lastFireTime not between", value1, value2, "lastfiretime");
            return (Criteria) this;
        }

        public Criteria andUnlockareasIsNull() {
            addCriterion("unlockAreas is null");
            return (Criteria) this;
        }

        public Criteria andUnlockareasIsNotNull() {
            addCriterion("unlockAreas is not null");
            return (Criteria) this;
        }

        public Criteria andUnlockareasEqualTo(String value) {
            addCriterion("unlockAreas =", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasNotEqualTo(String value) {
            addCriterion("unlockAreas <>", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasGreaterThan(String value) {
            addCriterion("unlockAreas >", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasGreaterThanOrEqualTo(String value) {
            addCriterion("unlockAreas >=", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasLessThan(String value) {
            addCriterion("unlockAreas <", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasLessThanOrEqualTo(String value) {
            addCriterion("unlockAreas <=", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasLike(String value) {
            addCriterion("unlockAreas like", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasNotLike(String value) {
            addCriterion("unlockAreas not like", value, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasIn(List<String> values) {
            addCriterion("unlockAreas in", values, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasNotIn(List<String> values) {
            addCriterion("unlockAreas not in", values, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasBetween(String value1, String value2) {
            addCriterion("unlockAreas between", value1, value2, "unlockareas");
            return (Criteria) this;
        }

        public Criteria andUnlockareasNotBetween(String value1, String value2) {
            addCriterion("unlockAreas not between", value1, value2, "unlockareas");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}