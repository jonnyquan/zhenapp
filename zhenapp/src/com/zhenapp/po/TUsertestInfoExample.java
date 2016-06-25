package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TUsertestInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUsertestInfoExample() {
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

        public Criteria andUsertestpkIsNull() {
            addCriterion("usertestpk is null");
            return (Criteria) this;
        }

        public Criteria andUsertestpkIsNotNull() {
            addCriterion("usertestpk is not null");
            return (Criteria) this;
        }

        public Criteria andUsertestpkEqualTo(Integer value) {
            addCriterion("usertestpk =", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkNotEqualTo(Integer value) {
            addCriterion("usertestpk <>", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkGreaterThan(Integer value) {
            addCriterion("usertestpk >", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("usertestpk >=", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkLessThan(Integer value) {
            addCriterion("usertestpk <", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkLessThanOrEqualTo(Integer value) {
            addCriterion("usertestpk <=", value, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkIn(List<Integer> values) {
            addCriterion("usertestpk in", values, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkNotIn(List<Integer> values) {
            addCriterion("usertestpk not in", values, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkBetween(Integer value1, Integer value2) {
            addCriterion("usertestpk between", value1, value2, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestpkNotBetween(Integer value1, Integer value2) {
            addCriterion("usertestpk not between", value1, value2, "usertestpk");
            return (Criteria) this;
        }

        public Criteria andUsertestidIsNull() {
            addCriterion("usertestid is null");
            return (Criteria) this;
        }

        public Criteria andUsertestidIsNotNull() {
            addCriterion("usertestid is not null");
            return (Criteria) this;
        }

        public Criteria andUsertestidEqualTo(String value) {
            addCriterion("usertestid =", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidNotEqualTo(String value) {
            addCriterion("usertestid <>", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidGreaterThan(String value) {
            addCriterion("usertestid >", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidGreaterThanOrEqualTo(String value) {
            addCriterion("usertestid >=", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidLessThan(String value) {
            addCriterion("usertestid <", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidLessThanOrEqualTo(String value) {
            addCriterion("usertestid <=", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidLike(String value) {
            addCriterion("usertestid like", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidNotLike(String value) {
            addCriterion("usertestid not like", value, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidIn(List<String> values) {
            addCriterion("usertestid in", values, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidNotIn(List<String> values) {
            addCriterion("usertestid not in", values, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidBetween(String value1, String value2) {
            addCriterion("usertestid between", value1, value2, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestidNotBetween(String value1, String value2) {
            addCriterion("usertestid not between", value1, value2, "usertestid");
            return (Criteria) this;
        }

        public Criteria andUsertestnickIsNull() {
            addCriterion("usertestnick is null");
            return (Criteria) this;
        }

        public Criteria andUsertestnickIsNotNull() {
            addCriterion("usertestnick is not null");
            return (Criteria) this;
        }

        public Criteria andUsertestnickEqualTo(String value) {
            addCriterion("usertestnick =", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickNotEqualTo(String value) {
            addCriterion("usertestnick <>", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickGreaterThan(String value) {
            addCriterion("usertestnick >", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickGreaterThanOrEqualTo(String value) {
            addCriterion("usertestnick >=", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickLessThan(String value) {
            addCriterion("usertestnick <", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickLessThanOrEqualTo(String value) {
            addCriterion("usertestnick <=", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickLike(String value) {
            addCriterion("usertestnick like", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickNotLike(String value) {
            addCriterion("usertestnick not like", value, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickIn(List<String> values) {
            addCriterion("usertestnick in", values, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickNotIn(List<String> values) {
            addCriterion("usertestnick not in", values, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickBetween(String value1, String value2) {
            addCriterion("usertestnick between", value1, value2, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUsertestnickNotBetween(String value1, String value2) {
            addCriterion("usertestnick not between", value1, value2, "usertestnick");
            return (Criteria) this;
        }

        public Criteria andUserroleidIsNull() {
            addCriterion("userroleid is null");
            return (Criteria) this;
        }

        public Criteria andUserroleidIsNotNull() {
            addCriterion("userroleid is not null");
            return (Criteria) this;
        }

        public Criteria andUserroleidEqualTo(String value) {
            addCriterion("userroleid =", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotEqualTo(String value) {
            addCriterion("userroleid <>", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidGreaterThan(String value) {
            addCriterion("userroleid >", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidGreaterThanOrEqualTo(String value) {
            addCriterion("userroleid >=", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidLessThan(String value) {
            addCriterion("userroleid <", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidLessThanOrEqualTo(String value) {
            addCriterion("userroleid <=", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidLike(String value) {
            addCriterion("userroleid like", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotLike(String value) {
            addCriterion("userroleid not like", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidIn(List<String> values) {
            addCriterion("userroleid in", values, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotIn(List<String> values) {
            addCriterion("userroleid not in", values, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidBetween(String value1, String value2) {
            addCriterion("userroleid between", value1, value2, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotBetween(String value1, String value2) {
            addCriterion("userroleid not between", value1, value2, "userroleid");
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