package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TDatacountInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDatacountInfoExample() {
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

        public Criteria andDatacountpkIsNull() {
            addCriterion("datacountpk is null");
            return (Criteria) this;
        }

        public Criteria andDatacountpkIsNotNull() {
            addCriterion("datacountpk is not null");
            return (Criteria) this;
        }

        public Criteria andDatacountpkEqualTo(Integer value) {
            addCriterion("datacountpk =", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkNotEqualTo(Integer value) {
            addCriterion("datacountpk <>", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkGreaterThan(Integer value) {
            addCriterion("datacountpk >", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("datacountpk >=", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkLessThan(Integer value) {
            addCriterion("datacountpk <", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkLessThanOrEqualTo(Integer value) {
            addCriterion("datacountpk <=", value, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkIn(List<Integer> values) {
            addCriterion("datacountpk in", values, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkNotIn(List<Integer> values) {
            addCriterion("datacountpk not in", values, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkBetween(Integer value1, Integer value2) {
            addCriterion("datacountpk between", value1, value2, "datacountpk");
            return (Criteria) this;
        }

        public Criteria andDatacountpkNotBetween(Integer value1, Integer value2) {
            addCriterion("datacountpk not between", value1, value2, "datacountpk");
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andFinishcountIsNull() {
            addCriterion("finishcount is null");
            return (Criteria) this;
        }

        public Criteria andFinishcountIsNotNull() {
            addCriterion("finishcount is not null");
            return (Criteria) this;
        }

        public Criteria andFinishcountEqualTo(String value) {
            addCriterion("finishcount =", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountNotEqualTo(String value) {
            addCriterion("finishcount <>", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountGreaterThan(String value) {
            addCriterion("finishcount >", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountGreaterThanOrEqualTo(String value) {
            addCriterion("finishcount >=", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountLessThan(String value) {
            addCriterion("finishcount <", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountLessThanOrEqualTo(String value) {
            addCriterion("finishcount <=", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountLike(String value) {
            addCriterion("finishcount like", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountNotLike(String value) {
            addCriterion("finishcount not like", value, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountIn(List<String> values) {
            addCriterion("finishcount in", values, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountNotIn(List<String> values) {
            addCriterion("finishcount not in", values, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountBetween(String value1, String value2) {
            addCriterion("finishcount between", value1, value2, "finishcount");
            return (Criteria) this;
        }

        public Criteria andFinishcountNotBetween(String value1, String value2) {
            addCriterion("finishcount not between", value1, value2, "finishcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIsNull() {
            addCriterion("shoppingcount is null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIsNotNull() {
            addCriterion("shoppingcount is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountEqualTo(String value) {
            addCriterion("shoppingcount =", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotEqualTo(String value) {
            addCriterion("shoppingcount <>", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThan(String value) {
            addCriterion("shoppingcount >", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThanOrEqualTo(String value) {
            addCriterion("shoppingcount >=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThan(String value) {
            addCriterion("shoppingcount <", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThanOrEqualTo(String value) {
            addCriterion("shoppingcount <=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLike(String value) {
            addCriterion("shoppingcount like", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotLike(String value) {
            addCriterion("shoppingcount not like", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIn(List<String> values) {
            addCriterion("shoppingcount in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotIn(List<String> values) {
            addCriterion("shoppingcount not in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountBetween(String value1, String value2) {
            addCriterion("shoppingcount between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotBetween(String value1, String value2) {
            addCriterion("shoppingcount not between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIsNull() {
            addCriterion("collectioncount is null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIsNotNull() {
            addCriterion("collectioncount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountEqualTo(String value) {
            addCriterion("collectioncount =", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotEqualTo(String value) {
            addCriterion("collectioncount <>", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThan(String value) {
            addCriterion("collectioncount >", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThanOrEqualTo(String value) {
            addCriterion("collectioncount >=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThan(String value) {
            addCriterion("collectioncount <", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThanOrEqualTo(String value) {
            addCriterion("collectioncount <=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLike(String value) {
            addCriterion("collectioncount like", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotLike(String value) {
            addCriterion("collectioncount not like", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIn(List<String> values) {
            addCriterion("collectioncount in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotIn(List<String> values) {
            addCriterion("collectioncount not in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountBetween(String value1, String value2) {
            addCriterion("collectioncount between", value1, value2, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotBetween(String value1, String value2) {
            addCriterion("collectioncount not between", value1, value2, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andZtccountIsNull() {
            addCriterion("ztccount is null");
            return (Criteria) this;
        }

        public Criteria andZtccountIsNotNull() {
            addCriterion("ztccount is not null");
            return (Criteria) this;
        }

        public Criteria andZtccountEqualTo(String value) {
            addCriterion("ztccount =", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountNotEqualTo(String value) {
            addCriterion("ztccount <>", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountGreaterThan(String value) {
            addCriterion("ztccount >", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountGreaterThanOrEqualTo(String value) {
            addCriterion("ztccount >=", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountLessThan(String value) {
            addCriterion("ztccount <", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountLessThanOrEqualTo(String value) {
            addCriterion("ztccount <=", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountLike(String value) {
            addCriterion("ztccount like", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountNotLike(String value) {
            addCriterion("ztccount not like", value, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountIn(List<String> values) {
            addCriterion("ztccount in", values, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountNotIn(List<String> values) {
            addCriterion("ztccount not in", values, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountBetween(String value1, String value2) {
            addCriterion("ztccount between", value1, value2, "ztccount");
            return (Criteria) this;
        }

        public Criteria andZtccountNotBetween(String value1, String value2) {
            addCriterion("ztccount not between", value1, value2, "ztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountIsNull() {
            addCriterion("shoppingztccount is null");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountIsNotNull() {
            addCriterion("shoppingztccount is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountEqualTo(String value) {
            addCriterion("shoppingztccount =", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountNotEqualTo(String value) {
            addCriterion("shoppingztccount <>", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountGreaterThan(String value) {
            addCriterion("shoppingztccount >", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountGreaterThanOrEqualTo(String value) {
            addCriterion("shoppingztccount >=", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountLessThan(String value) {
            addCriterion("shoppingztccount <", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountLessThanOrEqualTo(String value) {
            addCriterion("shoppingztccount <=", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountLike(String value) {
            addCriterion("shoppingztccount like", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountNotLike(String value) {
            addCriterion("shoppingztccount not like", value, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountIn(List<String> values) {
            addCriterion("shoppingztccount in", values, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountNotIn(List<String> values) {
            addCriterion("shoppingztccount not in", values, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountBetween(String value1, String value2) {
            addCriterion("shoppingztccount between", value1, value2, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andShoppingztccountNotBetween(String value1, String value2) {
            addCriterion("shoppingztccount not between", value1, value2, "shoppingztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountIsNull() {
            addCriterion("collectionztccount is null");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountIsNotNull() {
            addCriterion("collectionztccount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountEqualTo(String value) {
            addCriterion("collectionztccount =", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountNotEqualTo(String value) {
            addCriterion("collectionztccount <>", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountGreaterThan(String value) {
            addCriterion("collectionztccount >", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountGreaterThanOrEqualTo(String value) {
            addCriterion("collectionztccount >=", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountLessThan(String value) {
            addCriterion("collectionztccount <", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountLessThanOrEqualTo(String value) {
            addCriterion("collectionztccount <=", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountLike(String value) {
            addCriterion("collectionztccount like", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountNotLike(String value) {
            addCriterion("collectionztccount not like", value, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountIn(List<String> values) {
            addCriterion("collectionztccount in", values, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountNotIn(List<String> values) {
            addCriterion("collectionztccount not in", values, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountBetween(String value1, String value2) {
            addCriterion("collectionztccount between", value1, value2, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andCollectionztccountNotBetween(String value1, String value2) {
            addCriterion("collectionztccount not between", value1, value2, "collectionztccount");
            return (Criteria) this;
        }

        public Criteria andBuypointsIsNull() {
            addCriterion("buypoints is null");
            return (Criteria) this;
        }

        public Criteria andBuypointsIsNotNull() {
            addCriterion("buypoints is not null");
            return (Criteria) this;
        }

        public Criteria andBuypointsEqualTo(String value) {
            addCriterion("buypoints =", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsNotEqualTo(String value) {
            addCriterion("buypoints <>", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsGreaterThan(String value) {
            addCriterion("buypoints >", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsGreaterThanOrEqualTo(String value) {
            addCriterion("buypoints >=", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsLessThan(String value) {
            addCriterion("buypoints <", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsLessThanOrEqualTo(String value) {
            addCriterion("buypoints <=", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsLike(String value) {
            addCriterion("buypoints like", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsNotLike(String value) {
            addCriterion("buypoints not like", value, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsIn(List<String> values) {
            addCriterion("buypoints in", values, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsNotIn(List<String> values) {
            addCriterion("buypoints not in", values, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsBetween(String value1, String value2) {
            addCriterion("buypoints between", value1, value2, "buypoints");
            return (Criteria) this;
        }

        public Criteria andBuypointsNotBetween(String value1, String value2) {
            addCriterion("buypoints not between", value1, value2, "buypoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsIsNull() {
            addCriterion("expendpoints is null");
            return (Criteria) this;
        }

        public Criteria andExpendpointsIsNotNull() {
            addCriterion("expendpoints is not null");
            return (Criteria) this;
        }

        public Criteria andExpendpointsEqualTo(String value) {
            addCriterion("expendpoints =", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsNotEqualTo(String value) {
            addCriterion("expendpoints <>", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsGreaterThan(String value) {
            addCriterion("expendpoints >", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsGreaterThanOrEqualTo(String value) {
            addCriterion("expendpoints >=", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsLessThan(String value) {
            addCriterion("expendpoints <", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsLessThanOrEqualTo(String value) {
            addCriterion("expendpoints <=", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsLike(String value) {
            addCriterion("expendpoints like", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsNotLike(String value) {
            addCriterion("expendpoints not like", value, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsIn(List<String> values) {
            addCriterion("expendpoints in", values, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsNotIn(List<String> values) {
            addCriterion("expendpoints not in", values, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsBetween(String value1, String value2) {
            addCriterion("expendpoints between", value1, value2, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andExpendpointsNotBetween(String value1, String value2) {
            addCriterion("expendpoints not between", value1, value2, "expendpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsIsNull() {
            addCriterion("handworkpoints is null");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsIsNotNull() {
            addCriterion("handworkpoints is not null");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsEqualTo(String value) {
            addCriterion("handworkpoints =", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsNotEqualTo(String value) {
            addCriterion("handworkpoints <>", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsGreaterThan(String value) {
            addCriterion("handworkpoints >", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsGreaterThanOrEqualTo(String value) {
            addCriterion("handworkpoints >=", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsLessThan(String value) {
            addCriterion("handworkpoints <", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsLessThanOrEqualTo(String value) {
            addCriterion("handworkpoints <=", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsLike(String value) {
            addCriterion("handworkpoints like", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsNotLike(String value) {
            addCriterion("handworkpoints not like", value, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsIn(List<String> values) {
            addCriterion("handworkpoints in", values, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsNotIn(List<String> values) {
            addCriterion("handworkpoints not in", values, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsBetween(String value1, String value2) {
            addCriterion("handworkpoints between", value1, value2, "handworkpoints");
            return (Criteria) this;
        }

        public Criteria andHandworkpointsNotBetween(String value1, String value2) {
            addCriterion("handworkpoints not between", value1, value2, "handworkpoints");
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