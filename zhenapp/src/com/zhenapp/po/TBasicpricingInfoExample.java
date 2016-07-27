package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TBasicpricingInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBasicpricingInfoExample() {
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

        public Criteria andBasicpricingpkIsNull() {
            addCriterion("basicpricingpk is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkIsNotNull() {
            addCriterion("basicpricingpk is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkEqualTo(Integer value) {
            addCriterion("basicpricingpk =", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkNotEqualTo(Integer value) {
            addCriterion("basicpricingpk <>", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkGreaterThan(Integer value) {
            addCriterion("basicpricingpk >", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("basicpricingpk >=", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkLessThan(Integer value) {
            addCriterion("basicpricingpk <", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkLessThanOrEqualTo(Integer value) {
            addCriterion("basicpricingpk <=", value, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkIn(List<Integer> values) {
            addCriterion("basicpricingpk in", values, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkNotIn(List<Integer> values) {
            addCriterion("basicpricingpk not in", values, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkBetween(Integer value1, Integer value2) {
            addCriterion("basicpricingpk between", value1, value2, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingpkNotBetween(Integer value1, Integer value2) {
            addCriterion("basicpricingpk not between", value1, value2, "basicpricingpk");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidIsNull() {
            addCriterion("basicpricingid is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidIsNotNull() {
            addCriterion("basicpricingid is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidEqualTo(String value) {
            addCriterion("basicpricingid =", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidNotEqualTo(String value) {
            addCriterion("basicpricingid <>", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidGreaterThan(String value) {
            addCriterion("basicpricingid >", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidGreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingid >=", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidLessThan(String value) {
            addCriterion("basicpricingid <", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidLessThanOrEqualTo(String value) {
            addCriterion("basicpricingid <=", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidLike(String value) {
            addCriterion("basicpricingid like", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidNotLike(String value) {
            addCriterion("basicpricingid not like", value, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidIn(List<String> values) {
            addCriterion("basicpricingid in", values, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidNotIn(List<String> values) {
            addCriterion("basicpricingid not in", values, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidBetween(String value1, String value2) {
            addCriterion("basicpricingid between", value1, value2, "basicpricingid");
            return (Criteria) this;
        }

        public Criteria andBasicpricingidNotBetween(String value1, String value2) {
            addCriterion("basicpricingid not between", value1, value2, "basicpricingid");
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

        public Criteria andBasicpricingname1IsNull() {
            addCriterion("basicpricingname1 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1IsNotNull() {
            addCriterion("basicpricingname1 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1EqualTo(String value) {
            addCriterion("basicpricingname1 =", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1NotEqualTo(String value) {
            addCriterion("basicpricingname1 <>", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1GreaterThan(String value) {
            addCriterion("basicpricingname1 >", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingname1 >=", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1LessThan(String value) {
            addCriterion("basicpricingname1 <", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1LessThanOrEqualTo(String value) {
            addCriterion("basicpricingname1 <=", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1Like(String value) {
            addCriterion("basicpricingname1 like", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1NotLike(String value) {
            addCriterion("basicpricingname1 not like", value, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1In(List<String> values) {
            addCriterion("basicpricingname1 in", values, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1NotIn(List<String> values) {
            addCriterion("basicpricingname1 not in", values, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1Between(String value1, String value2) {
            addCriterion("basicpricingname1 between", value1, value2, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname1NotBetween(String value1, String value2) {
            addCriterion("basicpricingname1 not between", value1, value2, "basicpricingname1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1IsNull() {
            addCriterion("basicpricingvalue1 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1IsNotNull() {
            addCriterion("basicpricingvalue1 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1EqualTo(String value) {
            addCriterion("basicpricingvalue1 =", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1NotEqualTo(String value) {
            addCriterion("basicpricingvalue1 <>", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1GreaterThan(String value) {
            addCriterion("basicpricingvalue1 >", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue1 >=", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1LessThan(String value) {
            addCriterion("basicpricingvalue1 <", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1LessThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue1 <=", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1Like(String value) {
            addCriterion("basicpricingvalue1 like", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1NotLike(String value) {
            addCriterion("basicpricingvalue1 not like", value, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1In(List<String> values) {
            addCriterion("basicpricingvalue1 in", values, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1NotIn(List<String> values) {
            addCriterion("basicpricingvalue1 not in", values, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1Between(String value1, String value2) {
            addCriterion("basicpricingvalue1 between", value1, value2, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue1NotBetween(String value1, String value2) {
            addCriterion("basicpricingvalue1 not between", value1, value2, "basicpricingvalue1");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2IsNull() {
            addCriterion("basicpricingname2 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2IsNotNull() {
            addCriterion("basicpricingname2 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2EqualTo(String value) {
            addCriterion("basicpricingname2 =", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2NotEqualTo(String value) {
            addCriterion("basicpricingname2 <>", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2GreaterThan(String value) {
            addCriterion("basicpricingname2 >", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingname2 >=", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2LessThan(String value) {
            addCriterion("basicpricingname2 <", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2LessThanOrEqualTo(String value) {
            addCriterion("basicpricingname2 <=", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2Like(String value) {
            addCriterion("basicpricingname2 like", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2NotLike(String value) {
            addCriterion("basicpricingname2 not like", value, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2In(List<String> values) {
            addCriterion("basicpricingname2 in", values, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2NotIn(List<String> values) {
            addCriterion("basicpricingname2 not in", values, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2Between(String value1, String value2) {
            addCriterion("basicpricingname2 between", value1, value2, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname2NotBetween(String value1, String value2) {
            addCriterion("basicpricingname2 not between", value1, value2, "basicpricingname2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2IsNull() {
            addCriterion("basicpricingvalue2 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2IsNotNull() {
            addCriterion("basicpricingvalue2 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2EqualTo(String value) {
            addCriterion("basicpricingvalue2 =", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2NotEqualTo(String value) {
            addCriterion("basicpricingvalue2 <>", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2GreaterThan(String value) {
            addCriterion("basicpricingvalue2 >", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue2 >=", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2LessThan(String value) {
            addCriterion("basicpricingvalue2 <", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2LessThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue2 <=", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2Like(String value) {
            addCriterion("basicpricingvalue2 like", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2NotLike(String value) {
            addCriterion("basicpricingvalue2 not like", value, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2In(List<String> values) {
            addCriterion("basicpricingvalue2 in", values, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2NotIn(List<String> values) {
            addCriterion("basicpricingvalue2 not in", values, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2Between(String value1, String value2) {
            addCriterion("basicpricingvalue2 between", value1, value2, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue2NotBetween(String value1, String value2) {
            addCriterion("basicpricingvalue2 not between", value1, value2, "basicpricingvalue2");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3IsNull() {
            addCriterion("basicpricingname3 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3IsNotNull() {
            addCriterion("basicpricingname3 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3EqualTo(String value) {
            addCriterion("basicpricingname3 =", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3NotEqualTo(String value) {
            addCriterion("basicpricingname3 <>", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3GreaterThan(String value) {
            addCriterion("basicpricingname3 >", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingname3 >=", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3LessThan(String value) {
            addCriterion("basicpricingname3 <", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3LessThanOrEqualTo(String value) {
            addCriterion("basicpricingname3 <=", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3Like(String value) {
            addCriterion("basicpricingname3 like", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3NotLike(String value) {
            addCriterion("basicpricingname3 not like", value, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3In(List<String> values) {
            addCriterion("basicpricingname3 in", values, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3NotIn(List<String> values) {
            addCriterion("basicpricingname3 not in", values, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3Between(String value1, String value2) {
            addCriterion("basicpricingname3 between", value1, value2, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingname3NotBetween(String value1, String value2) {
            addCriterion("basicpricingname3 not between", value1, value2, "basicpricingname3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3IsNull() {
            addCriterion("basicpricingvalue3 is null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3IsNotNull() {
            addCriterion("basicpricingvalue3 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3EqualTo(String value) {
            addCriterion("basicpricingvalue3 =", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3NotEqualTo(String value) {
            addCriterion("basicpricingvalue3 <>", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3GreaterThan(String value) {
            addCriterion("basicpricingvalue3 >", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3GreaterThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue3 >=", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3LessThan(String value) {
            addCriterion("basicpricingvalue3 <", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3LessThanOrEqualTo(String value) {
            addCriterion("basicpricingvalue3 <=", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3Like(String value) {
            addCriterion("basicpricingvalue3 like", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3NotLike(String value) {
            addCriterion("basicpricingvalue3 not like", value, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3In(List<String> values) {
            addCriterion("basicpricingvalue3 in", values, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3NotIn(List<String> values) {
            addCriterion("basicpricingvalue3 not in", values, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3Between(String value1, String value2) {
            addCriterion("basicpricingvalue3 between", value1, value2, "basicpricingvalue3");
            return (Criteria) this;
        }

        public Criteria andBasicpricingvalue3NotBetween(String value1, String value2) {
            addCriterion("basicpricingvalue3 not between", value1, value2, "basicpricingvalue3");
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