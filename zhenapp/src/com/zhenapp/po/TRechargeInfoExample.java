package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TRechargeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRechargeInfoExample() {
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

        public Criteria andRechargepkIsNull() {
            addCriterion("rechargepk is null");
            return (Criteria) this;
        }

        public Criteria andRechargepkIsNotNull() {
            addCriterion("rechargepk is not null");
            return (Criteria) this;
        }

        public Criteria andRechargepkEqualTo(Integer value) {
            addCriterion("rechargepk =", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkNotEqualTo(Integer value) {
            addCriterion("rechargepk <>", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkGreaterThan(Integer value) {
            addCriterion("rechargepk >", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkGreaterThanOrEqualTo(Integer value) {
            addCriterion("rechargepk >=", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkLessThan(Integer value) {
            addCriterion("rechargepk <", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkLessThanOrEqualTo(Integer value) {
            addCriterion("rechargepk <=", value, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkIn(List<Integer> values) {
            addCriterion("rechargepk in", values, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkNotIn(List<Integer> values) {
            addCriterion("rechargepk not in", values, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkBetween(Integer value1, Integer value2) {
            addCriterion("rechargepk between", value1, value2, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargepkNotBetween(Integer value1, Integer value2) {
            addCriterion("rechargepk not between", value1, value2, "rechargepk");
            return (Criteria) this;
        }

        public Criteria andRechargeidIsNull() {
            addCriterion("rechargeid is null");
            return (Criteria) this;
        }

        public Criteria andRechargeidIsNotNull() {
            addCriterion("rechargeid is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeidEqualTo(String value) {
            addCriterion("rechargeid =", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotEqualTo(String value) {
            addCriterion("rechargeid <>", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidGreaterThan(String value) {
            addCriterion("rechargeid >", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidGreaterThanOrEqualTo(String value) {
            addCriterion("rechargeid >=", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidLessThan(String value) {
            addCriterion("rechargeid <", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidLessThanOrEqualTo(String value) {
            addCriterion("rechargeid <=", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidLike(String value) {
            addCriterion("rechargeid like", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotLike(String value) {
            addCriterion("rechargeid not like", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidIn(List<String> values) {
            addCriterion("rechargeid in", values, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotIn(List<String> values) {
            addCriterion("rechargeid not in", values, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidBetween(String value1, String value2) {
            addCriterion("rechargeid between", value1, value2, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotBetween(String value1, String value2) {
            addCriterion("rechargeid not between", value1, value2, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationIsNull() {
            addCriterion("rechargeverification is null");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationIsNotNull() {
            addCriterion("rechargeverification is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationEqualTo(String value) {
            addCriterion("rechargeverification =", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationNotEqualTo(String value) {
            addCriterion("rechargeverification <>", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationGreaterThan(String value) {
            addCriterion("rechargeverification >", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationGreaterThanOrEqualTo(String value) {
            addCriterion("rechargeverification >=", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationLessThan(String value) {
            addCriterion("rechargeverification <", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationLessThanOrEqualTo(String value) {
            addCriterion("rechargeverification <=", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationLike(String value) {
            addCriterion("rechargeverification like", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationNotLike(String value) {
            addCriterion("rechargeverification not like", value, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationIn(List<String> values) {
            addCriterion("rechargeverification in", values, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationNotIn(List<String> values) {
            addCriterion("rechargeverification not in", values, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationBetween(String value1, String value2) {
            addCriterion("rechargeverification between", value1, value2, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargeverificationNotBetween(String value1, String value2) {
            addCriterion("rechargeverification not between", value1, value2, "rechargeverification");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyIsNull() {
            addCriterion("rechargemoney is null");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyIsNotNull() {
            addCriterion("rechargemoney is not null");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyEqualTo(Integer value) {
            addCriterion("rechargemoney =", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyNotEqualTo(Integer value) {
            addCriterion("rechargemoney <>", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyGreaterThan(Integer value) {
            addCriterion("rechargemoney >", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("rechargemoney >=", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyLessThan(Integer value) {
            addCriterion("rechargemoney <", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyLessThanOrEqualTo(Integer value) {
            addCriterion("rechargemoney <=", value, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyIn(List<Integer> values) {
            addCriterion("rechargemoney in", values, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyNotIn(List<Integer> values) {
            addCriterion("rechargemoney not in", values, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyBetween(Integer value1, Integer value2) {
            addCriterion("rechargemoney between", value1, value2, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargemoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("rechargemoney not between", value1, value2, "rechargemoney");
            return (Criteria) this;
        }

        public Criteria andRechargepointsIsNull() {
            addCriterion("rechargepoints is null");
            return (Criteria) this;
        }

        public Criteria andRechargepointsIsNotNull() {
            addCriterion("rechargepoints is not null");
            return (Criteria) this;
        }

        public Criteria andRechargepointsEqualTo(Integer value) {
            addCriterion("rechargepoints =", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsNotEqualTo(Integer value) {
            addCriterion("rechargepoints <>", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsGreaterThan(Integer value) {
            addCriterion("rechargepoints >", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rechargepoints >=", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsLessThan(Integer value) {
            addCriterion("rechargepoints <", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsLessThanOrEqualTo(Integer value) {
            addCriterion("rechargepoints <=", value, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsIn(List<Integer> values) {
            addCriterion("rechargepoints in", values, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsNotIn(List<Integer> values) {
            addCriterion("rechargepoints not in", values, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsBetween(Integer value1, Integer value2) {
            addCriterion("rechargepoints between", value1, value2, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargepointsNotBetween(Integer value1, Integer value2) {
            addCriterion("rechargepoints not between", value1, value2, "rechargepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyIsNull() {
            addCriterion("rechargegivemoney is null");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyIsNotNull() {
            addCriterion("rechargegivemoney is not null");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyEqualTo(Integer value) {
            addCriterion("rechargegivemoney =", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyNotEqualTo(Integer value) {
            addCriterion("rechargegivemoney <>", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyGreaterThan(Integer value) {
            addCriterion("rechargegivemoney >", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("rechargegivemoney >=", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyLessThan(Integer value) {
            addCriterion("rechargegivemoney <", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyLessThanOrEqualTo(Integer value) {
            addCriterion("rechargegivemoney <=", value, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyIn(List<Integer> values) {
            addCriterion("rechargegivemoney in", values, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyNotIn(List<Integer> values) {
            addCriterion("rechargegivemoney not in", values, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyBetween(Integer value1, Integer value2) {
            addCriterion("rechargegivemoney between", value1, value2, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivemoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("rechargegivemoney not between", value1, value2, "rechargegivemoney");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsIsNull() {
            addCriterion("rechargegivepoints is null");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsIsNotNull() {
            addCriterion("rechargegivepoints is not null");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsEqualTo(Integer value) {
            addCriterion("rechargegivepoints =", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsNotEqualTo(Integer value) {
            addCriterion("rechargegivepoints <>", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsGreaterThan(Integer value) {
            addCriterion("rechargegivepoints >", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rechargegivepoints >=", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsLessThan(Integer value) {
            addCriterion("rechargegivepoints <", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsLessThanOrEqualTo(Integer value) {
            addCriterion("rechargegivepoints <=", value, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsIn(List<Integer> values) {
            addCriterion("rechargegivepoints in", values, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsNotIn(List<Integer> values) {
            addCriterion("rechargegivepoints not in", values, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsBetween(Integer value1, Integer value2) {
            addCriterion("rechargegivepoints between", value1, value2, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargegivepointsNotBetween(Integer value1, Integer value2) {
            addCriterion("rechargegivepoints not between", value1, value2, "rechargegivepoints");
            return (Criteria) this;
        }

        public Criteria andRechargestateIsNull() {
            addCriterion("rechargestate is null");
            return (Criteria) this;
        }

        public Criteria andRechargestateIsNotNull() {
            addCriterion("rechargestate is not null");
            return (Criteria) this;
        }

        public Criteria andRechargestateEqualTo(String value) {
            addCriterion("rechargestate =", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotEqualTo(String value) {
            addCriterion("rechargestate <>", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateGreaterThan(String value) {
            addCriterion("rechargestate >", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateGreaterThanOrEqualTo(String value) {
            addCriterion("rechargestate >=", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLessThan(String value) {
            addCriterion("rechargestate <", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLessThanOrEqualTo(String value) {
            addCriterion("rechargestate <=", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateLike(String value) {
            addCriterion("rechargestate like", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotLike(String value) {
            addCriterion("rechargestate not like", value, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateIn(List<String> values) {
            addCriterion("rechargestate in", values, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotIn(List<String> values) {
            addCriterion("rechargestate not in", values, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateBetween(String value1, String value2) {
            addCriterion("rechargestate between", value1, value2, "rechargestate");
            return (Criteria) this;
        }

        public Criteria andRechargestateNotBetween(String value1, String value2) {
            addCriterion("rechargestate not between", value1, value2, "rechargestate");
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