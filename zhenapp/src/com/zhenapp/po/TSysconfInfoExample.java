package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TSysconfInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSysconfInfoExample() {
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

        public Criteria andSysconfpkIsNull() {
            addCriterion("sysconfpk is null");
            return (Criteria) this;
        }

        public Criteria andSysconfpkIsNotNull() {
            addCriterion("sysconfpk is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfpkEqualTo(Integer value) {
            addCriterion("sysconfpk =", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkNotEqualTo(Integer value) {
            addCriterion("sysconfpk <>", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkGreaterThan(Integer value) {
            addCriterion("sysconfpk >", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysconfpk >=", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkLessThan(Integer value) {
            addCriterion("sysconfpk <", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkLessThanOrEqualTo(Integer value) {
            addCriterion("sysconfpk <=", value, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkIn(List<Integer> values) {
            addCriterion("sysconfpk in", values, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkNotIn(List<Integer> values) {
            addCriterion("sysconfpk not in", values, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkBetween(Integer value1, Integer value2) {
            addCriterion("sysconfpk between", value1, value2, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfpkNotBetween(Integer value1, Integer value2) {
            addCriterion("sysconfpk not between", value1, value2, "sysconfpk");
            return (Criteria) this;
        }

        public Criteria andSysconfidIsNull() {
            addCriterion("sysconfid is null");
            return (Criteria) this;
        }

        public Criteria andSysconfidIsNotNull() {
            addCriterion("sysconfid is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfidEqualTo(String value) {
            addCriterion("sysconfid =", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidNotEqualTo(String value) {
            addCriterion("sysconfid <>", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidGreaterThan(String value) {
            addCriterion("sysconfid >", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidGreaterThanOrEqualTo(String value) {
            addCriterion("sysconfid >=", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidLessThan(String value) {
            addCriterion("sysconfid <", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidLessThanOrEqualTo(String value) {
            addCriterion("sysconfid <=", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidLike(String value) {
            addCriterion("sysconfid like", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidNotLike(String value) {
            addCriterion("sysconfid not like", value, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidIn(List<String> values) {
            addCriterion("sysconfid in", values, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidNotIn(List<String> values) {
            addCriterion("sysconfid not in", values, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidBetween(String value1, String value2) {
            addCriterion("sysconfid between", value1, value2, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfidNotBetween(String value1, String value2) {
            addCriterion("sysconfid not between", value1, value2, "sysconfid");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1IsNull() {
            addCriterion("sysconfcode1 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1IsNotNull() {
            addCriterion("sysconfcode1 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1EqualTo(String value) {
            addCriterion("sysconfcode1 =", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1NotEqualTo(String value) {
            addCriterion("sysconfcode1 <>", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1GreaterThan(String value) {
            addCriterion("sysconfcode1 >", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfcode1 >=", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1LessThan(String value) {
            addCriterion("sysconfcode1 <", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1LessThanOrEqualTo(String value) {
            addCriterion("sysconfcode1 <=", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1Like(String value) {
            addCriterion("sysconfcode1 like", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1NotLike(String value) {
            addCriterion("sysconfcode1 not like", value, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1In(List<String> values) {
            addCriterion("sysconfcode1 in", values, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1NotIn(List<String> values) {
            addCriterion("sysconfcode1 not in", values, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1Between(String value1, String value2) {
            addCriterion("sysconfcode1 between", value1, value2, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode1NotBetween(String value1, String value2) {
            addCriterion("sysconfcode1 not between", value1, value2, "sysconfcode1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1IsNull() {
            addCriterion("sysconfname1 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfname1IsNotNull() {
            addCriterion("sysconfname1 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfname1EqualTo(String value) {
            addCriterion("sysconfname1 =", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1NotEqualTo(String value) {
            addCriterion("sysconfname1 <>", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1GreaterThan(String value) {
            addCriterion("sysconfname1 >", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfname1 >=", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1LessThan(String value) {
            addCriterion("sysconfname1 <", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1LessThanOrEqualTo(String value) {
            addCriterion("sysconfname1 <=", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1Like(String value) {
            addCriterion("sysconfname1 like", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1NotLike(String value) {
            addCriterion("sysconfname1 not like", value, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1In(List<String> values) {
            addCriterion("sysconfname1 in", values, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1NotIn(List<String> values) {
            addCriterion("sysconfname1 not in", values, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1Between(String value1, String value2) {
            addCriterion("sysconfname1 between", value1, value2, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfname1NotBetween(String value1, String value2) {
            addCriterion("sysconfname1 not between", value1, value2, "sysconfname1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1IsNull() {
            addCriterion("sysconfvalue1 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1IsNotNull() {
            addCriterion("sysconfvalue1 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1EqualTo(String value) {
            addCriterion("sysconfvalue1 =", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1NotEqualTo(String value) {
            addCriterion("sysconfvalue1 <>", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1GreaterThan(String value) {
            addCriterion("sysconfvalue1 >", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfvalue1 >=", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1LessThan(String value) {
            addCriterion("sysconfvalue1 <", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1LessThanOrEqualTo(String value) {
            addCriterion("sysconfvalue1 <=", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1Like(String value) {
            addCriterion("sysconfvalue1 like", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1NotLike(String value) {
            addCriterion("sysconfvalue1 not like", value, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1In(List<String> values) {
            addCriterion("sysconfvalue1 in", values, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1NotIn(List<String> values) {
            addCriterion("sysconfvalue1 not in", values, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1Between(String value1, String value2) {
            addCriterion("sysconfvalue1 between", value1, value2, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue1NotBetween(String value1, String value2) {
            addCriterion("sysconfvalue1 not between", value1, value2, "sysconfvalue1");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4IsNull() {
            addCriterion("sysconfcode4 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4IsNotNull() {
            addCriterion("sysconfcode4 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4EqualTo(String value) {
            addCriterion("sysconfcode4 =", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4NotEqualTo(String value) {
            addCriterion("sysconfcode4 <>", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4GreaterThan(String value) {
            addCriterion("sysconfcode4 >", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfcode4 >=", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4LessThan(String value) {
            addCriterion("sysconfcode4 <", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4LessThanOrEqualTo(String value) {
            addCriterion("sysconfcode4 <=", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4Like(String value) {
            addCriterion("sysconfcode4 like", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4NotLike(String value) {
            addCriterion("sysconfcode4 not like", value, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4In(List<String> values) {
            addCriterion("sysconfcode4 in", values, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4NotIn(List<String> values) {
            addCriterion("sysconfcode4 not in", values, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4Between(String value1, String value2) {
            addCriterion("sysconfcode4 between", value1, value2, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode4NotBetween(String value1, String value2) {
            addCriterion("sysconfcode4 not between", value1, value2, "sysconfcode4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4IsNull() {
            addCriterion("sysconfname4 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfname4IsNotNull() {
            addCriterion("sysconfname4 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfname4EqualTo(String value) {
            addCriterion("sysconfname4 =", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4NotEqualTo(String value) {
            addCriterion("sysconfname4 <>", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4GreaterThan(String value) {
            addCriterion("sysconfname4 >", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfname4 >=", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4LessThan(String value) {
            addCriterion("sysconfname4 <", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4LessThanOrEqualTo(String value) {
            addCriterion("sysconfname4 <=", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4Like(String value) {
            addCriterion("sysconfname4 like", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4NotLike(String value) {
            addCriterion("sysconfname4 not like", value, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4In(List<String> values) {
            addCriterion("sysconfname4 in", values, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4NotIn(List<String> values) {
            addCriterion("sysconfname4 not in", values, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4Between(String value1, String value2) {
            addCriterion("sysconfname4 between", value1, value2, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfname4NotBetween(String value1, String value2) {
            addCriterion("sysconfname4 not between", value1, value2, "sysconfname4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4IsNull() {
            addCriterion("sysconfvalue4 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4IsNotNull() {
            addCriterion("sysconfvalue4 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4EqualTo(String value) {
            addCriterion("sysconfvalue4 =", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4NotEqualTo(String value) {
            addCriterion("sysconfvalue4 <>", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4GreaterThan(String value) {
            addCriterion("sysconfvalue4 >", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfvalue4 >=", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4LessThan(String value) {
            addCriterion("sysconfvalue4 <", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4LessThanOrEqualTo(String value) {
            addCriterion("sysconfvalue4 <=", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4Like(String value) {
            addCriterion("sysconfvalue4 like", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4NotLike(String value) {
            addCriterion("sysconfvalue4 not like", value, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4In(List<String> values) {
            addCriterion("sysconfvalue4 in", values, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4NotIn(List<String> values) {
            addCriterion("sysconfvalue4 not in", values, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4Between(String value1, String value2) {
            addCriterion("sysconfvalue4 between", value1, value2, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue4NotBetween(String value1, String value2) {
            addCriterion("sysconfvalue4 not between", value1, value2, "sysconfvalue4");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5IsNull() {
            addCriterion("sysconfcode5 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5IsNotNull() {
            addCriterion("sysconfcode5 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5EqualTo(String value) {
            addCriterion("sysconfcode5 =", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5NotEqualTo(String value) {
            addCriterion("sysconfcode5 <>", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5GreaterThan(String value) {
            addCriterion("sysconfcode5 >", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfcode5 >=", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5LessThan(String value) {
            addCriterion("sysconfcode5 <", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5LessThanOrEqualTo(String value) {
            addCriterion("sysconfcode5 <=", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5Like(String value) {
            addCriterion("sysconfcode5 like", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5NotLike(String value) {
            addCriterion("sysconfcode5 not like", value, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5In(List<String> values) {
            addCriterion("sysconfcode5 in", values, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5NotIn(List<String> values) {
            addCriterion("sysconfcode5 not in", values, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5Between(String value1, String value2) {
            addCriterion("sysconfcode5 between", value1, value2, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode5NotBetween(String value1, String value2) {
            addCriterion("sysconfcode5 not between", value1, value2, "sysconfcode5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5IsNull() {
            addCriterion("sysconfname5 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfname5IsNotNull() {
            addCriterion("sysconfname5 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfname5EqualTo(String value) {
            addCriterion("sysconfname5 =", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5NotEqualTo(String value) {
            addCriterion("sysconfname5 <>", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5GreaterThan(String value) {
            addCriterion("sysconfname5 >", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfname5 >=", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5LessThan(String value) {
            addCriterion("sysconfname5 <", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5LessThanOrEqualTo(String value) {
            addCriterion("sysconfname5 <=", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5Like(String value) {
            addCriterion("sysconfname5 like", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5NotLike(String value) {
            addCriterion("sysconfname5 not like", value, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5In(List<String> values) {
            addCriterion("sysconfname5 in", values, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5NotIn(List<String> values) {
            addCriterion("sysconfname5 not in", values, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5Between(String value1, String value2) {
            addCriterion("sysconfname5 between", value1, value2, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfname5NotBetween(String value1, String value2) {
            addCriterion("sysconfname5 not between", value1, value2, "sysconfname5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5IsNull() {
            addCriterion("sysconfvalue5 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5IsNotNull() {
            addCriterion("sysconfvalue5 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5EqualTo(String value) {
            addCriterion("sysconfvalue5 =", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5NotEqualTo(String value) {
            addCriterion("sysconfvalue5 <>", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5GreaterThan(String value) {
            addCriterion("sysconfvalue5 >", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfvalue5 >=", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5LessThan(String value) {
            addCriterion("sysconfvalue5 <", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5LessThanOrEqualTo(String value) {
            addCriterion("sysconfvalue5 <=", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5Like(String value) {
            addCriterion("sysconfvalue5 like", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5NotLike(String value) {
            addCriterion("sysconfvalue5 not like", value, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5In(List<String> values) {
            addCriterion("sysconfvalue5 in", values, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5NotIn(List<String> values) {
            addCriterion("sysconfvalue5 not in", values, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5Between(String value1, String value2) {
            addCriterion("sysconfvalue5 between", value1, value2, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue5NotBetween(String value1, String value2) {
            addCriterion("sysconfvalue5 not between", value1, value2, "sysconfvalue5");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6IsNull() {
            addCriterion("sysconfcode6 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6IsNotNull() {
            addCriterion("sysconfcode6 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6EqualTo(String value) {
            addCriterion("sysconfcode6 =", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6NotEqualTo(String value) {
            addCriterion("sysconfcode6 <>", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6GreaterThan(String value) {
            addCriterion("sysconfcode6 >", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfcode6 >=", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6LessThan(String value) {
            addCriterion("sysconfcode6 <", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6LessThanOrEqualTo(String value) {
            addCriterion("sysconfcode6 <=", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6Like(String value) {
            addCriterion("sysconfcode6 like", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6NotLike(String value) {
            addCriterion("sysconfcode6 not like", value, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6In(List<String> values) {
            addCriterion("sysconfcode6 in", values, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6NotIn(List<String> values) {
            addCriterion("sysconfcode6 not in", values, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6Between(String value1, String value2) {
            addCriterion("sysconfcode6 between", value1, value2, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfcode6NotBetween(String value1, String value2) {
            addCriterion("sysconfcode6 not between", value1, value2, "sysconfcode6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6IsNull() {
            addCriterion("sysconfname6 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfname6IsNotNull() {
            addCriterion("sysconfname6 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfname6EqualTo(String value) {
            addCriterion("sysconfname6 =", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6NotEqualTo(String value) {
            addCriterion("sysconfname6 <>", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6GreaterThan(String value) {
            addCriterion("sysconfname6 >", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfname6 >=", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6LessThan(String value) {
            addCriterion("sysconfname6 <", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6LessThanOrEqualTo(String value) {
            addCriterion("sysconfname6 <=", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6Like(String value) {
            addCriterion("sysconfname6 like", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6NotLike(String value) {
            addCriterion("sysconfname6 not like", value, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6In(List<String> values) {
            addCriterion("sysconfname6 in", values, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6NotIn(List<String> values) {
            addCriterion("sysconfname6 not in", values, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6Between(String value1, String value2) {
            addCriterion("sysconfname6 between", value1, value2, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfname6NotBetween(String value1, String value2) {
            addCriterion("sysconfname6 not between", value1, value2, "sysconfname6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6IsNull() {
            addCriterion("sysconfvalue6 is null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6IsNotNull() {
            addCriterion("sysconfvalue6 is not null");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6EqualTo(String value) {
            addCriterion("sysconfvalue6 =", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6NotEqualTo(String value) {
            addCriterion("sysconfvalue6 <>", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6GreaterThan(String value) {
            addCriterion("sysconfvalue6 >", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6GreaterThanOrEqualTo(String value) {
            addCriterion("sysconfvalue6 >=", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6LessThan(String value) {
            addCriterion("sysconfvalue6 <", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6LessThanOrEqualTo(String value) {
            addCriterion("sysconfvalue6 <=", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6Like(String value) {
            addCriterion("sysconfvalue6 like", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6NotLike(String value) {
            addCriterion("sysconfvalue6 not like", value, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6In(List<String> values) {
            addCriterion("sysconfvalue6 in", values, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6NotIn(List<String> values) {
            addCriterion("sysconfvalue6 not in", values, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6Between(String value1, String value2) {
            addCriterion("sysconfvalue6 between", value1, value2, "sysconfvalue6");
            return (Criteria) this;
        }

        public Criteria andSysconfvalue6NotBetween(String value1, String value2) {
            addCriterion("sysconfvalue6 not between", value1, value2, "sysconfvalue6");
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