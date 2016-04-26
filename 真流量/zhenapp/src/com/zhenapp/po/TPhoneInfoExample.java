package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TPhoneInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPhoneInfoExample() {
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

        public Criteria andPhonepkIsNull() {
            addCriterion("phonepk is null");
            return (Criteria) this;
        }

        public Criteria andPhonepkIsNotNull() {
            addCriterion("phonepk is not null");
            return (Criteria) this;
        }

        public Criteria andPhonepkEqualTo(Integer value) {
            addCriterion("phonepk =", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkNotEqualTo(Integer value) {
            addCriterion("phonepk <>", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkGreaterThan(Integer value) {
            addCriterion("phonepk >", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonepk >=", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkLessThan(Integer value) {
            addCriterion("phonepk <", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkLessThanOrEqualTo(Integer value) {
            addCriterion("phonepk <=", value, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkIn(List<Integer> values) {
            addCriterion("phonepk in", values, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkNotIn(List<Integer> values) {
            addCriterion("phonepk not in", values, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkBetween(Integer value1, Integer value2) {
            addCriterion("phonepk between", value1, value2, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhonepkNotBetween(Integer value1, Integer value2) {
            addCriterion("phonepk not between", value1, value2, "phonepk");
            return (Criteria) this;
        }

        public Criteria andPhoneidIsNull() {
            addCriterion("phoneid is null");
            return (Criteria) this;
        }

        public Criteria andPhoneidIsNotNull() {
            addCriterion("phoneid is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneidEqualTo(String value) {
            addCriterion("phoneid =", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidNotEqualTo(String value) {
            addCriterion("phoneid <>", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidGreaterThan(String value) {
            addCriterion("phoneid >", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidGreaterThanOrEqualTo(String value) {
            addCriterion("phoneid >=", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidLessThan(String value) {
            addCriterion("phoneid <", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidLessThanOrEqualTo(String value) {
            addCriterion("phoneid <=", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidLike(String value) {
            addCriterion("phoneid like", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidNotLike(String value) {
            addCriterion("phoneid not like", value, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidIn(List<String> values) {
            addCriterion("phoneid in", values, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidNotIn(List<String> values) {
            addCriterion("phoneid not in", values, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidBetween(String value1, String value2) {
            addCriterion("phoneid between", value1, value2, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhoneidNotBetween(String value1, String value2) {
            addCriterion("phoneid not between", value1, value2, "phoneid");
            return (Criteria) this;
        }

        public Criteria andPhonestateIsNull() {
            addCriterion("phonestate is null");
            return (Criteria) this;
        }

        public Criteria andPhonestateIsNotNull() {
            addCriterion("phonestate is not null");
            return (Criteria) this;
        }

        public Criteria andPhonestateEqualTo(Integer value) {
            addCriterion("phonestate =", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateNotEqualTo(Integer value) {
            addCriterion("phonestate <>", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateGreaterThan(Integer value) {
            addCriterion("phonestate >", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonestate >=", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateLessThan(Integer value) {
            addCriterion("phonestate <", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateLessThanOrEqualTo(Integer value) {
            addCriterion("phonestate <=", value, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateIn(List<Integer> values) {
            addCriterion("phonestate in", values, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateNotIn(List<Integer> values) {
            addCriterion("phonestate not in", values, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateBetween(Integer value1, Integer value2) {
            addCriterion("phonestate between", value1, value2, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonestateNotBetween(Integer value1, Integer value2) {
            addCriterion("phonestate not between", value1, value2, "phonestate");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumIsNull() {
            addCriterion("phonetasknum is null");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumIsNotNull() {
            addCriterion("phonetasknum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumEqualTo(Integer value) {
            addCriterion("phonetasknum =", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumNotEqualTo(Integer value) {
            addCriterion("phonetasknum <>", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumGreaterThan(Integer value) {
            addCriterion("phonetasknum >", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonetasknum >=", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumLessThan(Integer value) {
            addCriterion("phonetasknum <", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumLessThanOrEqualTo(Integer value) {
            addCriterion("phonetasknum <=", value, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumIn(List<Integer> values) {
            addCriterion("phonetasknum in", values, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumNotIn(List<Integer> values) {
            addCriterion("phonetasknum not in", values, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumBetween(Integer value1, Integer value2) {
            addCriterion("phonetasknum between", value1, value2, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonetasknumNotBetween(Integer value1, Integer value2) {
            addCriterion("phonetasknum not between", value1, value2, "phonetasknum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumIsNull() {
            addCriterion("phonesurplusnum is null");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumIsNotNull() {
            addCriterion("phonesurplusnum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumEqualTo(Integer value) {
            addCriterion("phonesurplusnum =", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumNotEqualTo(Integer value) {
            addCriterion("phonesurplusnum <>", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumGreaterThan(Integer value) {
            addCriterion("phonesurplusnum >", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonesurplusnum >=", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumLessThan(Integer value) {
            addCriterion("phonesurplusnum <", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumLessThanOrEqualTo(Integer value) {
            addCriterion("phonesurplusnum <=", value, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumIn(List<Integer> values) {
            addCriterion("phonesurplusnum in", values, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumNotIn(List<Integer> values) {
            addCriterion("phonesurplusnum not in", values, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumBetween(Integer value1, Integer value2) {
            addCriterion("phonesurplusnum between", value1, value2, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonesurplusnumNotBetween(Integer value1, Integer value2) {
            addCriterion("phonesurplusnum not between", value1, value2, "phonesurplusnum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumIsNull() {
            addCriterion("phonealreadynum is null");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumIsNotNull() {
            addCriterion("phonealreadynum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumEqualTo(Integer value) {
            addCriterion("phonealreadynum =", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumNotEqualTo(Integer value) {
            addCriterion("phonealreadynum <>", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumGreaterThan(Integer value) {
            addCriterion("phonealreadynum >", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonealreadynum >=", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumLessThan(Integer value) {
            addCriterion("phonealreadynum <", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumLessThanOrEqualTo(Integer value) {
            addCriterion("phonealreadynum <=", value, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumIn(List<Integer> values) {
            addCriterion("phonealreadynum in", values, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumNotIn(List<Integer> values) {
            addCriterion("phonealreadynum not in", values, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumBetween(Integer value1, Integer value2) {
            addCriterion("phonealreadynum between", value1, value2, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonealreadynumNotBetween(Integer value1, Integer value2) {
            addCriterion("phonealreadynum not between", value1, value2, "phonealreadynum");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIsNull() {
            addCriterion("phonetype is null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIsNotNull() {
            addCriterion("phonetype is not null");
            return (Criteria) this;
        }

        public Criteria andPhonetypeEqualTo(String value) {
            addCriterion("phonetype =", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotEqualTo(String value) {
            addCriterion("phonetype <>", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeGreaterThan(String value) {
            addCriterion("phonetype >", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeGreaterThanOrEqualTo(String value) {
            addCriterion("phonetype >=", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLessThan(String value) {
            addCriterion("phonetype <", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLessThanOrEqualTo(String value) {
            addCriterion("phonetype <=", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeLike(String value) {
            addCriterion("phonetype like", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotLike(String value) {
            addCriterion("phonetype not like", value, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeIn(List<String> values) {
            addCriterion("phonetype in", values, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotIn(List<String> values) {
            addCriterion("phonetype not in", values, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeBetween(String value1, String value2) {
            addCriterion("phonetype between", value1, value2, "phonetype");
            return (Criteria) this;
        }

        public Criteria andPhonetypeNotBetween(String value1, String value2) {
            addCriterion("phonetype not between", value1, value2, "phonetype");
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