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

        public Criteria andTasktypeIsNull() {
            addCriterion("tasktype is null");
            return (Criteria) this;
        }

        public Criteria andTasktypeIsNotNull() {
            addCriterion("tasktype is not null");
            return (Criteria) this;
        }

        public Criteria andTasktypeEqualTo(String value) {
            addCriterion("tasktype =", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotEqualTo(String value) {
            addCriterion("tasktype <>", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeGreaterThan(String value) {
            addCriterion("tasktype >", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeGreaterThanOrEqualTo(String value) {
            addCriterion("tasktype >=", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLessThan(String value) {
            addCriterion("tasktype <", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLessThanOrEqualTo(String value) {
            addCriterion("tasktype <=", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeLike(String value) {
            addCriterion("tasktype like", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotLike(String value) {
            addCriterion("tasktype not like", value, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeIn(List<String> values) {
            addCriterion("tasktype in", values, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotIn(List<String> values) {
            addCriterion("tasktype not in", values, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeBetween(String value1, String value2) {
            addCriterion("tasktype between", value1, value2, "tasktype");
            return (Criteria) this;
        }

        public Criteria andTasktypeNotBetween(String value1, String value2) {
            addCriterion("tasktype not between", value1, value2, "tasktype");
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

        public Criteria andTaskurlIsNull() {
            addCriterion("taskurl is null");
            return (Criteria) this;
        }

        public Criteria andTaskurlIsNotNull() {
            addCriterion("taskurl is not null");
            return (Criteria) this;
        }

        public Criteria andTaskurlEqualTo(String value) {
            addCriterion("taskurl =", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlNotEqualTo(String value) {
            addCriterion("taskurl <>", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlGreaterThan(String value) {
            addCriterion("taskurl >", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlGreaterThanOrEqualTo(String value) {
            addCriterion("taskurl >=", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlLessThan(String value) {
            addCriterion("taskurl <", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlLessThanOrEqualTo(String value) {
            addCriterion("taskurl <=", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlLike(String value) {
            addCriterion("taskurl like", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlNotLike(String value) {
            addCriterion("taskurl not like", value, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlIn(List<String> values) {
            addCriterion("taskurl in", values, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlNotIn(List<String> values) {
            addCriterion("taskurl not in", values, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlBetween(String value1, String value2) {
            addCriterion("taskurl between", value1, value2, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTaskurlNotBetween(String value1, String value2) {
            addCriterion("taskurl not between", value1, value2, "taskurl");
            return (Criteria) this;
        }

        public Criteria andTasktitleIsNull() {
            addCriterion("tasktitle is null");
            return (Criteria) this;
        }

        public Criteria andTasktitleIsNotNull() {
            addCriterion("tasktitle is not null");
            return (Criteria) this;
        }

        public Criteria andTasktitleEqualTo(String value) {
            addCriterion("tasktitle =", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotEqualTo(String value) {
            addCriterion("tasktitle <>", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleGreaterThan(String value) {
            addCriterion("tasktitle >", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleGreaterThanOrEqualTo(String value) {
            addCriterion("tasktitle >=", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLessThan(String value) {
            addCriterion("tasktitle <", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLessThanOrEqualTo(String value) {
            addCriterion("tasktitle <=", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLike(String value) {
            addCriterion("tasktitle like", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotLike(String value) {
            addCriterion("tasktitle not like", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleIn(List<String> values) {
            addCriterion("tasktitle in", values, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotIn(List<String> values) {
            addCriterion("tasktitle not in", values, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleBetween(String value1, String value2) {
            addCriterion("tasktitle between", value1, value2, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotBetween(String value1, String value2) {
            addCriterion("tasktitle not between", value1, value2, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleIsNull() {
            addCriterion("taskwirelesstitle is null");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleIsNotNull() {
            addCriterion("taskwirelesstitle is not null");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleEqualTo(String value) {
            addCriterion("taskwirelesstitle =", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleNotEqualTo(String value) {
            addCriterion("taskwirelesstitle <>", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleGreaterThan(String value) {
            addCriterion("taskwirelesstitle >", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleGreaterThanOrEqualTo(String value) {
            addCriterion("taskwirelesstitle >=", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleLessThan(String value) {
            addCriterion("taskwirelesstitle <", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleLessThanOrEqualTo(String value) {
            addCriterion("taskwirelesstitle <=", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleLike(String value) {
            addCriterion("taskwirelesstitle like", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleNotLike(String value) {
            addCriterion("taskwirelesstitle not like", value, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleIn(List<String> values) {
            addCriterion("taskwirelesstitle in", values, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleNotIn(List<String> values) {
            addCriterion("taskwirelesstitle not in", values, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleBetween(String value1, String value2) {
            addCriterion("taskwirelesstitle between", value1, value2, "taskwirelesstitle");
            return (Criteria) this;
        }

        public Criteria andTaskwirelesstitleNotBetween(String value1, String value2) {
            addCriterion("taskwirelesstitle not between", value1, value2, "taskwirelesstitle");
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

        public Criteria andTaskdateIsNull() {
            addCriterion("taskdate is null");
            return (Criteria) this;
        }

        public Criteria andTaskdateIsNotNull() {
            addCriterion("taskdate is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdateEqualTo(String value) {
            addCriterion("taskdate =", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateNotEqualTo(String value) {
            addCriterion("taskdate <>", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateGreaterThan(String value) {
            addCriterion("taskdate >", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateGreaterThanOrEqualTo(String value) {
            addCriterion("taskdate >=", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateLessThan(String value) {
            addCriterion("taskdate <", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateLessThanOrEqualTo(String value) {
            addCriterion("taskdate <=", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateLike(String value) {
            addCriterion("taskdate like", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateNotLike(String value) {
            addCriterion("taskdate not like", value, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateIn(List<String> values) {
            addCriterion("taskdate in", values, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateNotIn(List<String> values) {
            addCriterion("taskdate not in", values, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateBetween(String value1, String value2) {
            addCriterion("taskdate between", value1, value2, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskdateNotBetween(String value1, String value2) {
            addCriterion("taskdate not between", value1, value2, "taskdate");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordIsNull() {
            addCriterion("taskreleasekeyword is null");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordIsNotNull() {
            addCriterion("taskreleasekeyword is not null");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordEqualTo(String value) {
            addCriterion("taskreleasekeyword =", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordNotEqualTo(String value) {
            addCriterion("taskreleasekeyword <>", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordGreaterThan(String value) {
            addCriterion("taskreleasekeyword >", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordGreaterThanOrEqualTo(String value) {
            addCriterion("taskreleasekeyword >=", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordLessThan(String value) {
            addCriterion("taskreleasekeyword <", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordLessThanOrEqualTo(String value) {
            addCriterion("taskreleasekeyword <=", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordLike(String value) {
            addCriterion("taskreleasekeyword like", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordNotLike(String value) {
            addCriterion("taskreleasekeyword not like", value, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordIn(List<String> values) {
            addCriterion("taskreleasekeyword in", values, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordNotIn(List<String> values) {
            addCriterion("taskreleasekeyword not in", values, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordBetween(String value1, String value2) {
            addCriterion("taskreleasekeyword between", value1, value2, "taskreleasekeyword");
            return (Criteria) this;
        }

        public Criteria andTaskreleasekeywordNotBetween(String value1, String value2) {
            addCriterion("taskreleasekeyword not between", value1, value2, "taskreleasekeyword");
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

        public Criteria andFlowcountIsNull() {
            addCriterion("flowcount is null");
            return (Criteria) this;
        }

        public Criteria andFlowcountIsNotNull() {
            addCriterion("flowcount is not null");
            return (Criteria) this;
        }

        public Criteria andFlowcountEqualTo(Integer value) {
            addCriterion("flowcount =", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotEqualTo(Integer value) {
            addCriterion("flowcount <>", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountGreaterThan(Integer value) {
            addCriterion("flowcount >", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowcount >=", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountLessThan(Integer value) {
            addCriterion("flowcount <", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountLessThanOrEqualTo(Integer value) {
            addCriterion("flowcount <=", value, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountIn(List<Integer> values) {
            addCriterion("flowcount in", values, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotIn(List<Integer> values) {
            addCriterion("flowcount not in", values, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountBetween(Integer value1, Integer value2) {
            addCriterion("flowcount between", value1, value2, "flowcount");
            return (Criteria) this;
        }

        public Criteria andFlowcountNotBetween(Integer value1, Integer value2) {
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

        public Criteria andCollectioncountEqualTo(Integer value) {
            addCriterion("Collectioncount =", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotEqualTo(Integer value) {
            addCriterion("Collectioncount <>", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThan(Integer value) {
            addCriterion("Collectioncount >", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Collectioncount >=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThan(Integer value) {
            addCriterion("Collectioncount <", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountLessThanOrEqualTo(Integer value) {
            addCriterion("Collectioncount <=", value, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountIn(List<Integer> values) {
            addCriterion("Collectioncount in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotIn(List<Integer> values) {
            addCriterion("Collectioncount not in", values, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountBetween(Integer value1, Integer value2) {
            addCriterion("Collectioncount between", value1, value2, "collectioncount");
            return (Criteria) this;
        }

        public Criteria andCollectioncountNotBetween(Integer value1, Integer value2) {
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

        public Criteria andShoppingcountEqualTo(Integer value) {
            addCriterion("Shoppingcount =", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotEqualTo(Integer value) {
            addCriterion("Shoppingcount <>", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThan(Integer value) {
            addCriterion("Shoppingcount >", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("Shoppingcount >=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThan(Integer value) {
            addCriterion("Shoppingcount <", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountLessThanOrEqualTo(Integer value) {
            addCriterion("Shoppingcount <=", value, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountIn(List<Integer> values) {
            addCriterion("Shoppingcount in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotIn(List<Integer> values) {
            addCriterion("Shoppingcount not in", values, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountBetween(Integer value1, Integer value2) {
            addCriterion("Shoppingcount between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andShoppingcountNotBetween(Integer value1, Integer value2) {
            addCriterion("Shoppingcount not between", value1, value2, "shoppingcount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountIsNull() {
            addCriterion("storecollectioncount is null");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountIsNotNull() {
            addCriterion("storecollectioncount is not null");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountEqualTo(Integer value) {
            addCriterion("storecollectioncount =", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountNotEqualTo(Integer value) {
            addCriterion("storecollectioncount <>", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountGreaterThan(Integer value) {
            addCriterion("storecollectioncount >", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountGreaterThanOrEqualTo(Integer value) {
            addCriterion("storecollectioncount >=", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountLessThan(Integer value) {
            addCriterion("storecollectioncount <", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountLessThanOrEqualTo(Integer value) {
            addCriterion("storecollectioncount <=", value, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountIn(List<Integer> values) {
            addCriterion("storecollectioncount in", values, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountNotIn(List<Integer> values) {
            addCriterion("storecollectioncount not in", values, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountBetween(Integer value1, Integer value2) {
            addCriterion("storecollectioncount between", value1, value2, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andStorecollectioncountNotBetween(Integer value1, Integer value2) {
            addCriterion("storecollectioncount not between", value1, value2, "storecollectioncount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountIsNull() {
            addCriterion("fakechatcount is null");
            return (Criteria) this;
        }

        public Criteria andFakechatcountIsNotNull() {
            addCriterion("fakechatcount is not null");
            return (Criteria) this;
        }

        public Criteria andFakechatcountEqualTo(Integer value) {
            addCriterion("fakechatcount =", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountNotEqualTo(Integer value) {
            addCriterion("fakechatcount <>", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountGreaterThan(Integer value) {
            addCriterion("fakechatcount >", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fakechatcount >=", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountLessThan(Integer value) {
            addCriterion("fakechatcount <", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountLessThanOrEqualTo(Integer value) {
            addCriterion("fakechatcount <=", value, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountIn(List<Integer> values) {
            addCriterion("fakechatcount in", values, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountNotIn(List<Integer> values) {
            addCriterion("fakechatcount not in", values, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountBetween(Integer value1, Integer value2) {
            addCriterion("fakechatcount between", value1, value2, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatcountNotBetween(Integer value1, Integer value2) {
            addCriterion("fakechatcount not between", value1, value2, "fakechatcount");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1IsNull() {
            addCriterion("fakechatstr1 is null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1IsNotNull() {
            addCriterion("fakechatstr1 is not null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1EqualTo(String value) {
            addCriterion("fakechatstr1 =", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1NotEqualTo(String value) {
            addCriterion("fakechatstr1 <>", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1GreaterThan(String value) {
            addCriterion("fakechatstr1 >", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1GreaterThanOrEqualTo(String value) {
            addCriterion("fakechatstr1 >=", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1LessThan(String value) {
            addCriterion("fakechatstr1 <", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1LessThanOrEqualTo(String value) {
            addCriterion("fakechatstr1 <=", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1Like(String value) {
            addCriterion("fakechatstr1 like", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1NotLike(String value) {
            addCriterion("fakechatstr1 not like", value, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1In(List<String> values) {
            addCriterion("fakechatstr1 in", values, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1NotIn(List<String> values) {
            addCriterion("fakechatstr1 not in", values, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1Between(String value1, String value2) {
            addCriterion("fakechatstr1 between", value1, value2, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr1NotBetween(String value1, String value2) {
            addCriterion("fakechatstr1 not between", value1, value2, "fakechatstr1");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2IsNull() {
            addCriterion("fakechatstr2 is null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2IsNotNull() {
            addCriterion("fakechatstr2 is not null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2EqualTo(String value) {
            addCriterion("fakechatstr2 =", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2NotEqualTo(String value) {
            addCriterion("fakechatstr2 <>", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2GreaterThan(String value) {
            addCriterion("fakechatstr2 >", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2GreaterThanOrEqualTo(String value) {
            addCriterion("fakechatstr2 >=", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2LessThan(String value) {
            addCriterion("fakechatstr2 <", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2LessThanOrEqualTo(String value) {
            addCriterion("fakechatstr2 <=", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2Like(String value) {
            addCriterion("fakechatstr2 like", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2NotLike(String value) {
            addCriterion("fakechatstr2 not like", value, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2In(List<String> values) {
            addCriterion("fakechatstr2 in", values, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2NotIn(List<String> values) {
            addCriterion("fakechatstr2 not in", values, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2Between(String value1, String value2) {
            addCriterion("fakechatstr2 between", value1, value2, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr2NotBetween(String value1, String value2) {
            addCriterion("fakechatstr2 not between", value1, value2, "fakechatstr2");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3IsNull() {
            addCriterion("fakechatstr3 is null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3IsNotNull() {
            addCriterion("fakechatstr3 is not null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3EqualTo(String value) {
            addCriterion("fakechatstr3 =", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3NotEqualTo(String value) {
            addCriterion("fakechatstr3 <>", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3GreaterThan(String value) {
            addCriterion("fakechatstr3 >", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3GreaterThanOrEqualTo(String value) {
            addCriterion("fakechatstr3 >=", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3LessThan(String value) {
            addCriterion("fakechatstr3 <", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3LessThanOrEqualTo(String value) {
            addCriterion("fakechatstr3 <=", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3Like(String value) {
            addCriterion("fakechatstr3 like", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3NotLike(String value) {
            addCriterion("fakechatstr3 not like", value, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3In(List<String> values) {
            addCriterion("fakechatstr3 in", values, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3NotIn(List<String> values) {
            addCriterion("fakechatstr3 not in", values, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3Between(String value1, String value2) {
            addCriterion("fakechatstr3 between", value1, value2, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr3NotBetween(String value1, String value2) {
            addCriterion("fakechatstr3 not between", value1, value2, "fakechatstr3");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4IsNull() {
            addCriterion("fakechatstr4 is null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4IsNotNull() {
            addCriterion("fakechatstr4 is not null");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4EqualTo(String value) {
            addCriterion("fakechatstr4 =", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4NotEqualTo(String value) {
            addCriterion("fakechatstr4 <>", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4GreaterThan(String value) {
            addCriterion("fakechatstr4 >", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4GreaterThanOrEqualTo(String value) {
            addCriterion("fakechatstr4 >=", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4LessThan(String value) {
            addCriterion("fakechatstr4 <", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4LessThanOrEqualTo(String value) {
            addCriterion("fakechatstr4 <=", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4Like(String value) {
            addCriterion("fakechatstr4 like", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4NotLike(String value) {
            addCriterion("fakechatstr4 not like", value, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4In(List<String> values) {
            addCriterion("fakechatstr4 in", values, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4NotIn(List<String> values) {
            addCriterion("fakechatstr4 not in", values, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4Between(String value1, String value2) {
            addCriterion("fakechatstr4 between", value1, value2, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andFakechatstr4NotBetween(String value1, String value2) {
            addCriterion("fakechatstr4 not between", value1, value2, "fakechatstr4");
            return (Criteria) this;
        }

        public Criteria andDeepclickIsNull() {
            addCriterion("deepclick is null");
            return (Criteria) this;
        }

        public Criteria andDeepclickIsNotNull() {
            addCriterion("deepclick is not null");
            return (Criteria) this;
        }

        public Criteria andDeepclickEqualTo(String value) {
            addCriterion("deepclick =", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickNotEqualTo(String value) {
            addCriterion("deepclick <>", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickGreaterThan(String value) {
            addCriterion("deepclick >", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickGreaterThanOrEqualTo(String value) {
            addCriterion("deepclick >=", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickLessThan(String value) {
            addCriterion("deepclick <", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickLessThanOrEqualTo(String value) {
            addCriterion("deepclick <=", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickLike(String value) {
            addCriterion("deepclick like", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickNotLike(String value) {
            addCriterion("deepclick not like", value, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickIn(List<String> values) {
            addCriterion("deepclick in", values, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickNotIn(List<String> values) {
            addCriterion("deepclick not in", values, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickBetween(String value1, String value2) {
            addCriterion("deepclick between", value1, value2, "deepclick");
            return (Criteria) this;
        }

        public Criteria andDeepclickNotBetween(String value1, String value2) {
            addCriterion("deepclick not between", value1, value2, "deepclick");
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

        public Criteria andIscreativetitleIsNull() {
            addCriterion("iscreativetitle is null");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleIsNotNull() {
            addCriterion("iscreativetitle is not null");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleEqualTo(String value) {
            addCriterion("iscreativetitle =", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleNotEqualTo(String value) {
            addCriterion("iscreativetitle <>", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleGreaterThan(String value) {
            addCriterion("iscreativetitle >", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleGreaterThanOrEqualTo(String value) {
            addCriterion("iscreativetitle >=", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleLessThan(String value) {
            addCriterion("iscreativetitle <", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleLessThanOrEqualTo(String value) {
            addCriterion("iscreativetitle <=", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleLike(String value) {
            addCriterion("iscreativetitle like", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleNotLike(String value) {
            addCriterion("iscreativetitle not like", value, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleIn(List<String> values) {
            addCriterion("iscreativetitle in", values, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleNotIn(List<String> values) {
            addCriterion("iscreativetitle not in", values, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleBetween(String value1, String value2) {
            addCriterion("iscreativetitle between", value1, value2, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andIscreativetitleNotBetween(String value1, String value2) {
            addCriterion("iscreativetitle not between", value1, value2, "iscreativetitle");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsIsNull() {
            addCriterion("subtractpoints is null");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsIsNotNull() {
            addCriterion("subtractpoints is not null");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsEqualTo(Integer value) {
            addCriterion("subtractpoints =", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsNotEqualTo(Integer value) {
            addCriterion("subtractpoints <>", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsGreaterThan(Integer value) {
            addCriterion("subtractpoints >", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("subtractpoints >=", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsLessThan(Integer value) {
            addCriterion("subtractpoints <", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsLessThanOrEqualTo(Integer value) {
            addCriterion("subtractpoints <=", value, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsIn(List<Integer> values) {
            addCriterion("subtractpoints in", values, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsNotIn(List<Integer> values) {
            addCriterion("subtractpoints not in", values, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsBetween(Integer value1, Integer value2) {
            addCriterion("subtractpoints between", value1, value2, "subtractpoints");
            return (Criteria) this;
        }

        public Criteria andSubtractpointsNotBetween(Integer value1, Integer value2) {
            addCriterion("subtractpoints not between", value1, value2, "subtractpoints");
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