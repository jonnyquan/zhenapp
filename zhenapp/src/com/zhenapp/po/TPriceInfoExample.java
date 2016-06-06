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

        public Criteria andPricetype1IsNull() {
            addCriterion("pricetype1 is null");
            return (Criteria) this;
        }

        public Criteria andPricetype1IsNotNull() {
            addCriterion("pricetype1 is not null");
            return (Criteria) this;
        }

        public Criteria andPricetype1EqualTo(String value) {
            addCriterion("pricetype1 =", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1NotEqualTo(String value) {
            addCriterion("pricetype1 <>", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1GreaterThan(String value) {
            addCriterion("pricetype1 >", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1GreaterThanOrEqualTo(String value) {
            addCriterion("pricetype1 >=", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1LessThan(String value) {
            addCriterion("pricetype1 <", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1LessThanOrEqualTo(String value) {
            addCriterion("pricetype1 <=", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1Like(String value) {
            addCriterion("pricetype1 like", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1NotLike(String value) {
            addCriterion("pricetype1 not like", value, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1In(List<String> values) {
            addCriterion("pricetype1 in", values, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1NotIn(List<String> values) {
            addCriterion("pricetype1 not in", values, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1Between(String value1, String value2) {
            addCriterion("pricetype1 between", value1, value2, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricetype1NotBetween(String value1, String value2) {
            addCriterion("pricetype1 not between", value1, value2, "pricetype1");
            return (Criteria) this;
        }

        public Criteria andPricecode1IsNull() {
            addCriterion("pricecode1 is null");
            return (Criteria) this;
        }

        public Criteria andPricecode1IsNotNull() {
            addCriterion("pricecode1 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecode1EqualTo(String value) {
            addCriterion("pricecode1 =", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1NotEqualTo(String value) {
            addCriterion("pricecode1 <>", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1GreaterThan(String value) {
            addCriterion("pricecode1 >", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1GreaterThanOrEqualTo(String value) {
            addCriterion("pricecode1 >=", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1LessThan(String value) {
            addCriterion("pricecode1 <", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1LessThanOrEqualTo(String value) {
            addCriterion("pricecode1 <=", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1Like(String value) {
            addCriterion("pricecode1 like", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1NotLike(String value) {
            addCriterion("pricecode1 not like", value, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1In(List<String> values) {
            addCriterion("pricecode1 in", values, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1NotIn(List<String> values) {
            addCriterion("pricecode1 not in", values, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1Between(String value1, String value2) {
            addCriterion("pricecode1 between", value1, value2, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecode1NotBetween(String value1, String value2) {
            addCriterion("pricecode1 not between", value1, value2, "pricecode1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1IsNull() {
            addCriterion("pricecounts1 is null");
            return (Criteria) this;
        }

        public Criteria andPricecounts1IsNotNull() {
            addCriterion("pricecounts1 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecounts1EqualTo(String value) {
            addCriterion("pricecounts1 =", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1NotEqualTo(String value) {
            addCriterion("pricecounts1 <>", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1GreaterThan(String value) {
            addCriterion("pricecounts1 >", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1GreaterThanOrEqualTo(String value) {
            addCriterion("pricecounts1 >=", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1LessThan(String value) {
            addCriterion("pricecounts1 <", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1LessThanOrEqualTo(String value) {
            addCriterion("pricecounts1 <=", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1Like(String value) {
            addCriterion("pricecounts1 like", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1NotLike(String value) {
            addCriterion("pricecounts1 not like", value, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1In(List<String> values) {
            addCriterion("pricecounts1 in", values, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1NotIn(List<String> values) {
            addCriterion("pricecounts1 not in", values, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1Between(String value1, String value2) {
            addCriterion("pricecounts1 between", value1, value2, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricecounts1NotBetween(String value1, String value2) {
            addCriterion("pricecounts1 not between", value1, value2, "pricecounts1");
            return (Criteria) this;
        }

        public Criteria andPricetype2IsNull() {
            addCriterion("pricetype2 is null");
            return (Criteria) this;
        }

        public Criteria andPricetype2IsNotNull() {
            addCriterion("pricetype2 is not null");
            return (Criteria) this;
        }

        public Criteria andPricetype2EqualTo(String value) {
            addCriterion("pricetype2 =", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2NotEqualTo(String value) {
            addCriterion("pricetype2 <>", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2GreaterThan(String value) {
            addCriterion("pricetype2 >", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2GreaterThanOrEqualTo(String value) {
            addCriterion("pricetype2 >=", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2LessThan(String value) {
            addCriterion("pricetype2 <", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2LessThanOrEqualTo(String value) {
            addCriterion("pricetype2 <=", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2Like(String value) {
            addCriterion("pricetype2 like", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2NotLike(String value) {
            addCriterion("pricetype2 not like", value, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2In(List<String> values) {
            addCriterion("pricetype2 in", values, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2NotIn(List<String> values) {
            addCriterion("pricetype2 not in", values, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2Between(String value1, String value2) {
            addCriterion("pricetype2 between", value1, value2, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricetype2NotBetween(String value1, String value2) {
            addCriterion("pricetype2 not between", value1, value2, "pricetype2");
            return (Criteria) this;
        }

        public Criteria andPricecode2IsNull() {
            addCriterion("pricecode2 is null");
            return (Criteria) this;
        }

        public Criteria andPricecode2IsNotNull() {
            addCriterion("pricecode2 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecode2EqualTo(String value) {
            addCriterion("pricecode2 =", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2NotEqualTo(String value) {
            addCriterion("pricecode2 <>", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2GreaterThan(String value) {
            addCriterion("pricecode2 >", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2GreaterThanOrEqualTo(String value) {
            addCriterion("pricecode2 >=", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2LessThan(String value) {
            addCriterion("pricecode2 <", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2LessThanOrEqualTo(String value) {
            addCriterion("pricecode2 <=", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2Like(String value) {
            addCriterion("pricecode2 like", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2NotLike(String value) {
            addCriterion("pricecode2 not like", value, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2In(List<String> values) {
            addCriterion("pricecode2 in", values, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2NotIn(List<String> values) {
            addCriterion("pricecode2 not in", values, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2Between(String value1, String value2) {
            addCriterion("pricecode2 between", value1, value2, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecode2NotBetween(String value1, String value2) {
            addCriterion("pricecode2 not between", value1, value2, "pricecode2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2IsNull() {
            addCriterion("pricecounts2 is null");
            return (Criteria) this;
        }

        public Criteria andPricecounts2IsNotNull() {
            addCriterion("pricecounts2 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecounts2EqualTo(String value) {
            addCriterion("pricecounts2 =", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2NotEqualTo(String value) {
            addCriterion("pricecounts2 <>", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2GreaterThan(String value) {
            addCriterion("pricecounts2 >", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2GreaterThanOrEqualTo(String value) {
            addCriterion("pricecounts2 >=", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2LessThan(String value) {
            addCriterion("pricecounts2 <", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2LessThanOrEqualTo(String value) {
            addCriterion("pricecounts2 <=", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2Like(String value) {
            addCriterion("pricecounts2 like", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2NotLike(String value) {
            addCriterion("pricecounts2 not like", value, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2In(List<String> values) {
            addCriterion("pricecounts2 in", values, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2NotIn(List<String> values) {
            addCriterion("pricecounts2 not in", values, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2Between(String value1, String value2) {
            addCriterion("pricecounts2 between", value1, value2, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricecounts2NotBetween(String value1, String value2) {
            addCriterion("pricecounts2 not between", value1, value2, "pricecounts2");
            return (Criteria) this;
        }

        public Criteria andPricetype3IsNull() {
            addCriterion("pricetype3 is null");
            return (Criteria) this;
        }

        public Criteria andPricetype3IsNotNull() {
            addCriterion("pricetype3 is not null");
            return (Criteria) this;
        }

        public Criteria andPricetype3EqualTo(String value) {
            addCriterion("pricetype3 =", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3NotEqualTo(String value) {
            addCriterion("pricetype3 <>", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3GreaterThan(String value) {
            addCriterion("pricetype3 >", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3GreaterThanOrEqualTo(String value) {
            addCriterion("pricetype3 >=", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3LessThan(String value) {
            addCriterion("pricetype3 <", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3LessThanOrEqualTo(String value) {
            addCriterion("pricetype3 <=", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3Like(String value) {
            addCriterion("pricetype3 like", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3NotLike(String value) {
            addCriterion("pricetype3 not like", value, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3In(List<String> values) {
            addCriterion("pricetype3 in", values, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3NotIn(List<String> values) {
            addCriterion("pricetype3 not in", values, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3Between(String value1, String value2) {
            addCriterion("pricetype3 between", value1, value2, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricetype3NotBetween(String value1, String value2) {
            addCriterion("pricetype3 not between", value1, value2, "pricetype3");
            return (Criteria) this;
        }

        public Criteria andPricecode3IsNull() {
            addCriterion("pricecode3 is null");
            return (Criteria) this;
        }

        public Criteria andPricecode3IsNotNull() {
            addCriterion("pricecode3 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecode3EqualTo(String value) {
            addCriterion("pricecode3 =", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3NotEqualTo(String value) {
            addCriterion("pricecode3 <>", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3GreaterThan(String value) {
            addCriterion("pricecode3 >", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3GreaterThanOrEqualTo(String value) {
            addCriterion("pricecode3 >=", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3LessThan(String value) {
            addCriterion("pricecode3 <", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3LessThanOrEqualTo(String value) {
            addCriterion("pricecode3 <=", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3Like(String value) {
            addCriterion("pricecode3 like", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3NotLike(String value) {
            addCriterion("pricecode3 not like", value, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3In(List<String> values) {
            addCriterion("pricecode3 in", values, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3NotIn(List<String> values) {
            addCriterion("pricecode3 not in", values, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3Between(String value1, String value2) {
            addCriterion("pricecode3 between", value1, value2, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecode3NotBetween(String value1, String value2) {
            addCriterion("pricecode3 not between", value1, value2, "pricecode3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3IsNull() {
            addCriterion("pricecounts3 is null");
            return (Criteria) this;
        }

        public Criteria andPricecounts3IsNotNull() {
            addCriterion("pricecounts3 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecounts3EqualTo(String value) {
            addCriterion("pricecounts3 =", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3NotEqualTo(String value) {
            addCriterion("pricecounts3 <>", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3GreaterThan(String value) {
            addCriterion("pricecounts3 >", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3GreaterThanOrEqualTo(String value) {
            addCriterion("pricecounts3 >=", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3LessThan(String value) {
            addCriterion("pricecounts3 <", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3LessThanOrEqualTo(String value) {
            addCriterion("pricecounts3 <=", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3Like(String value) {
            addCriterion("pricecounts3 like", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3NotLike(String value) {
            addCriterion("pricecounts3 not like", value, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3In(List<String> values) {
            addCriterion("pricecounts3 in", values, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3NotIn(List<String> values) {
            addCriterion("pricecounts3 not in", values, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3Between(String value1, String value2) {
            addCriterion("pricecounts3 between", value1, value2, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricecounts3NotBetween(String value1, String value2) {
            addCriterion("pricecounts3 not between", value1, value2, "pricecounts3");
            return (Criteria) this;
        }

        public Criteria andPricetype4IsNull() {
            addCriterion("pricetype4 is null");
            return (Criteria) this;
        }

        public Criteria andPricetype4IsNotNull() {
            addCriterion("pricetype4 is not null");
            return (Criteria) this;
        }

        public Criteria andPricetype4EqualTo(String value) {
            addCriterion("pricetype4 =", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4NotEqualTo(String value) {
            addCriterion("pricetype4 <>", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4GreaterThan(String value) {
            addCriterion("pricetype4 >", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4GreaterThanOrEqualTo(String value) {
            addCriterion("pricetype4 >=", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4LessThan(String value) {
            addCriterion("pricetype4 <", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4LessThanOrEqualTo(String value) {
            addCriterion("pricetype4 <=", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4Like(String value) {
            addCriterion("pricetype4 like", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4NotLike(String value) {
            addCriterion("pricetype4 not like", value, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4In(List<String> values) {
            addCriterion("pricetype4 in", values, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4NotIn(List<String> values) {
            addCriterion("pricetype4 not in", values, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4Between(String value1, String value2) {
            addCriterion("pricetype4 between", value1, value2, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricetype4NotBetween(String value1, String value2) {
            addCriterion("pricetype4 not between", value1, value2, "pricetype4");
            return (Criteria) this;
        }

        public Criteria andPricecode4IsNull() {
            addCriterion("pricecode4 is null");
            return (Criteria) this;
        }

        public Criteria andPricecode4IsNotNull() {
            addCriterion("pricecode4 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecode4EqualTo(String value) {
            addCriterion("pricecode4 =", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4NotEqualTo(String value) {
            addCriterion("pricecode4 <>", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4GreaterThan(String value) {
            addCriterion("pricecode4 >", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4GreaterThanOrEqualTo(String value) {
            addCriterion("pricecode4 >=", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4LessThan(String value) {
            addCriterion("pricecode4 <", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4LessThanOrEqualTo(String value) {
            addCriterion("pricecode4 <=", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4Like(String value) {
            addCriterion("pricecode4 like", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4NotLike(String value) {
            addCriterion("pricecode4 not like", value, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4In(List<String> values) {
            addCriterion("pricecode4 in", values, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4NotIn(List<String> values) {
            addCriterion("pricecode4 not in", values, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4Between(String value1, String value2) {
            addCriterion("pricecode4 between", value1, value2, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecode4NotBetween(String value1, String value2) {
            addCriterion("pricecode4 not between", value1, value2, "pricecode4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4IsNull() {
            addCriterion("pricecounts4 is null");
            return (Criteria) this;
        }

        public Criteria andPricecounts4IsNotNull() {
            addCriterion("pricecounts4 is not null");
            return (Criteria) this;
        }

        public Criteria andPricecounts4EqualTo(String value) {
            addCriterion("pricecounts4 =", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4NotEqualTo(String value) {
            addCriterion("pricecounts4 <>", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4GreaterThan(String value) {
            addCriterion("pricecounts4 >", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4GreaterThanOrEqualTo(String value) {
            addCriterion("pricecounts4 >=", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4LessThan(String value) {
            addCriterion("pricecounts4 <", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4LessThanOrEqualTo(String value) {
            addCriterion("pricecounts4 <=", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4Like(String value) {
            addCriterion("pricecounts4 like", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4NotLike(String value) {
            addCriterion("pricecounts4 not like", value, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4In(List<String> values) {
            addCriterion("pricecounts4 in", values, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4NotIn(List<String> values) {
            addCriterion("pricecounts4 not in", values, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4Between(String value1, String value2) {
            addCriterion("pricecounts4 between", value1, value2, "pricecounts4");
            return (Criteria) this;
        }

        public Criteria andPricecounts4NotBetween(String value1, String value2) {
            addCriterion("pricecounts4 not between", value1, value2, "pricecounts4");
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