package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TIndexInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIndexInfoExample() {
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

        public Criteria andIndexpkIsNull() {
            addCriterion("indexpk is null");
            return (Criteria) this;
        }

        public Criteria andIndexpkIsNotNull() {
            addCriterion("indexpk is not null");
            return (Criteria) this;
        }

        public Criteria andIndexpkEqualTo(Integer value) {
            addCriterion("indexpk =", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkNotEqualTo(Integer value) {
            addCriterion("indexpk <>", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkGreaterThan(Integer value) {
            addCriterion("indexpk >", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("indexpk >=", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkLessThan(Integer value) {
            addCriterion("indexpk <", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkLessThanOrEqualTo(Integer value) {
            addCriterion("indexpk <=", value, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkIn(List<Integer> values) {
            addCriterion("indexpk in", values, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkNotIn(List<Integer> values) {
            addCriterion("indexpk not in", values, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkBetween(Integer value1, Integer value2) {
            addCriterion("indexpk between", value1, value2, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexpkNotBetween(Integer value1, Integer value2) {
            addCriterion("indexpk not between", value1, value2, "indexpk");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNull() {
            addCriterion("indexid is null");
            return (Criteria) this;
        }

        public Criteria andIndexidIsNotNull() {
            addCriterion("indexid is not null");
            return (Criteria) this;
        }

        public Criteria andIndexidEqualTo(String value) {
            addCriterion("indexid =", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotEqualTo(String value) {
            addCriterion("indexid <>", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThan(String value) {
            addCriterion("indexid >", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidGreaterThanOrEqualTo(String value) {
            addCriterion("indexid >=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThan(String value) {
            addCriterion("indexid <", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLessThanOrEqualTo(String value) {
            addCriterion("indexid <=", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidLike(String value) {
            addCriterion("indexid like", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotLike(String value) {
            addCriterion("indexid not like", value, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidIn(List<String> values) {
            addCriterion("indexid in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotIn(List<String> values) {
            addCriterion("indexid not in", values, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidBetween(String value1, String value2) {
            addCriterion("indexid between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexidNotBetween(String value1, String value2) {
            addCriterion("indexid not between", value1, value2, "indexid");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNull() {
            addCriterion("indexname is null");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNotNull() {
            addCriterion("indexname is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnameEqualTo(String value) {
            addCriterion("indexname =", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotEqualTo(String value) {
            addCriterion("indexname <>", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThan(String value) {
            addCriterion("indexname >", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThanOrEqualTo(String value) {
            addCriterion("indexname >=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThan(String value) {
            addCriterion("indexname <", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThanOrEqualTo(String value) {
            addCriterion("indexname <=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLike(String value) {
            addCriterion("indexname like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotLike(String value) {
            addCriterion("indexname not like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameIn(List<String> values) {
            addCriterion("indexname in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotIn(List<String> values) {
            addCriterion("indexname not in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameBetween(String value1, String value2) {
            addCriterion("indexname between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotBetween(String value1, String value2) {
            addCriterion("indexname not between", value1, value2, "indexname");
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