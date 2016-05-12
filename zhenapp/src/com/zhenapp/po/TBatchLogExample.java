package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TBatchLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBatchLogExample() {
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

        public Criteria andBatchlogpkIsNull() {
            addCriterion("batchlogpk is null");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkIsNotNull() {
            addCriterion("batchlogpk is not null");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkEqualTo(Integer value) {
            addCriterion("batchlogpk =", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkNotEqualTo(Integer value) {
            addCriterion("batchlogpk <>", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkGreaterThan(Integer value) {
            addCriterion("batchlogpk >", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("batchlogpk >=", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkLessThan(Integer value) {
            addCriterion("batchlogpk <", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkLessThanOrEqualTo(Integer value) {
            addCriterion("batchlogpk <=", value, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkIn(List<Integer> values) {
            addCriterion("batchlogpk in", values, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkNotIn(List<Integer> values) {
            addCriterion("batchlogpk not in", values, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkBetween(Integer value1, Integer value2) {
            addCriterion("batchlogpk between", value1, value2, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogpkNotBetween(Integer value1, Integer value2) {
            addCriterion("batchlogpk not between", value1, value2, "batchlogpk");
            return (Criteria) this;
        }

        public Criteria andBatchlogidIsNull() {
            addCriterion("batchlogid is null");
            return (Criteria) this;
        }

        public Criteria andBatchlogidIsNotNull() {
            addCriterion("batchlogid is not null");
            return (Criteria) this;
        }

        public Criteria andBatchlogidEqualTo(Integer value) {
            addCriterion("batchlogid =", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidNotEqualTo(Integer value) {
            addCriterion("batchlogid <>", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidGreaterThan(Integer value) {
            addCriterion("batchlogid >", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("batchlogid >=", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidLessThan(Integer value) {
            addCriterion("batchlogid <", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidLessThanOrEqualTo(Integer value) {
            addCriterion("batchlogid <=", value, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidIn(List<Integer> values) {
            addCriterion("batchlogid in", values, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidNotIn(List<Integer> values) {
            addCriterion("batchlogid not in", values, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidBetween(Integer value1, Integer value2) {
            addCriterion("batchlogid between", value1, value2, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlogidNotBetween(Integer value1, Integer value2) {
            addCriterion("batchlogid not between", value1, value2, "batchlogid");
            return (Criteria) this;
        }

        public Criteria andBatchlognameIsNull() {
            addCriterion("batchlogname is null");
            return (Criteria) this;
        }

        public Criteria andBatchlognameIsNotNull() {
            addCriterion("batchlogname is not null");
            return (Criteria) this;
        }

        public Criteria andBatchlognameEqualTo(String value) {
            addCriterion("batchlogname =", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameNotEqualTo(String value) {
            addCriterion("batchlogname <>", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameGreaterThan(String value) {
            addCriterion("batchlogname >", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameGreaterThanOrEqualTo(String value) {
            addCriterion("batchlogname >=", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameLessThan(String value) {
            addCriterion("batchlogname <", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameLessThanOrEqualTo(String value) {
            addCriterion("batchlogname <=", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameLike(String value) {
            addCriterion("batchlogname like", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameNotLike(String value) {
            addCriterion("batchlogname not like", value, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameIn(List<String> values) {
            addCriterion("batchlogname in", values, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameNotIn(List<String> values) {
            addCriterion("batchlogname not in", values, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameBetween(String value1, String value2) {
            addCriterion("batchlogname between", value1, value2, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlognameNotBetween(String value1, String value2) {
            addCriterion("batchlogname not between", value1, value2, "batchlogname");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateIsNull() {
            addCriterion("batchlogstate is null");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateIsNotNull() {
            addCriterion("batchlogstate is not null");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateEqualTo(String value) {
            addCriterion("batchlogstate =", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateNotEqualTo(String value) {
            addCriterion("batchlogstate <>", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateGreaterThan(String value) {
            addCriterion("batchlogstate >", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateGreaterThanOrEqualTo(String value) {
            addCriterion("batchlogstate >=", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateLessThan(String value) {
            addCriterion("batchlogstate <", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateLessThanOrEqualTo(String value) {
            addCriterion("batchlogstate <=", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateLike(String value) {
            addCriterion("batchlogstate like", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateNotLike(String value) {
            addCriterion("batchlogstate not like", value, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateIn(List<String> values) {
            addCriterion("batchlogstate in", values, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateNotIn(List<String> values) {
            addCriterion("batchlogstate not in", values, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateBetween(String value1, String value2) {
            addCriterion("batchlogstate between", value1, value2, "batchlogstate");
            return (Criteria) this;
        }

        public Criteria andBatchlogstateNotBetween(String value1, String value2) {
            addCriterion("batchlogstate not between", value1, value2, "batchlogstate");
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