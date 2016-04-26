package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TTaskInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskInfoExample() {
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

        public Criteria andTaskpkIsNull() {
            addCriterion("taskpk is null");
            return (Criteria) this;
        }

        public Criteria andTaskpkIsNotNull() {
            addCriterion("taskpk is not null");
            return (Criteria) this;
        }

        public Criteria andTaskpkEqualTo(Integer value) {
            addCriterion("taskpk =", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkNotEqualTo(Integer value) {
            addCriterion("taskpk <>", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkGreaterThan(Integer value) {
            addCriterion("taskpk >", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskpk >=", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkLessThan(Integer value) {
            addCriterion("taskpk <", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkLessThanOrEqualTo(Integer value) {
            addCriterion("taskpk <=", value, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkIn(List<Integer> values) {
            addCriterion("taskpk in", values, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkNotIn(List<Integer> values) {
            addCriterion("taskpk not in", values, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkBetween(Integer value1, Integer value2) {
            addCriterion("taskpk between", value1, value2, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskpkNotBetween(Integer value1, Integer value2) {
            addCriterion("taskpk not between", value1, value2, "taskpk");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(String value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(String value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(String value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(String value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(String value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(String value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLike(String value) {
            addCriterion("taskid like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotLike(String value) {
            addCriterion("taskid not like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<String> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<String> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(String value1, String value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(String value1, String value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("taskname is null");
            return (Criteria) this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("taskname is not null");
            return (Criteria) this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("taskname =", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("taskname <>", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("taskname >", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("taskname >=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("taskname <", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("taskname <=", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("taskname like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("taskname not like", value, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameIn(List<String> values) {
            addCriterion("taskname in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotIn(List<String> values) {
            addCriterion("taskname not in", values, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("taskname between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("taskname not between", value1, value2, "taskname");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordIsNull() {
            addCriterion("taskkeyword is null");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordIsNotNull() {
            addCriterion("taskkeyword is not null");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordEqualTo(String value) {
            addCriterion("taskkeyword =", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordNotEqualTo(String value) {
            addCriterion("taskkeyword <>", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordGreaterThan(String value) {
            addCriterion("taskkeyword >", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordGreaterThanOrEqualTo(String value) {
            addCriterion("taskkeyword >=", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordLessThan(String value) {
            addCriterion("taskkeyword <", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordLessThanOrEqualTo(String value) {
            addCriterion("taskkeyword <=", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordLike(String value) {
            addCriterion("taskkeyword like", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordNotLike(String value) {
            addCriterion("taskkeyword not like", value, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordIn(List<String> values) {
            addCriterion("taskkeyword in", values, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordNotIn(List<String> values) {
            addCriterion("taskkeyword not in", values, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordBetween(String value1, String value2) {
            addCriterion("taskkeyword between", value1, value2, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskkeywordNotBetween(String value1, String value2) {
            addCriterion("taskkeyword not between", value1, value2, "taskkeyword");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlIsNull() {
            addCriterion("taskproducturl is null");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlIsNotNull() {
            addCriterion("taskproducturl is not null");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlEqualTo(String value) {
            addCriterion("taskproducturl =", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlNotEqualTo(String value) {
            addCriterion("taskproducturl <>", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlGreaterThan(String value) {
            addCriterion("taskproducturl >", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlGreaterThanOrEqualTo(String value) {
            addCriterion("taskproducturl >=", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlLessThan(String value) {
            addCriterion("taskproducturl <", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlLessThanOrEqualTo(String value) {
            addCriterion("taskproducturl <=", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlLike(String value) {
            addCriterion("taskproducturl like", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlNotLike(String value) {
            addCriterion("taskproducturl not like", value, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlIn(List<String> values) {
            addCriterion("taskproducturl in", values, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlNotIn(List<String> values) {
            addCriterion("taskproducturl not in", values, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlBetween(String value1, String value2) {
            addCriterion("taskproducturl between", value1, value2, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskproducturlNotBetween(String value1, String value2) {
            addCriterion("taskproducturl not between", value1, value2, "taskproducturl");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateIsNull() {
            addCriterion("taskstartdate is null");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateIsNotNull() {
            addCriterion("taskstartdate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateEqualTo(String value) {
            addCriterion("taskstartdate =", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateNotEqualTo(String value) {
            addCriterion("taskstartdate <>", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateGreaterThan(String value) {
            addCriterion("taskstartdate >", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateGreaterThanOrEqualTo(String value) {
            addCriterion("taskstartdate >=", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateLessThan(String value) {
            addCriterion("taskstartdate <", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateLessThanOrEqualTo(String value) {
            addCriterion("taskstartdate <=", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateLike(String value) {
            addCriterion("taskstartdate like", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateNotLike(String value) {
            addCriterion("taskstartdate not like", value, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateIn(List<String> values) {
            addCriterion("taskstartdate in", values, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateNotIn(List<String> values) {
            addCriterion("taskstartdate not in", values, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateBetween(String value1, String value2) {
            addCriterion("taskstartdate between", value1, value2, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskstartdateNotBetween(String value1, String value2) {
            addCriterion("taskstartdate not between", value1, value2, "taskstartdate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateIsNull() {
            addCriterion("taskenddate is null");
            return (Criteria) this;
        }

        public Criteria andTaskenddateIsNotNull() {
            addCriterion("taskenddate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskenddateEqualTo(String value) {
            addCriterion("taskenddate =", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateNotEqualTo(String value) {
            addCriterion("taskenddate <>", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateGreaterThan(String value) {
            addCriterion("taskenddate >", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateGreaterThanOrEqualTo(String value) {
            addCriterion("taskenddate >=", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateLessThan(String value) {
            addCriterion("taskenddate <", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateLessThanOrEqualTo(String value) {
            addCriterion("taskenddate <=", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateLike(String value) {
            addCriterion("taskenddate like", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateNotLike(String value) {
            addCriterion("taskenddate not like", value, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateIn(List<String> values) {
            addCriterion("taskenddate in", values, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateNotIn(List<String> values) {
            addCriterion("taskenddate not in", values, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateBetween(String value1, String value2) {
            addCriterion("taskenddate between", value1, value2, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskenddateNotBetween(String value1, String value2) {
            addCriterion("taskenddate not between", value1, value2, "taskenddate");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsIsNull() {
            addCriterion("taskhourcounts is null");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsIsNotNull() {
            addCriterion("taskhourcounts is not null");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsEqualTo(String value) {
            addCriterion("taskhourcounts =", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsNotEqualTo(String value) {
            addCriterion("taskhourcounts <>", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsGreaterThan(String value) {
            addCriterion("taskhourcounts >", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsGreaterThanOrEqualTo(String value) {
            addCriterion("taskhourcounts >=", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsLessThan(String value) {
            addCriterion("taskhourcounts <", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsLessThanOrEqualTo(String value) {
            addCriterion("taskhourcounts <=", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsLike(String value) {
            addCriterion("taskhourcounts like", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsNotLike(String value) {
            addCriterion("taskhourcounts not like", value, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsIn(List<String> values) {
            addCriterion("taskhourcounts in", values, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsNotIn(List<String> values) {
            addCriterion("taskhourcounts not in", values, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsBetween(String value1, String value2) {
            addCriterion("taskhourcounts between", value1, value2, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTaskhourcountsNotBetween(String value1, String value2) {
            addCriterion("taskhourcounts not between", value1, value2, "taskhourcounts");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeIsNull() {
            addCriterion("tasksearchType is null");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeIsNotNull() {
            addCriterion("tasksearchType is not null");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeEqualTo(String value) {
            addCriterion("tasksearchType =", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeNotEqualTo(String value) {
            addCriterion("tasksearchType <>", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeGreaterThan(String value) {
            addCriterion("tasksearchType >", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeGreaterThanOrEqualTo(String value) {
            addCriterion("tasksearchType >=", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeLessThan(String value) {
            addCriterion("tasksearchType <", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeLessThanOrEqualTo(String value) {
            addCriterion("tasksearchType <=", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeLike(String value) {
            addCriterion("tasksearchType like", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeNotLike(String value) {
            addCriterion("tasksearchType not like", value, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeIn(List<String> values) {
            addCriterion("tasksearchType in", values, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeNotIn(List<String> values) {
            addCriterion("tasksearchType not in", values, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeBetween(String value1, String value2) {
            addCriterion("tasksearchType between", value1, value2, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTasksearchtypeNotBetween(String value1, String value2) {
            addCriterion("tasksearchType not between", value1, value2, "tasksearchtype");
            return (Criteria) this;
        }

        public Criteria andTaskdurationIsNull() {
            addCriterion("taskduration is null");
            return (Criteria) this;
        }

        public Criteria andTaskdurationIsNotNull() {
            addCriterion("taskduration is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdurationEqualTo(String value) {
            addCriterion("taskduration =", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationNotEqualTo(String value) {
            addCriterion("taskduration <>", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationGreaterThan(String value) {
            addCriterion("taskduration >", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationGreaterThanOrEqualTo(String value) {
            addCriterion("taskduration >=", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationLessThan(String value) {
            addCriterion("taskduration <", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationLessThanOrEqualTo(String value) {
            addCriterion("taskduration <=", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationLike(String value) {
            addCriterion("taskduration like", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationNotLike(String value) {
            addCriterion("taskduration not like", value, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationIn(List<String> values) {
            addCriterion("taskduration in", values, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationNotIn(List<String> values) {
            addCriterion("taskduration not in", values, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationBetween(String value1, String value2) {
            addCriterion("taskduration between", value1, value2, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskdurationNotBetween(String value1, String value2) {
            addCriterion("taskduration not between", value1, value2, "taskduration");
            return (Criteria) this;
        }

        public Criteria andTaskplusIsNull() {
            addCriterion("taskPlus is null");
            return (Criteria) this;
        }

        public Criteria andTaskplusIsNotNull() {
            addCriterion("taskPlus is not null");
            return (Criteria) this;
        }

        public Criteria andTaskplusEqualTo(String value) {
            addCriterion("taskPlus =", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusNotEqualTo(String value) {
            addCriterion("taskPlus <>", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusGreaterThan(String value) {
            addCriterion("taskPlus >", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusGreaterThanOrEqualTo(String value) {
            addCriterion("taskPlus >=", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusLessThan(String value) {
            addCriterion("taskPlus <", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusLessThanOrEqualTo(String value) {
            addCriterion("taskPlus <=", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusLike(String value) {
            addCriterion("taskPlus like", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusNotLike(String value) {
            addCriterion("taskPlus not like", value, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusIn(List<String> values) {
            addCriterion("taskPlus in", values, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusNotIn(List<String> values) {
            addCriterion("taskPlus not in", values, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusBetween(String value1, String value2) {
            addCriterion("taskPlus between", value1, value2, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskplusNotBetween(String value1, String value2) {
            addCriterion("taskPlus not between", value1, value2, "taskplus");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctIsNull() {
            addCriterion("taskgprspct is null");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctIsNotNull() {
            addCriterion("taskgprspct is not null");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctEqualTo(String value) {
            addCriterion("taskgprspct =", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctNotEqualTo(String value) {
            addCriterion("taskgprspct <>", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctGreaterThan(String value) {
            addCriterion("taskgprspct >", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctGreaterThanOrEqualTo(String value) {
            addCriterion("taskgprspct >=", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctLessThan(String value) {
            addCriterion("taskgprspct <", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctLessThanOrEqualTo(String value) {
            addCriterion("taskgprspct <=", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctLike(String value) {
            addCriterion("taskgprspct like", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctNotLike(String value) {
            addCriterion("taskgprspct not like", value, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctIn(List<String> values) {
            addCriterion("taskgprspct in", values, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctNotIn(List<String> values) {
            addCriterion("taskgprspct not in", values, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctBetween(String value1, String value2) {
            addCriterion("taskgprspct between", value1, value2, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTaskgprspctNotBetween(String value1, String value2) {
            addCriterion("taskgprspct not between", value1, value2, "taskgprspct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctIsNull() {
            addCriterion("tasktmallapppct is null");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctIsNotNull() {
            addCriterion("tasktmallapppct is not null");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctEqualTo(String value) {
            addCriterion("tasktmallapppct =", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctNotEqualTo(String value) {
            addCriterion("tasktmallapppct <>", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctGreaterThan(String value) {
            addCriterion("tasktmallapppct >", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctGreaterThanOrEqualTo(String value) {
            addCriterion("tasktmallapppct >=", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctLessThan(String value) {
            addCriterion("tasktmallapppct <", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctLessThanOrEqualTo(String value) {
            addCriterion("tasktmallapppct <=", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctLike(String value) {
            addCriterion("tasktmallapppct like", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctNotLike(String value) {
            addCriterion("tasktmallapppct not like", value, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctIn(List<String> values) {
            addCriterion("tasktmallapppct in", values, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctNotIn(List<String> values) {
            addCriterion("tasktmallapppct not in", values, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctBetween(String value1, String value2) {
            addCriterion("tasktmallapppct between", value1, value2, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTasktmallapppctNotBetween(String value1, String value2) {
            addCriterion("tasktmallapppct not between", value1, value2, "tasktmallapppct");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceIsNull() {
            addCriterion("taskminprice is null");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceIsNotNull() {
            addCriterion("taskminprice is not null");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceEqualTo(String value) {
            addCriterion("taskminprice =", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceNotEqualTo(String value) {
            addCriterion("taskminprice <>", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceGreaterThan(String value) {
            addCriterion("taskminprice >", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceGreaterThanOrEqualTo(String value) {
            addCriterion("taskminprice >=", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceLessThan(String value) {
            addCriterion("taskminprice <", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceLessThanOrEqualTo(String value) {
            addCriterion("taskminprice <=", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceLike(String value) {
            addCriterion("taskminprice like", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceNotLike(String value) {
            addCriterion("taskminprice not like", value, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceIn(List<String> values) {
            addCriterion("taskminprice in", values, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceNotIn(List<String> values) {
            addCriterion("taskminprice not in", values, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceBetween(String value1, String value2) {
            addCriterion("taskminprice between", value1, value2, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskminpriceNotBetween(String value1, String value2) {
            addCriterion("taskminprice not between", value1, value2, "taskminprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceIsNull() {
            addCriterion("taskmaxprice is null");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceIsNotNull() {
            addCriterion("taskmaxprice is not null");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceEqualTo(String value) {
            addCriterion("taskmaxprice =", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceNotEqualTo(String value) {
            addCriterion("taskmaxprice <>", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceGreaterThan(String value) {
            addCriterion("taskmaxprice >", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceGreaterThanOrEqualTo(String value) {
            addCriterion("taskmaxprice >=", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceLessThan(String value) {
            addCriterion("taskmaxprice <", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceLessThanOrEqualTo(String value) {
            addCriterion("taskmaxprice <=", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceLike(String value) {
            addCriterion("taskmaxprice like", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceNotLike(String value) {
            addCriterion("taskmaxprice not like", value, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceIn(List<String> values) {
            addCriterion("taskmaxprice in", values, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceNotIn(List<String> values) {
            addCriterion("taskmaxprice not in", values, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceBetween(String value1, String value2) {
            addCriterion("taskmaxprice between", value1, value2, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskmaxpriceNotBetween(String value1, String value2) {
            addCriterion("taskmaxprice not between", value1, value2, "taskmaxprice");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumIsNull() {
            addCriterion("taskkeynum is null");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumIsNotNull() {
            addCriterion("taskkeynum is not null");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumEqualTo(String value) {
            addCriterion("taskkeynum =", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumNotEqualTo(String value) {
            addCriterion("taskkeynum <>", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumGreaterThan(String value) {
            addCriterion("taskkeynum >", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumGreaterThanOrEqualTo(String value) {
            addCriterion("taskkeynum >=", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumLessThan(String value) {
            addCriterion("taskkeynum <", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumLessThanOrEqualTo(String value) {
            addCriterion("taskkeynum <=", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumLike(String value) {
            addCriterion("taskkeynum like", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumNotLike(String value) {
            addCriterion("taskkeynum not like", value, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumIn(List<String> values) {
            addCriterion("taskkeynum in", values, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumNotIn(List<String> values) {
            addCriterion("taskkeynum not in", values, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumBetween(String value1, String value2) {
            addCriterion("taskkeynum between", value1, value2, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskkeynumNotBetween(String value1, String value2) {
            addCriterion("taskkeynum not between", value1, value2, "taskkeynum");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcIsNull() {
            addCriterion("taskimgztc is null");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcIsNotNull() {
            addCriterion("taskimgztc is not null");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcEqualTo(String value) {
            addCriterion("taskimgztc =", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcNotEqualTo(String value) {
            addCriterion("taskimgztc <>", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcGreaterThan(String value) {
            addCriterion("taskimgztc >", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcGreaterThanOrEqualTo(String value) {
            addCriterion("taskimgztc >=", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcLessThan(String value) {
            addCriterion("taskimgztc <", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcLessThanOrEqualTo(String value) {
            addCriterion("taskimgztc <=", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcLike(String value) {
            addCriterion("taskimgztc like", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcNotLike(String value) {
            addCriterion("taskimgztc not like", value, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcIn(List<String> values) {
            addCriterion("taskimgztc in", values, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcNotIn(List<String> values) {
            addCriterion("taskimgztc not in", values, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcBetween(String value1, String value2) {
            addCriterion("taskimgztc between", value1, value2, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgztcNotBetween(String value1, String value2) {
            addCriterion("taskimgztc not between", value1, value2, "taskimgztc");
            return (Criteria) this;
        }

        public Criteria andTaskimgptIsNull() {
            addCriterion("taskimgpt is null");
            return (Criteria) this;
        }

        public Criteria andTaskimgptIsNotNull() {
            addCriterion("taskimgpt is not null");
            return (Criteria) this;
        }

        public Criteria andTaskimgptEqualTo(String value) {
            addCriterion("taskimgpt =", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptNotEqualTo(String value) {
            addCriterion("taskimgpt <>", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptGreaterThan(String value) {
            addCriterion("taskimgpt >", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptGreaterThanOrEqualTo(String value) {
            addCriterion("taskimgpt >=", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptLessThan(String value) {
            addCriterion("taskimgpt <", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptLessThanOrEqualTo(String value) {
            addCriterion("taskimgpt <=", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptLike(String value) {
            addCriterion("taskimgpt like", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptNotLike(String value) {
            addCriterion("taskimgpt not like", value, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptIn(List<String> values) {
            addCriterion("taskimgpt in", values, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptNotIn(List<String> values) {
            addCriterion("taskimgpt not in", values, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptBetween(String value1, String value2) {
            addCriterion("taskimgpt between", value1, value2, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTaskimgptNotBetween(String value1, String value2) {
            addCriterion("taskimgpt not between", value1, value2, "taskimgpt");
            return (Criteria) this;
        }

        public Criteria andTimecontrolIsNull() {
            addCriterion("timecontrol is null");
            return (Criteria) this;
        }

        public Criteria andTimecontrolIsNotNull() {
            addCriterion("timecontrol is not null");
            return (Criteria) this;
        }

        public Criteria andTimecontrolEqualTo(String value) {
            addCriterion("timecontrol =", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolNotEqualTo(String value) {
            addCriterion("timecontrol <>", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolGreaterThan(String value) {
            addCriterion("timecontrol >", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolGreaterThanOrEqualTo(String value) {
            addCriterion("timecontrol >=", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolLessThan(String value) {
            addCriterion("timecontrol <", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolLessThanOrEqualTo(String value) {
            addCriterion("timecontrol <=", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolLike(String value) {
            addCriterion("timecontrol like", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolNotLike(String value) {
            addCriterion("timecontrol not like", value, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolIn(List<String> values) {
            addCriterion("timecontrol in", values, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolNotIn(List<String> values) {
            addCriterion("timecontrol not in", values, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolBetween(String value1, String value2) {
            addCriterion("timecontrol between", value1, value2, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andTimecontrolNotBetween(String value1, String value2) {
            addCriterion("timecontrol not between", value1, value2, "timecontrol");
            return (Criteria) this;
        }

        public Criteria andFlowcountIsNull() {
            addCriterion("flowcount is null");
            return (Criteria) this;
        }

        public Criteria andFlowcountIsNotNull() {
            addCriterion("flowcount is not null");
            return (Criteria) this;
        }

        public Criteria andFlowcountEqualTo(String value) {
            addCriterion("flowcount =", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotEqualTo(String value) {
            addCriterion("flowcount <>", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountGreaterThan(String value) {
            addCriterion("flowcount >", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountGreaterThanOrEqualTo(String value) {
            addCriterion("flowcount >=", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountLessThan(String value) {
            addCriterion("flowcount <", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountLessThanOrEqualTo(String value) {
            addCriterion("flowcount <=", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountLike(String value) {
            addCriterion("flowcount like", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotLike(String value) {
            addCriterion("flowcount not like", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountIn(List<String> values) {
            addCriterion("flowcount in", values, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotIn(List<String> values) {
            addCriterion("flowcount not in", values, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountBetween(String value1, String value2) {
            addCriterion("flowcount between", value1, value2, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotBetween(String value1, String value2) {
            addCriterion("flowcount not between", value1, value2, "flowcount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIsNull() {
            addCriterion("Collectioncount is null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIsNotNull() {
            addCriterion("Collectioncount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountEqualTo(String value) {
            addCriterion("Collectioncount =", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotEqualTo(String value) {
            addCriterion("Collectioncount <>", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThan(String value) {
            addCriterion("Collectioncount >", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThanOrEqualTo(String value) {
            addCriterion("Collectioncount >=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThan(String value) {
            addCriterion("Collectioncount <", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThanOrEqualTo(String value) {
            addCriterion("Collectioncount <=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLike(String value) {
            addCriterion("Collectioncount like", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotLike(String value) {
            addCriterion("Collectioncount not like", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIn(List<String> values) {
            addCriterion("Collectioncount in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotIn(List<String> values) {
            addCriterion("Collectioncount not in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountBetween(String value1, String value2) {
            addCriterion("Collectioncount between", value1, value2, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotBetween(String value1, String value2) {
            addCriterion("Collectioncount not between", value1, value2, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIsNull() {
            addCriterion("Shoppingcount is null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIsNotNull() {
            addCriterion("Shoppingcount is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountEqualTo(String value) {
            addCriterion("Shoppingcount =", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotEqualTo(String value) {
            addCriterion("Shoppingcount <>", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThan(String value) {
            addCriterion("Shoppingcount >", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThanOrEqualTo(String value) {
            addCriterion("Shoppingcount >=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThan(String value) {
            addCriterion("Shoppingcount <", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThanOrEqualTo(String value) {
            addCriterion("Shoppingcount <=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLike(String value) {
            addCriterion("Shoppingcount like", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotLike(String value) {
            addCriterion("Shoppingcount not like", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIn(List<String> values) {
            addCriterion("Shoppingcount in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotIn(List<String> values) {
            addCriterion("Shoppingcount not in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountBetween(String value1, String value2) {
            addCriterion("Shoppingcount between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotBetween(String value1, String value2) {
            addCriterion("Shoppingcount not between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempIsNull() {
            addCriterion("flowcounttemp is null");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempIsNotNull() {
            addCriterion("flowcounttemp is not null");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempEqualTo(String value) {
            addCriterion("flowcounttemp =", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempNotEqualTo(String value) {
            addCriterion("flowcounttemp <>", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempGreaterThan(String value) {
            addCriterion("flowcounttemp >", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempGreaterThanOrEqualTo(String value) {
            addCriterion("flowcounttemp >=", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempLessThan(String value) {
            addCriterion("flowcounttemp <", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempLessThanOrEqualTo(String value) {
            addCriterion("flowcounttemp <=", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempLike(String value) {
            addCriterion("flowcounttemp like", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempNotLike(String value) {
            addCriterion("flowcounttemp not like", value, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempIn(List<String> values) {
            addCriterion("flowcounttemp in", values, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempNotIn(List<String> values) {
            addCriterion("flowcounttemp not in", values, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempBetween(String value1, String value2) {
            addCriterion("flowcounttemp between", value1, value2, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andFlowcounttempNotBetween(String value1, String value2) {
            addCriterion("flowcounttemp not between", value1, value2, "flowcounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempIsNull() {
            addCriterion("Collectioncounttemp is null");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempIsNotNull() {
            addCriterion("Collectioncounttemp is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempEqualTo(String value) {
            addCriterion("Collectioncounttemp =", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempNotEqualTo(String value) {
            addCriterion("Collectioncounttemp <>", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempGreaterThan(String value) {
            addCriterion("Collectioncounttemp >", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempGreaterThanOrEqualTo(String value) {
            addCriterion("Collectioncounttemp >=", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempLessThan(String value) {
            addCriterion("Collectioncounttemp <", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempLessThanOrEqualTo(String value) {
            addCriterion("Collectioncounttemp <=", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempLike(String value) {
            addCriterion("Collectioncounttemp like", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempNotLike(String value) {
            addCriterion("Collectioncounttemp not like", value, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempIn(List<String> values) {
            addCriterion("Collectioncounttemp in", values, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempNotIn(List<String> values) {
            addCriterion("Collectioncounttemp not in", values, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempBetween(String value1, String value2) {
            addCriterion("Collectioncounttemp between", value1, value2, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andCollectioncounttempNotBetween(String value1, String value2) {
            addCriterion("Collectioncounttemp not between", value1, value2, "collectioncounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempIsNull() {
            addCriterion("Shoppingcounttemp is null");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempIsNotNull() {
            addCriterion("Shoppingcounttemp is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempEqualTo(String value) {
            addCriterion("Shoppingcounttemp =", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempNotEqualTo(String value) {
            addCriterion("Shoppingcounttemp <>", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempGreaterThan(String value) {
            addCriterion("Shoppingcounttemp >", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempGreaterThanOrEqualTo(String value) {
            addCriterion("Shoppingcounttemp >=", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempLessThan(String value) {
            addCriterion("Shoppingcounttemp <", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempLessThanOrEqualTo(String value) {
            addCriterion("Shoppingcounttemp <=", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempLike(String value) {
            addCriterion("Shoppingcounttemp like", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempNotLike(String value) {
            addCriterion("Shoppingcounttemp not like", value, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempIn(List<String> values) {
            addCriterion("Shoppingcounttemp in", values, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempNotIn(List<String> values) {
            addCriterion("Shoppingcounttemp not in", values, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempBetween(String value1, String value2) {
            addCriterion("Shoppingcounttemp between", value1, value2, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andShoppingcounttempNotBetween(String value1, String value2) {
            addCriterion("Shoppingcounttemp not between", value1, value2, "shoppingcounttemp");
            return (Criteria) this;
        }

        public Criteria andTaskstateIsNull() {
            addCriterion("taskstate is null");
            return (Criteria) this;
        }

        public Criteria andTaskstateIsNotNull() {
            addCriterion("taskstate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskstateEqualTo(String value) {
            addCriterion("taskstate =", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateNotEqualTo(String value) {
            addCriterion("taskstate <>", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateGreaterThan(String value) {
            addCriterion("taskstate >", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateGreaterThanOrEqualTo(String value) {
            addCriterion("taskstate >=", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateLessThan(String value) {
            addCriterion("taskstate <", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateLessThanOrEqualTo(String value) {
            addCriterion("taskstate <=", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateLike(String value) {
            addCriterion("taskstate like", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateNotLike(String value) {
            addCriterion("taskstate not like", value, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateIn(List<String> values) {
            addCriterion("taskstate in", values, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateNotIn(List<String> values) {
            addCriterion("taskstate not in", values, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateBetween(String value1, String value2) {
            addCriterion("taskstate between", value1, value2, "taskstate");
            return (Criteria) this;
        }

        public Criteria andTaskstateNotBetween(String value1, String value2) {
            addCriterion("taskstate not between", value1, value2, "taskstate");
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