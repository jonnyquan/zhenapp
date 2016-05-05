package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TTaskDetailinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskDetailinfoExample() {
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

        public Criteria andTaskdetailpkIsNull() {
            addCriterion("taskdetailpk is null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkIsNotNull() {
            addCriterion("taskdetailpk is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkEqualTo(Integer value) {
            addCriterion("taskdetailpk =", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkNotEqualTo(Integer value) {
            addCriterion("taskdetailpk <>", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkGreaterThan(Integer value) {
            addCriterion("taskdetailpk >", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskdetailpk >=", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkLessThan(Integer value) {
            addCriterion("taskdetailpk <", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkLessThanOrEqualTo(Integer value) {
            addCriterion("taskdetailpk <=", value, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkIn(List<Integer> values) {
            addCriterion("taskdetailpk in", values, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkNotIn(List<Integer> values) {
            addCriterion("taskdetailpk not in", values, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkBetween(Integer value1, Integer value2) {
            addCriterion("taskdetailpk between", value1, value2, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailpkNotBetween(Integer value1, Integer value2) {
            addCriterion("taskdetailpk not between", value1, value2, "taskdetailpk");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidIsNull() {
            addCriterion("taskdetailid is null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidIsNotNull() {
            addCriterion("taskdetailid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidEqualTo(String value) {
            addCriterion("taskdetailid =", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotEqualTo(String value) {
            addCriterion("taskdetailid <>", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidGreaterThan(String value) {
            addCriterion("taskdetailid >", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidGreaterThanOrEqualTo(String value) {
            addCriterion("taskdetailid >=", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidLessThan(String value) {
            addCriterion("taskdetailid <", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidLessThanOrEqualTo(String value) {
            addCriterion("taskdetailid <=", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidLike(String value) {
            addCriterion("taskdetailid like", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotLike(String value) {
            addCriterion("taskdetailid not like", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidIn(List<String> values) {
            addCriterion("taskdetailid in", values, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotIn(List<String> values) {
            addCriterion("taskdetailid not in", values, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidBetween(String value1, String value2) {
            addCriterion("taskdetailid between", value1, value2, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotBetween(String value1, String value2) {
            addCriterion("taskdetailid not between", value1, value2, "taskdetailid");
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

        public Criteria andSearchtypeIsNull() {
            addCriterion("searchtype is null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIsNotNull() {
            addCriterion("searchtype is not null");
            return (Criteria) this;
        }

        public Criteria andSearchtypeEqualTo(String value) {
            addCriterion("searchtype =", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotEqualTo(String value) {
            addCriterion("searchtype <>", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThan(String value) {
            addCriterion("searchtype >", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeGreaterThanOrEqualTo(String value) {
            addCriterion("searchtype >=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThan(String value) {
            addCriterion("searchtype <", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLessThanOrEqualTo(String value) {
            addCriterion("searchtype <=", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeLike(String value) {
            addCriterion("searchtype like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotLike(String value) {
            addCriterion("searchtype not like", value, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeIn(List<String> values) {
            addCriterion("searchtype in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotIn(List<String> values) {
            addCriterion("searchtype not in", values, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeBetween(String value1, String value2) {
            addCriterion("searchtype between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andSearchtypeNotBetween(String value1, String value2) {
            addCriterion("searchtype not between", value1, value2, "searchtype");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipIsNull() {
            addCriterion("isfreeship is null");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipIsNotNull() {
            addCriterion("isfreeship is not null");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipEqualTo(String value) {
            addCriterion("isfreeship =", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipNotEqualTo(String value) {
            addCriterion("isfreeship <>", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipGreaterThan(String value) {
            addCriterion("isfreeship >", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipGreaterThanOrEqualTo(String value) {
            addCriterion("isfreeship >=", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipLessThan(String value) {
            addCriterion("isfreeship <", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipLessThanOrEqualTo(String value) {
            addCriterion("isfreeship <=", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipLike(String value) {
            addCriterion("isfreeship like", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipNotLike(String value) {
            addCriterion("isfreeship not like", value, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipIn(List<String> values) {
            addCriterion("isfreeship in", values, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipNotIn(List<String> values) {
            addCriterion("isfreeship not in", values, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipBetween(String value1, String value2) {
            addCriterion("isfreeship between", value1, value2, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIsfreeshipNotBetween(String value1, String value2) {
            addCriterion("isfreeship not between", value1, value2, "isfreeship");
            return (Criteria) this;
        }

        public Criteria andIstmallIsNull() {
            addCriterion("istmall is null");
            return (Criteria) this;
        }

        public Criteria andIstmallIsNotNull() {
            addCriterion("istmall is not null");
            return (Criteria) this;
        }

        public Criteria andIstmallEqualTo(String value) {
            addCriterion("istmall =", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallNotEqualTo(String value) {
            addCriterion("istmall <>", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallGreaterThan(String value) {
            addCriterion("istmall >", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallGreaterThanOrEqualTo(String value) {
            addCriterion("istmall >=", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallLessThan(String value) {
            addCriterion("istmall <", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallLessThanOrEqualTo(String value) {
            addCriterion("istmall <=", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallLike(String value) {
            addCriterion("istmall like", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallNotLike(String value) {
            addCriterion("istmall not like", value, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallIn(List<String> values) {
            addCriterion("istmall in", values, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallNotIn(List<String> values) {
            addCriterion("istmall not in", values, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallBetween(String value1, String value2) {
            addCriterion("istmall between", value1, value2, "istmall");
            return (Criteria) this;
        }

        public Criteria andIstmallNotBetween(String value1, String value2) {
            addCriterion("istmall not between", value1, value2, "istmall");
            return (Criteria) this;
        }

        public Criteria andIscollectionIsNull() {
            addCriterion("iscollection is null");
            return (Criteria) this;
        }

        public Criteria andIscollectionIsNotNull() {
            addCriterion("iscollection is not null");
            return (Criteria) this;
        }

        public Criteria andIscollectionEqualTo(String value) {
            addCriterion("iscollection =", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotEqualTo(String value) {
            addCriterion("iscollection <>", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionGreaterThan(String value) {
            addCriterion("iscollection >", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionGreaterThanOrEqualTo(String value) {
            addCriterion("iscollection >=", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLessThan(String value) {
            addCriterion("iscollection <", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLessThanOrEqualTo(String value) {
            addCriterion("iscollection <=", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLike(String value) {
            addCriterion("iscollection like", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotLike(String value) {
            addCriterion("iscollection not like", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionIn(List<String> values) {
            addCriterion("iscollection in", values, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotIn(List<String> values) {
            addCriterion("iscollection not in", values, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionBetween(String value1, String value2) {
            addCriterion("iscollection between", value1, value2, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotBetween(String value1, String value2) {
            addCriterion("iscollection not between", value1, value2, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIsNull() {
            addCriterion("isshopping is null");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIsNotNull() {
            addCriterion("isshopping is not null");
            return (Criteria) this;
        }

        public Criteria andIsshoppingEqualTo(String value) {
            addCriterion("isshopping =", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotEqualTo(String value) {
            addCriterion("isshopping <>", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingGreaterThan(String value) {
            addCriterion("isshopping >", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingGreaterThanOrEqualTo(String value) {
            addCriterion("isshopping >=", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLessThan(String value) {
            addCriterion("isshopping <", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLessThanOrEqualTo(String value) {
            addCriterion("isshopping <=", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLike(String value) {
            addCriterion("isshopping like", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotLike(String value) {
            addCriterion("isshopping not like", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIn(List<String> values) {
            addCriterion("isshopping in", values, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotIn(List<String> values) {
            addCriterion("isshopping not in", values, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingBetween(String value1, String value2) {
            addCriterion("isshopping between", value1, value2, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotBetween(String value1, String value2) {
            addCriterion("isshopping not between", value1, value2, "isshopping");
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

        public Criteria andMinpictureIsNull() {
            addCriterion("minpicture is null");
            return (Criteria) this;
        }

        public Criteria andMinpictureIsNotNull() {
            addCriterion("minpicture is not null");
            return (Criteria) this;
        }

        public Criteria andMinpictureEqualTo(String value) {
            addCriterion("minpicture =", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureNotEqualTo(String value) {
            addCriterion("minpicture <>", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureGreaterThan(String value) {
            addCriterion("minpicture >", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureGreaterThanOrEqualTo(String value) {
            addCriterion("minpicture >=", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureLessThan(String value) {
            addCriterion("minpicture <", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureLessThanOrEqualTo(String value) {
            addCriterion("minpicture <=", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureLike(String value) {
            addCriterion("minpicture like", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureNotLike(String value) {
            addCriterion("minpicture not like", value, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureIn(List<String> values) {
            addCriterion("minpicture in", values, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureNotIn(List<String> values) {
            addCriterion("minpicture not in", values, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureBetween(String value1, String value2) {
            addCriterion("minpicture between", value1, value2, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMinpictureNotBetween(String value1, String value2) {
            addCriterion("minpicture not between", value1, value2, "minpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureIsNull() {
            addCriterion("maxpicture is null");
            return (Criteria) this;
        }

        public Criteria andMaxpictureIsNotNull() {
            addCriterion("maxpicture is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpictureEqualTo(String value) {
            addCriterion("maxpicture =", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureNotEqualTo(String value) {
            addCriterion("maxpicture <>", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureGreaterThan(String value) {
            addCriterion("maxpicture >", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureGreaterThanOrEqualTo(String value) {
            addCriterion("maxpicture >=", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureLessThan(String value) {
            addCriterion("maxpicture <", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureLessThanOrEqualTo(String value) {
            addCriterion("maxpicture <=", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureLike(String value) {
            addCriterion("maxpicture like", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureNotLike(String value) {
            addCriterion("maxpicture not like", value, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureIn(List<String> values) {
            addCriterion("maxpicture in", values, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureNotIn(List<String> values) {
            addCriterion("maxpicture not in", values, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureBetween(String value1, String value2) {
            addCriterion("maxpicture between", value1, value2, "maxpicture");
            return (Criteria) this;
        }

        public Criteria andMaxpictureNotBetween(String value1, String value2) {
            addCriterion("maxpicture not between", value1, value2, "maxpicture");
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

        public Criteria andIsflowIsNull() {
            addCriterion("isflow is null");
            return (Criteria) this;
        }

        public Criteria andIsflowIsNotNull() {
            addCriterion("isflow is not null");
            return (Criteria) this;
        }

        public Criteria andIsflowEqualTo(String value) {
            addCriterion("isflow =", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowNotEqualTo(String value) {
            addCriterion("isflow <>", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowGreaterThan(String value) {
            addCriterion("isflow >", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowGreaterThanOrEqualTo(String value) {
            addCriterion("isflow >=", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowLessThan(String value) {
            addCriterion("isflow <", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowLessThanOrEqualTo(String value) {
            addCriterion("isflow <=", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowLike(String value) {
            addCriterion("isflow like", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowNotLike(String value) {
            addCriterion("isflow not like", value, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowIn(List<String> values) {
            addCriterion("isflow in", values, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowNotIn(List<String> values) {
            addCriterion("isflow not in", values, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowBetween(String value1, String value2) {
            addCriterion("isflow between", value1, value2, "isflow");
            return (Criteria) this;
        }

        public Criteria andIsflowNotBetween(String value1, String value2) {
            addCriterion("isflow not between", value1, value2, "isflow");
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

        public Criteria andIsshopcollectIsNull() {
            addCriterion("isshopcollect is null");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectIsNotNull() {
            addCriterion("isshopcollect is not null");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectEqualTo(String value) {
            addCriterion("isshopcollect =", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectNotEqualTo(String value) {
            addCriterion("isshopcollect <>", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectGreaterThan(String value) {
            addCriterion("isshopcollect >", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectGreaterThanOrEqualTo(String value) {
            addCriterion("isshopcollect >=", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectLessThan(String value) {
            addCriterion("isshopcollect <", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectLessThanOrEqualTo(String value) {
            addCriterion("isshopcollect <=", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectLike(String value) {
            addCriterion("isshopcollect like", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectNotLike(String value) {
            addCriterion("isshopcollect not like", value, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectIn(List<String> values) {
            addCriterion("isshopcollect in", values, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectNotIn(List<String> values) {
            addCriterion("isshopcollect not in", values, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectBetween(String value1, String value2) {
            addCriterion("isshopcollect between", value1, value2, "isshopcollect");
            return (Criteria) this;
        }

        public Criteria andIsshopcollectNotBetween(String value1, String value2) {
            addCriterion("isshopcollect not between", value1, value2, "isshopcollect");
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

        public Criteria andTaskhourIsNull() {
            addCriterion("taskhour is null");
            return (Criteria) this;
        }

        public Criteria andTaskhourIsNotNull() {
            addCriterion("taskhour is not null");
            return (Criteria) this;
        }

        public Criteria andTaskhourEqualTo(String value) {
            addCriterion("taskhour =", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourNotEqualTo(String value) {
            addCriterion("taskhour <>", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourGreaterThan(String value) {
            addCriterion("taskhour >", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourGreaterThanOrEqualTo(String value) {
            addCriterion("taskhour >=", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourLessThan(String value) {
            addCriterion("taskhour <", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourLessThanOrEqualTo(String value) {
            addCriterion("taskhour <=", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourLike(String value) {
            addCriterion("taskhour like", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourNotLike(String value) {
            addCriterion("taskhour not like", value, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourIn(List<String> values) {
            addCriterion("taskhour in", values, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourNotIn(List<String> values) {
            addCriterion("taskhour not in", values, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourBetween(String value1, String value2) {
            addCriterion("taskhour between", value1, value2, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskhourNotBetween(String value1, String value2) {
            addCriterion("taskhour not between", value1, value2, "taskhour");
            return (Criteria) this;
        }

        public Criteria andTaskminuteIsNull() {
            addCriterion("taskminute is null");
            return (Criteria) this;
        }

        public Criteria andTaskminuteIsNotNull() {
            addCriterion("taskminute is not null");
            return (Criteria) this;
        }

        public Criteria andTaskminuteEqualTo(String value) {
            addCriterion("taskminute =", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteNotEqualTo(String value) {
            addCriterion("taskminute <>", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteGreaterThan(String value) {
            addCriterion("taskminute >", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteGreaterThanOrEqualTo(String value) {
            addCriterion("taskminute >=", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteLessThan(String value) {
            addCriterion("taskminute <", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteLessThanOrEqualTo(String value) {
            addCriterion("taskminute <=", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteLike(String value) {
            addCriterion("taskminute like", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteNotLike(String value) {
            addCriterion("taskminute not like", value, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteIn(List<String> values) {
            addCriterion("taskminute in", values, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteNotIn(List<String> values) {
            addCriterion("taskminute not in", values, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteBetween(String value1, String value2) {
            addCriterion("taskminute between", value1, value2, "taskminute");
            return (Criteria) this;
        }

        public Criteria andTaskminuteNotBetween(String value1, String value2) {
            addCriterion("taskminute not between", value1, value2, "taskminute");
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