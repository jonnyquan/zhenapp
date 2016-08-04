package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TTaskInfoQueryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskInfoQueryExample() {
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

        public Criteria andQuerypkIsNull() {
            addCriterion("querypk is null");
            return (Criteria) this;
        }

        public Criteria andQuerypkIsNotNull() {
            addCriterion("querypk is not null");
            return (Criteria) this;
        }

        public Criteria andQuerypkEqualTo(Integer value) {
            addCriterion("querypk =", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkNotEqualTo(Integer value) {
            addCriterion("querypk <>", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkGreaterThan(Integer value) {
            addCriterion("querypk >", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkGreaterThanOrEqualTo(Integer value) {
            addCriterion("querypk >=", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkLessThan(Integer value) {
            addCriterion("querypk <", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkLessThanOrEqualTo(Integer value) {
            addCriterion("querypk <=", value, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkIn(List<Integer> values) {
            addCriterion("querypk in", values, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkNotIn(List<Integer> values) {
            addCriterion("querypk not in", values, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkBetween(Integer value1, Integer value2) {
            addCriterion("querypk between", value1, value2, "querypk");
            return (Criteria) this;
        }

        public Criteria andQuerypkNotBetween(Integer value1, Integer value2) {
            addCriterion("querypk not between", value1, value2, "querypk");
            return (Criteria) this;
        }

        public Criteria andUsernickIsNull() {
            addCriterion("usernick is null");
            return (Criteria) this;
        }

        public Criteria andUsernickIsNotNull() {
            addCriterion("usernick is not null");
            return (Criteria) this;
        }

        public Criteria andUsernickEqualTo(String value) {
            addCriterion("usernick =", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotEqualTo(String value) {
            addCriterion("usernick <>", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickGreaterThan(String value) {
            addCriterion("usernick >", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickGreaterThanOrEqualTo(String value) {
            addCriterion("usernick >=", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLessThan(String value) {
            addCriterion("usernick <", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLessThanOrEqualTo(String value) {
            addCriterion("usernick <=", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLike(String value) {
            addCriterion("usernick like", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotLike(String value) {
            addCriterion("usernick not like", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickIn(List<String> values) {
            addCriterion("usernick in", values, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotIn(List<String> values) {
            addCriterion("usernick not in", values, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickBetween(String value1, String value2) {
            addCriterion("usernick between", value1, value2, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotBetween(String value1, String value2) {
            addCriterion("usernick not between", value1, value2, "usernick");
            return (Criteria) this;
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

        public Criteria andFlowcountsIsNull() {
            addCriterion("flowcounts is null");
            return (Criteria) this;
        }

        public Criteria andFlowcountsIsNotNull() {
            addCriterion("flowcounts is not null");
            return (Criteria) this;
        }

        public Criteria andFlowcountsEqualTo(Integer value) {
            addCriterion("flowcounts =", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsNotEqualTo(Integer value) {
            addCriterion("flowcounts <>", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsGreaterThan(Integer value) {
            addCriterion("flowcounts >", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("flowcounts >=", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsLessThan(Integer value) {
            addCriterion("flowcounts <", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsLessThanOrEqualTo(Integer value) {
            addCriterion("flowcounts <=", value, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsIn(List<Integer> values) {
            addCriterion("flowcounts in", values, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsNotIn(List<Integer> values) {
            addCriterion("flowcounts not in", values, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsBetween(Integer value1, Integer value2) {
            addCriterion("flowcounts between", value1, value2, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andFlowcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("flowcounts not between", value1, value2, "flowcounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsIsNull() {
            addCriterion("collectioncounts is null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsIsNotNull() {
            addCriterion("collectioncounts is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsEqualTo(Integer value) {
            addCriterion("collectioncounts =", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsNotEqualTo(Integer value) {
            addCriterion("collectioncounts <>", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsGreaterThan(Integer value) {
            addCriterion("collectioncounts >", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("collectioncounts >=", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsLessThan(Integer value) {
            addCriterion("collectioncounts <", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsLessThanOrEqualTo(Integer value) {
            addCriterion("collectioncounts <=", value, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsIn(List<Integer> values) {
            addCriterion("collectioncounts in", values, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsNotIn(List<Integer> values) {
            addCriterion("collectioncounts not in", values, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsBetween(Integer value1, Integer value2) {
            addCriterion("collectioncounts between", value1, value2, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andCollectioncountsNotBetween(Integer value1, Integer value2) {
            addCriterion("collectioncounts not between", value1, value2, "collectioncounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsIsNull() {
            addCriterion("shoppingcounts is null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsIsNotNull() {
            addCriterion("shoppingcounts is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsEqualTo(Integer value) {
            addCriterion("shoppingcounts =", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsNotEqualTo(Integer value) {
            addCriterion("shoppingcounts <>", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsGreaterThan(Integer value) {
            addCriterion("shoppingcounts >", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoppingcounts >=", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsLessThan(Integer value) {
            addCriterion("shoppingcounts <", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsLessThanOrEqualTo(Integer value) {
            addCriterion("shoppingcounts <=", value, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsIn(List<Integer> values) {
            addCriterion("shoppingcounts in", values, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsNotIn(List<Integer> values) {
            addCriterion("shoppingcounts not in", values, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsBetween(Integer value1, Integer value2) {
            addCriterion("shoppingcounts between", value1, value2, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andShoppingcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoppingcounts not between", value1, value2, "shoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsIsNull() {
            addCriterion("finshflowcounts is null");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsIsNotNull() {
            addCriterion("finshflowcounts is not null");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsEqualTo(Integer value) {
            addCriterion("finshflowcounts =", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsNotEqualTo(Integer value) {
            addCriterion("finshflowcounts <>", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsGreaterThan(Integer value) {
            addCriterion("finshflowcounts >", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("finshflowcounts >=", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsLessThan(Integer value) {
            addCriterion("finshflowcounts <", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsLessThanOrEqualTo(Integer value) {
            addCriterion("finshflowcounts <=", value, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsIn(List<Integer> values) {
            addCriterion("finshflowcounts in", values, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsNotIn(List<Integer> values) {
            addCriterion("finshflowcounts not in", values, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsBetween(Integer value1, Integer value2) {
            addCriterion("finshflowcounts between", value1, value2, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshflowcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("finshflowcounts not between", value1, value2, "finshflowcounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsIsNull() {
            addCriterion("finshcollectioncounts is null");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsIsNotNull() {
            addCriterion("finshcollectioncounts is not null");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsEqualTo(Integer value) {
            addCriterion("finshcollectioncounts =", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsNotEqualTo(Integer value) {
            addCriterion("finshcollectioncounts <>", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsGreaterThan(Integer value) {
            addCriterion("finshcollectioncounts >", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("finshcollectioncounts >=", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsLessThan(Integer value) {
            addCriterion("finshcollectioncounts <", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsLessThanOrEqualTo(Integer value) {
            addCriterion("finshcollectioncounts <=", value, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsIn(List<Integer> values) {
            addCriterion("finshcollectioncounts in", values, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsNotIn(List<Integer> values) {
            addCriterion("finshcollectioncounts not in", values, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsBetween(Integer value1, Integer value2) {
            addCriterion("finshcollectioncounts between", value1, value2, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshcollectioncountsNotBetween(Integer value1, Integer value2) {
            addCriterion("finshcollectioncounts not between", value1, value2, "finshcollectioncounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsIsNull() {
            addCriterion("finshshoppingcounts is null");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsIsNotNull() {
            addCriterion("finshshoppingcounts is not null");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsEqualTo(Integer value) {
            addCriterion("finshshoppingcounts =", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsNotEqualTo(Integer value) {
            addCriterion("finshshoppingcounts <>", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsGreaterThan(Integer value) {
            addCriterion("finshshoppingcounts >", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("finshshoppingcounts >=", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsLessThan(Integer value) {
            addCriterion("finshshoppingcounts <", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsLessThanOrEqualTo(Integer value) {
            addCriterion("finshshoppingcounts <=", value, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsIn(List<Integer> values) {
            addCriterion("finshshoppingcounts in", values, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsNotIn(List<Integer> values) {
            addCriterion("finshshoppingcounts not in", values, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsBetween(Integer value1, Integer value2) {
            addCriterion("finshshoppingcounts between", value1, value2, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andFinshshoppingcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("finshshoppingcounts not between", value1, value2, "finshshoppingcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsIsNull() {
            addCriterion("errorcounts is null");
            return (Criteria) this;
        }

        public Criteria andErrorcountsIsNotNull() {
            addCriterion("errorcounts is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcountsEqualTo(Integer value) {
            addCriterion("errorcounts =", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsNotEqualTo(Integer value) {
            addCriterion("errorcounts <>", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsGreaterThan(Integer value) {
            addCriterion("errorcounts >", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("errorcounts >=", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsLessThan(Integer value) {
            addCriterion("errorcounts <", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsLessThanOrEqualTo(Integer value) {
            addCriterion("errorcounts <=", value, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsIn(List<Integer> values) {
            addCriterion("errorcounts in", values, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsNotIn(List<Integer> values) {
            addCriterion("errorcounts not in", values, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsBetween(Integer value1, Integer value2) {
            addCriterion("errorcounts between", value1, value2, "errorcounts");
            return (Criteria) this;
        }

        public Criteria andErrorcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("errorcounts not between", value1, value2, "errorcounts");
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

        public Criteria andPublishtimeIsNull() {
            addCriterion("publishtime is null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIsNotNull() {
            addCriterion("publishtime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishtimeEqualTo(String value) {
            addCriterion("publishtime =", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotEqualTo(String value) {
            addCriterion("publishtime <>", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThan(String value) {
            addCriterion("publishtime >", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("publishtime >=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThan(String value) {
            addCriterion("publishtime <", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLessThanOrEqualTo(String value) {
            addCriterion("publishtime <=", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeLike(String value) {
            addCriterion("publishtime like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotLike(String value) {
            addCriterion("publishtime not like", value, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeIn(List<String> values) {
            addCriterion("publishtime in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotIn(List<String> values) {
            addCriterion("publishtime not in", values, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeBetween(String value1, String value2) {
            addCriterion("publishtime between", value1, value2, "publishtime");
            return (Criteria) this;
        }

        public Criteria andPublishtimeNotBetween(String value1, String value2) {
            addCriterion("publishtime not between", value1, value2, "publishtime");
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