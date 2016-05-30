package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TAgentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TAgentInfoExample() {
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

        public Criteria andAgentpkIsNull() {
            addCriterion("agentpk is null");
            return (Criteria) this;
        }

        public Criteria andAgentpkIsNotNull() {
            addCriterion("agentpk is not null");
            return (Criteria) this;
        }

        public Criteria andAgentpkEqualTo(Integer value) {
            addCriterion("agentpk =", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkNotEqualTo(Integer value) {
            addCriterion("agentpk <>", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkGreaterThan(Integer value) {
            addCriterion("agentpk >", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("agentpk >=", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkLessThan(Integer value) {
            addCriterion("agentpk <", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkLessThanOrEqualTo(Integer value) {
            addCriterion("agentpk <=", value, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkIn(List<Integer> values) {
            addCriterion("agentpk in", values, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkNotIn(List<Integer> values) {
            addCriterion("agentpk not in", values, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkBetween(Integer value1, Integer value2) {
            addCriterion("agentpk between", value1, value2, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentpkNotBetween(Integer value1, Integer value2) {
            addCriterion("agentpk not between", value1, value2, "agentpk");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNull() {
            addCriterion("agentid is null");
            return (Criteria) this;
        }

        public Criteria andAgentidIsNotNull() {
            addCriterion("agentid is not null");
            return (Criteria) this;
        }

        public Criteria andAgentidEqualTo(String value) {
            addCriterion("agentid =", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotEqualTo(String value) {
            addCriterion("agentid <>", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThan(String value) {
            addCriterion("agentid >", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidGreaterThanOrEqualTo(String value) {
            addCriterion("agentid >=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThan(String value) {
            addCriterion("agentid <", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLessThanOrEqualTo(String value) {
            addCriterion("agentid <=", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidLike(String value) {
            addCriterion("agentid like", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotLike(String value) {
            addCriterion("agentid not like", value, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidIn(List<String> values) {
            addCriterion("agentid in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotIn(List<String> values) {
            addCriterion("agentid not in", values, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidBetween(String value1, String value2) {
            addCriterion("agentid between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentidNotBetween(String value1, String value2) {
            addCriterion("agentid not between", value1, value2, "agentid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridIsNull() {
            addCriterion("agentuserid is null");
            return (Criteria) this;
        }

        public Criteria andAgentuseridIsNotNull() {
            addCriterion("agentuserid is not null");
            return (Criteria) this;
        }

        public Criteria andAgentuseridEqualTo(String value) {
            addCriterion("agentuserid =", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridNotEqualTo(String value) {
            addCriterion("agentuserid <>", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridGreaterThan(String value) {
            addCriterion("agentuserid >", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridGreaterThanOrEqualTo(String value) {
            addCriterion("agentuserid >=", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridLessThan(String value) {
            addCriterion("agentuserid <", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridLessThanOrEqualTo(String value) {
            addCriterion("agentuserid <=", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridLike(String value) {
            addCriterion("agentuserid like", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridNotLike(String value) {
            addCriterion("agentuserid not like", value, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridIn(List<String> values) {
            addCriterion("agentuserid in", values, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridNotIn(List<String> values) {
            addCriterion("agentuserid not in", values, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridBetween(String value1, String value2) {
            addCriterion("agentuserid between", value1, value2, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentuseridNotBetween(String value1, String value2) {
            addCriterion("agentuserid not between", value1, value2, "agentuserid");
            return (Criteria) this;
        }

        public Criteria andAgentpersonIsNull() {
            addCriterion("agentperson is null");
            return (Criteria) this;
        }

        public Criteria andAgentpersonIsNotNull() {
            addCriterion("agentperson is not null");
            return (Criteria) this;
        }

        public Criteria andAgentpersonEqualTo(String value) {
            addCriterion("agentperson =", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonNotEqualTo(String value) {
            addCriterion("agentperson <>", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonGreaterThan(String value) {
            addCriterion("agentperson >", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonGreaterThanOrEqualTo(String value) {
            addCriterion("agentperson >=", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonLessThan(String value) {
            addCriterion("agentperson <", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonLessThanOrEqualTo(String value) {
            addCriterion("agentperson <=", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonLike(String value) {
            addCriterion("agentperson like", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonNotLike(String value) {
            addCriterion("agentperson not like", value, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonIn(List<String> values) {
            addCriterion("agentperson in", values, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonNotIn(List<String> values) {
            addCriterion("agentperson not in", values, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonBetween(String value1, String value2) {
            addCriterion("agentperson between", value1, value2, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentpersonNotBetween(String value1, String value2) {
            addCriterion("agentperson not between", value1, value2, "agentperson");
            return (Criteria) this;
        }

        public Criteria andAgentphoneIsNull() {
            addCriterion("agentphone is null");
            return (Criteria) this;
        }

        public Criteria andAgentphoneIsNotNull() {
            addCriterion("agentphone is not null");
            return (Criteria) this;
        }

        public Criteria andAgentphoneEqualTo(String value) {
            addCriterion("agentphone =", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotEqualTo(String value) {
            addCriterion("agentphone <>", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneGreaterThan(String value) {
            addCriterion("agentphone >", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneGreaterThanOrEqualTo(String value) {
            addCriterion("agentphone >=", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLessThan(String value) {
            addCriterion("agentphone <", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLessThanOrEqualTo(String value) {
            addCriterion("agentphone <=", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneLike(String value) {
            addCriterion("agentphone like", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotLike(String value) {
            addCriterion("agentphone not like", value, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneIn(List<String> values) {
            addCriterion("agentphone in", values, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotIn(List<String> values) {
            addCriterion("agentphone not in", values, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneBetween(String value1, String value2) {
            addCriterion("agentphone between", value1, value2, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentphoneNotBetween(String value1, String value2) {
            addCriterion("agentphone not between", value1, value2, "agentphone");
            return (Criteria) this;
        }

        public Criteria andAgentnameIsNull() {
            addCriterion("agentname is null");
            return (Criteria) this;
        }

        public Criteria andAgentnameIsNotNull() {
            addCriterion("agentname is not null");
            return (Criteria) this;
        }

        public Criteria andAgentnameEqualTo(String value) {
            addCriterion("agentname =", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotEqualTo(String value) {
            addCriterion("agentname <>", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameGreaterThan(String value) {
            addCriterion("agentname >", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameGreaterThanOrEqualTo(String value) {
            addCriterion("agentname >=", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLessThan(String value) {
            addCriterion("agentname <", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLessThanOrEqualTo(String value) {
            addCriterion("agentname <=", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameLike(String value) {
            addCriterion("agentname like", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotLike(String value) {
            addCriterion("agentname not like", value, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameIn(List<String> values) {
            addCriterion("agentname in", values, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotIn(List<String> values) {
            addCriterion("agentname not in", values, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameBetween(String value1, String value2) {
            addCriterion("agentname between", value1, value2, "agentname");
            return (Criteria) this;
        }

        public Criteria andAgentnameNotBetween(String value1, String value2) {
            addCriterion("agentname not between", value1, value2, "agentname");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andAgentstateIsNull() {
            addCriterion("agentstate is null");
            return (Criteria) this;
        }

        public Criteria andAgentstateIsNotNull() {
            addCriterion("agentstate is not null");
            return (Criteria) this;
        }

        public Criteria andAgentstateEqualTo(String value) {
            addCriterion("agentstate =", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateNotEqualTo(String value) {
            addCriterion("agentstate <>", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateGreaterThan(String value) {
            addCriterion("agentstate >", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateGreaterThanOrEqualTo(String value) {
            addCriterion("agentstate >=", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateLessThan(String value) {
            addCriterion("agentstate <", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateLessThanOrEqualTo(String value) {
            addCriterion("agentstate <=", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateLike(String value) {
            addCriterion("agentstate like", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateNotLike(String value) {
            addCriterion("agentstate not like", value, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateIn(List<String> values) {
            addCriterion("agentstate in", values, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateNotIn(List<String> values) {
            addCriterion("agentstate not in", values, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateBetween(String value1, String value2) {
            addCriterion("agentstate between", value1, value2, "agentstate");
            return (Criteria) this;
        }

        public Criteria andAgentstateNotBetween(String value1, String value2) {
            addCriterion("agentstate not between", value1, value2, "agentstate");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createuser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createuser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updatetime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updatetime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateuser not between", value1, value2, "updateuser");
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