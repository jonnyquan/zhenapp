package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TDurationInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDurationInfoExample() {
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

        public Criteria andDurationpkIsNull() {
            addCriterion("durationpk is null");
            return (Criteria) this;
        }

        public Criteria andDurationpkIsNotNull() {
            addCriterion("durationpk is not null");
            return (Criteria) this;
        }

        public Criteria andDurationpkEqualTo(Integer value) {
            addCriterion("durationpk =", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkNotEqualTo(Integer value) {
            addCriterion("durationpk <>", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkGreaterThan(Integer value) {
            addCriterion("durationpk >", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("durationpk >=", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkLessThan(Integer value) {
            addCriterion("durationpk <", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkLessThanOrEqualTo(Integer value) {
            addCriterion("durationpk <=", value, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkIn(List<Integer> values) {
            addCriterion("durationpk in", values, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkNotIn(List<Integer> values) {
            addCriterion("durationpk not in", values, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkBetween(Integer value1, Integer value2) {
            addCriterion("durationpk between", value1, value2, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationpkNotBetween(Integer value1, Integer value2) {
            addCriterion("durationpk not between", value1, value2, "durationpk");
            return (Criteria) this;
        }

        public Criteria andDurationidIsNull() {
            addCriterion("durationid is null");
            return (Criteria) this;
        }

        public Criteria andDurationidIsNotNull() {
            addCriterion("durationid is not null");
            return (Criteria) this;
        }

        public Criteria andDurationidEqualTo(Integer value) {
            addCriterion("durationid =", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidNotEqualTo(Integer value) {
            addCriterion("durationid <>", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidGreaterThan(Integer value) {
            addCriterion("durationid >", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("durationid >=", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidLessThan(Integer value) {
            addCriterion("durationid <", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidLessThanOrEqualTo(Integer value) {
            addCriterion("durationid <=", value, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidIn(List<Integer> values) {
            addCriterion("durationid in", values, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidNotIn(List<Integer> values) {
            addCriterion("durationid not in", values, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidBetween(Integer value1, Integer value2) {
            addCriterion("durationid between", value1, value2, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationidNotBetween(Integer value1, Integer value2) {
            addCriterion("durationid not between", value1, value2, "durationid");
            return (Criteria) this;
        }

        public Criteria andDurationminIsNull() {
            addCriterion("durationmin is null");
            return (Criteria) this;
        }

        public Criteria andDurationminIsNotNull() {
            addCriterion("durationmin is not null");
            return (Criteria) this;
        }

        public Criteria andDurationminEqualTo(String value) {
            addCriterion("durationmin =", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminNotEqualTo(String value) {
            addCriterion("durationmin <>", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminGreaterThan(String value) {
            addCriterion("durationmin >", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminGreaterThanOrEqualTo(String value) {
            addCriterion("durationmin >=", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminLessThan(String value) {
            addCriterion("durationmin <", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminLessThanOrEqualTo(String value) {
            addCriterion("durationmin <=", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminLike(String value) {
            addCriterion("durationmin like", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminNotLike(String value) {
            addCriterion("durationmin not like", value, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminIn(List<String> values) {
            addCriterion("durationmin in", values, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminNotIn(List<String> values) {
            addCriterion("durationmin not in", values, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminBetween(String value1, String value2) {
            addCriterion("durationmin between", value1, value2, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationminNotBetween(String value1, String value2) {
            addCriterion("durationmin not between", value1, value2, "durationmin");
            return (Criteria) this;
        }

        public Criteria andDurationmaxIsNull() {
            addCriterion("durationmax is null");
            return (Criteria) this;
        }

        public Criteria andDurationmaxIsNotNull() {
            addCriterion("durationmax is not null");
            return (Criteria) this;
        }

        public Criteria andDurationmaxEqualTo(String value) {
            addCriterion("durationmax =", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxNotEqualTo(String value) {
            addCriterion("durationmax <>", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxGreaterThan(String value) {
            addCriterion("durationmax >", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxGreaterThanOrEqualTo(String value) {
            addCriterion("durationmax >=", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxLessThan(String value) {
            addCriterion("durationmax <", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxLessThanOrEqualTo(String value) {
            addCriterion("durationmax <=", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxLike(String value) {
            addCriterion("durationmax like", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxNotLike(String value) {
            addCriterion("durationmax not like", value, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxIn(List<String> values) {
            addCriterion("durationmax in", values, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxNotIn(List<String> values) {
            addCriterion("durationmax not in", values, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxBetween(String value1, String value2) {
            addCriterion("durationmax between", value1, value2, "durationmax");
            return (Criteria) this;
        }

        public Criteria andDurationmaxNotBetween(String value1, String value2) {
            addCriterion("durationmax not between", value1, value2, "durationmax");
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