package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TPriceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPriceInfoExample() {
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

        public Criteria andPricepkIsNull() {
            addCriterion("pricepk is null");
            return (Criteria) this;
        }

        public Criteria andPricepkIsNotNull() {
            addCriterion("pricepk is not null");
            return (Criteria) this;
        }

        public Criteria andPricepkEqualTo(Integer value) {
            addCriterion("pricepk =", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkNotEqualTo(Integer value) {
            addCriterion("pricepk <>", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkGreaterThan(Integer value) {
            addCriterion("pricepk >", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkGreaterThanOrEqualTo(Integer value) {
            addCriterion("pricepk >=", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkLessThan(Integer value) {
            addCriterion("pricepk <", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkLessThanOrEqualTo(Integer value) {
            addCriterion("pricepk <=", value, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkIn(List<Integer> values) {
            addCriterion("pricepk in", values, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkNotIn(List<Integer> values) {
            addCriterion("pricepk not in", values, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkBetween(Integer value1, Integer value2) {
            addCriterion("pricepk between", value1, value2, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPricepkNotBetween(Integer value1, Integer value2) {
            addCriterion("pricepk not between", value1, value2, "pricepk");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNull() {
            addCriterion("priceid is null");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNotNull() {
            addCriterion("priceid is not null");
            return (Criteria) this;
        }

        public Criteria andPriceidEqualTo(String value) {
            addCriterion("priceid =", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotEqualTo(String value) {
            addCriterion("priceid <>", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThan(String value) {
            addCriterion("priceid >", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThanOrEqualTo(String value) {
            addCriterion("priceid >=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThan(String value) {
            addCriterion("priceid <", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThanOrEqualTo(String value) {
            addCriterion("priceid <=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLike(String value) {
            addCriterion("priceid like", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotLike(String value) {
            addCriterion("priceid not like", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidIn(List<String> values) {
            addCriterion("priceid in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotIn(List<String> values) {
            addCriterion("priceid not in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidBetween(String value1, String value2) {
            addCriterion("priceid between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotBetween(String value1, String value2) {
            addCriterion("priceid not between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNull() {
            addCriterion("pricetype is null");
            return (Criteria) this;
        }

        public Criteria andPricetypeIsNotNull() {
            addCriterion("pricetype is not null");
            return (Criteria) this;
        }

        public Criteria andPricetypeEqualTo(String value) {
            addCriterion("pricetype =", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotEqualTo(String value) {
            addCriterion("pricetype <>", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThan(String value) {
            addCriterion("pricetype >", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeGreaterThanOrEqualTo(String value) {
            addCriterion("pricetype >=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThan(String value) {
            addCriterion("pricetype <", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLessThanOrEqualTo(String value) {
            addCriterion("pricetype <=", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeLike(String value) {
            addCriterion("pricetype like", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotLike(String value) {
            addCriterion("pricetype not like", value, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeIn(List<String> values) {
            addCriterion("pricetype in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotIn(List<String> values) {
            addCriterion("pricetype not in", values, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeBetween(String value1, String value2) {
            addCriterion("pricetype between", value1, value2, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricetypeNotBetween(String value1, String value2) {
            addCriterion("pricetype not between", value1, value2, "pricetype");
            return (Criteria) this;
        }

        public Criteria andPricecodeIsNull() {
            addCriterion("pricecode is null");
            return (Criteria) this;
        }

        public Criteria andPricecodeIsNotNull() {
            addCriterion("pricecode is not null");
            return (Criteria) this;
        }

        public Criteria andPricecodeEqualTo(String value) {
            addCriterion("pricecode =", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeNotEqualTo(String value) {
            addCriterion("pricecode <>", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeGreaterThan(String value) {
            addCriterion("pricecode >", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeGreaterThanOrEqualTo(String value) {
            addCriterion("pricecode >=", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeLessThan(String value) {
            addCriterion("pricecode <", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeLessThanOrEqualTo(String value) {
            addCriterion("pricecode <=", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeLike(String value) {
            addCriterion("pricecode like", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeNotLike(String value) {
            addCriterion("pricecode not like", value, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeIn(List<String> values) {
            addCriterion("pricecode in", values, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeNotIn(List<String> values) {
            addCriterion("pricecode not in", values, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeBetween(String value1, String value2) {
            addCriterion("pricecode between", value1, value2, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecodeNotBetween(String value1, String value2) {
            addCriterion("pricecode not between", value1, value2, "pricecode");
            return (Criteria) this;
        }

        public Criteria andPricecountsIsNull() {
            addCriterion("pricecounts is null");
            return (Criteria) this;
        }

        public Criteria andPricecountsIsNotNull() {
            addCriterion("pricecounts is not null");
            return (Criteria) this;
        }

        public Criteria andPricecountsEqualTo(String value) {
            addCriterion("pricecounts =", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsNotEqualTo(String value) {
            addCriterion("pricecounts <>", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsGreaterThan(String value) {
            addCriterion("pricecounts >", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsGreaterThanOrEqualTo(String value) {
            addCriterion("pricecounts >=", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsLessThan(String value) {
            addCriterion("pricecounts <", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsLessThanOrEqualTo(String value) {
            addCriterion("pricecounts <=", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsLike(String value) {
            addCriterion("pricecounts like", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsNotLike(String value) {
            addCriterion("pricecounts not like", value, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsIn(List<String> values) {
            addCriterion("pricecounts in", values, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsNotIn(List<String> values) {
            addCriterion("pricecounts not in", values, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsBetween(String value1, String value2) {
            addCriterion("pricecounts between", value1, value2, "pricecounts");
            return (Criteria) this;
        }

        public Criteria andPricecountsNotBetween(String value1, String value2) {
            addCriterion("pricecounts not between", value1, value2, "pricecounts");
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