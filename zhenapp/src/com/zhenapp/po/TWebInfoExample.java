package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TWebInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWebInfoExample() {
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

        public Criteria andWebpkIsNull() {
            addCriterion("webpk is null");
            return (Criteria) this;
        }

        public Criteria andWebpkIsNotNull() {
            addCriterion("webpk is not null");
            return (Criteria) this;
        }

        public Criteria andWebpkEqualTo(Integer value) {
            addCriterion("webpk =", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkNotEqualTo(Integer value) {
            addCriterion("webpk <>", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkGreaterThan(Integer value) {
            addCriterion("webpk >", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("webpk >=", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkLessThan(Integer value) {
            addCriterion("webpk <", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkLessThanOrEqualTo(Integer value) {
            addCriterion("webpk <=", value, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkIn(List<Integer> values) {
            addCriterion("webpk in", values, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkNotIn(List<Integer> values) {
            addCriterion("webpk not in", values, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkBetween(Integer value1, Integer value2) {
            addCriterion("webpk between", value1, value2, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebpkNotBetween(Integer value1, Integer value2) {
            addCriterion("webpk not between", value1, value2, "webpk");
            return (Criteria) this;
        }

        public Criteria andWebidIsNull() {
            addCriterion("webid is null");
            return (Criteria) this;
        }

        public Criteria andWebidIsNotNull() {
            addCriterion("webid is not null");
            return (Criteria) this;
        }

        public Criteria andWebidEqualTo(String value) {
            addCriterion("webid =", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidNotEqualTo(String value) {
            addCriterion("webid <>", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidGreaterThan(String value) {
            addCriterion("webid >", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidGreaterThanOrEqualTo(String value) {
            addCriterion("webid >=", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidLessThan(String value) {
            addCriterion("webid <", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidLessThanOrEqualTo(String value) {
            addCriterion("webid <=", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidLike(String value) {
            addCriterion("webid like", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidNotLike(String value) {
            addCriterion("webid not like", value, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidIn(List<String> values) {
            addCriterion("webid in", values, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidNotIn(List<String> values) {
            addCriterion("webid not in", values, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidBetween(String value1, String value2) {
            addCriterion("webid between", value1, value2, "webid");
            return (Criteria) this;
        }

        public Criteria andWebidNotBetween(String value1, String value2) {
            addCriterion("webid not between", value1, value2, "webid");
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

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andCarousel01IsNull() {
            addCriterion("Carousel01 is null");
            return (Criteria) this;
        }

        public Criteria andCarousel01IsNotNull() {
            addCriterion("Carousel01 is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel01EqualTo(String value) {
            addCriterion("Carousel01 =", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01NotEqualTo(String value) {
            addCriterion("Carousel01 <>", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01GreaterThan(String value) {
            addCriterion("Carousel01 >", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01GreaterThanOrEqualTo(String value) {
            addCriterion("Carousel01 >=", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01LessThan(String value) {
            addCriterion("Carousel01 <", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01LessThanOrEqualTo(String value) {
            addCriterion("Carousel01 <=", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01Like(String value) {
            addCriterion("Carousel01 like", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01NotLike(String value) {
            addCriterion("Carousel01 not like", value, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01In(List<String> values) {
            addCriterion("Carousel01 in", values, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01NotIn(List<String> values) {
            addCriterion("Carousel01 not in", values, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01Between(String value1, String value2) {
            addCriterion("Carousel01 between", value1, value2, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel01NotBetween(String value1, String value2) {
            addCriterion("Carousel01 not between", value1, value2, "carousel01");
            return (Criteria) this;
        }

        public Criteria andCarousel02IsNull() {
            addCriterion("Carousel02 is null");
            return (Criteria) this;
        }

        public Criteria andCarousel02IsNotNull() {
            addCriterion("Carousel02 is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel02EqualTo(String value) {
            addCriterion("Carousel02 =", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02NotEqualTo(String value) {
            addCriterion("Carousel02 <>", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02GreaterThan(String value) {
            addCriterion("Carousel02 >", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02GreaterThanOrEqualTo(String value) {
            addCriterion("Carousel02 >=", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02LessThan(String value) {
            addCriterion("Carousel02 <", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02LessThanOrEqualTo(String value) {
            addCriterion("Carousel02 <=", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02Like(String value) {
            addCriterion("Carousel02 like", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02NotLike(String value) {
            addCriterion("Carousel02 not like", value, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02In(List<String> values) {
            addCriterion("Carousel02 in", values, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02NotIn(List<String> values) {
            addCriterion("Carousel02 not in", values, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02Between(String value1, String value2) {
            addCriterion("Carousel02 between", value1, value2, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel02NotBetween(String value1, String value2) {
            addCriterion("Carousel02 not between", value1, value2, "carousel02");
            return (Criteria) this;
        }

        public Criteria andCarousel03IsNull() {
            addCriterion("Carousel03 is null");
            return (Criteria) this;
        }

        public Criteria andCarousel03IsNotNull() {
            addCriterion("Carousel03 is not null");
            return (Criteria) this;
        }

        public Criteria andCarousel03EqualTo(String value) {
            addCriterion("Carousel03 =", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03NotEqualTo(String value) {
            addCriterion("Carousel03 <>", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03GreaterThan(String value) {
            addCriterion("Carousel03 >", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03GreaterThanOrEqualTo(String value) {
            addCriterion("Carousel03 >=", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03LessThan(String value) {
            addCriterion("Carousel03 <", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03LessThanOrEqualTo(String value) {
            addCriterion("Carousel03 <=", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03Like(String value) {
            addCriterion("Carousel03 like", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03NotLike(String value) {
            addCriterion("Carousel03 not like", value, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03In(List<String> values) {
            addCriterion("Carousel03 in", values, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03NotIn(List<String> values) {
            addCriterion("Carousel03 not in", values, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03Between(String value1, String value2) {
            addCriterion("Carousel03 between", value1, value2, "carousel03");
            return (Criteria) this;
        }

        public Criteria andCarousel03NotBetween(String value1, String value2) {
            addCriterion("Carousel03 not between", value1, value2, "carousel03");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQq2IsNull() {
            addCriterion("QQ2 is null");
            return (Criteria) this;
        }

        public Criteria andQq2IsNotNull() {
            addCriterion("QQ2 is not null");
            return (Criteria) this;
        }

        public Criteria andQq2EqualTo(String value) {
            addCriterion("QQ2 =", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotEqualTo(String value) {
            addCriterion("QQ2 <>", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2GreaterThan(String value) {
            addCriterion("QQ2 >", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2GreaterThanOrEqualTo(String value) {
            addCriterion("QQ2 >=", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2LessThan(String value) {
            addCriterion("QQ2 <", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2LessThanOrEqualTo(String value) {
            addCriterion("QQ2 <=", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2Like(String value) {
            addCriterion("QQ2 like", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotLike(String value) {
            addCriterion("QQ2 not like", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2In(List<String> values) {
            addCriterion("QQ2 in", values, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotIn(List<String> values) {
            addCriterion("QQ2 not in", values, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2Between(String value1, String value2) {
            addCriterion("QQ2 between", value1, value2, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotBetween(String value1, String value2) {
            addCriterion("QQ2 not between", value1, value2, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq3IsNull() {
            addCriterion("QQ3 is null");
            return (Criteria) this;
        }

        public Criteria andQq3IsNotNull() {
            addCriterion("QQ3 is not null");
            return (Criteria) this;
        }

        public Criteria andQq3EqualTo(String value) {
            addCriterion("QQ3 =", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotEqualTo(String value) {
            addCriterion("QQ3 <>", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3GreaterThan(String value) {
            addCriterion("QQ3 >", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3GreaterThanOrEqualTo(String value) {
            addCriterion("QQ3 >=", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3LessThan(String value) {
            addCriterion("QQ3 <", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3LessThanOrEqualTo(String value) {
            addCriterion("QQ3 <=", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3Like(String value) {
            addCriterion("QQ3 like", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotLike(String value) {
            addCriterion("QQ3 not like", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3In(List<String> values) {
            addCriterion("QQ3 in", values, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotIn(List<String> values) {
            addCriterion("QQ3 not in", values, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3Between(String value1, String value2) {
            addCriterion("QQ3 between", value1, value2, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotBetween(String value1, String value2) {
            addCriterion("QQ3 not between", value1, value2, "qq3");
            return (Criteria) this;
        }

        public Criteria andQqgroupIsNull() {
            addCriterion("qqgroup is null");
            return (Criteria) this;
        }

        public Criteria andQqgroupIsNotNull() {
            addCriterion("qqgroup is not null");
            return (Criteria) this;
        }

        public Criteria andQqgroupEqualTo(String value) {
            addCriterion("qqgroup =", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupNotEqualTo(String value) {
            addCriterion("qqgroup <>", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupGreaterThan(String value) {
            addCriterion("qqgroup >", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupGreaterThanOrEqualTo(String value) {
            addCriterion("qqgroup >=", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupLessThan(String value) {
            addCriterion("qqgroup <", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupLessThanOrEqualTo(String value) {
            addCriterion("qqgroup <=", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupLike(String value) {
            addCriterion("qqgroup like", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupNotLike(String value) {
            addCriterion("qqgroup not like", value, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupIn(List<String> values) {
            addCriterion("qqgroup in", values, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupNotIn(List<String> values) {
            addCriterion("qqgroup not in", values, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupBetween(String value1, String value2) {
            addCriterion("qqgroup between", value1, value2, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andQqgroupNotBetween(String value1, String value2) {
            addCriterion("qqgroup not between", value1, value2, "qqgroup");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andRecordIsNull() {
            addCriterion("record is null");
            return (Criteria) this;
        }

        public Criteria andRecordIsNotNull() {
            addCriterion("record is not null");
            return (Criteria) this;
        }

        public Criteria andRecordEqualTo(String value) {
            addCriterion("record =", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotEqualTo(String value) {
            addCriterion("record <>", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordGreaterThan(String value) {
            addCriterion("record >", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordGreaterThanOrEqualTo(String value) {
            addCriterion("record >=", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLessThan(String value) {
            addCriterion("record <", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLessThanOrEqualTo(String value) {
            addCriterion("record <=", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordLike(String value) {
            addCriterion("record like", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotLike(String value) {
            addCriterion("record not like", value, "record");
            return (Criteria) this;
        }

        public Criteria andRecordIn(List<String> values) {
            addCriterion("record in", values, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotIn(List<String> values) {
            addCriterion("record not in", values, "record");
            return (Criteria) this;
        }

        public Criteria andRecordBetween(String value1, String value2) {
            addCriterion("record between", value1, value2, "record");
            return (Criteria) this;
        }

        public Criteria andRecordNotBetween(String value1, String value2) {
            addCriterion("record not between", value1, value2, "record");
            return (Criteria) this;
        }

        public Criteria andAlipayIsNull() {
            addCriterion("alipay is null");
            return (Criteria) this;
        }

        public Criteria andAlipayIsNotNull() {
            addCriterion("alipay is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayEqualTo(String value) {
            addCriterion("alipay =", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotEqualTo(String value) {
            addCriterion("alipay <>", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayGreaterThan(String value) {
            addCriterion("alipay >", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayGreaterThanOrEqualTo(String value) {
            addCriterion("alipay >=", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLessThan(String value) {
            addCriterion("alipay <", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLessThanOrEqualTo(String value) {
            addCriterion("alipay <=", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLike(String value) {
            addCriterion("alipay like", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotLike(String value) {
            addCriterion("alipay not like", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayIn(List<String> values) {
            addCriterion("alipay in", values, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotIn(List<String> values) {
            addCriterion("alipay not in", values, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayBetween(String value1, String value2) {
            addCriterion("alipay between", value1, value2, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotBetween(String value1, String value2) {
            addCriterion("alipay not between", value1, value2, "alipay");
            return (Criteria) this;
        }

        public Criteria andBg01IsNull() {
            addCriterion("bg01 is null");
            return (Criteria) this;
        }

        public Criteria andBg01IsNotNull() {
            addCriterion("bg01 is not null");
            return (Criteria) this;
        }

        public Criteria andBg01EqualTo(String value) {
            addCriterion("bg01 =", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01NotEqualTo(String value) {
            addCriterion("bg01 <>", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01GreaterThan(String value) {
            addCriterion("bg01 >", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01GreaterThanOrEqualTo(String value) {
            addCriterion("bg01 >=", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01LessThan(String value) {
            addCriterion("bg01 <", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01LessThanOrEqualTo(String value) {
            addCriterion("bg01 <=", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01Like(String value) {
            addCriterion("bg01 like", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01NotLike(String value) {
            addCriterion("bg01 not like", value, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01In(List<String> values) {
            addCriterion("bg01 in", values, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01NotIn(List<String> values) {
            addCriterion("bg01 not in", values, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01Between(String value1, String value2) {
            addCriterion("bg01 between", value1, value2, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg01NotBetween(String value1, String value2) {
            addCriterion("bg01 not between", value1, value2, "bg01");
            return (Criteria) this;
        }

        public Criteria andBg02IsNull() {
            addCriterion("bg02 is null");
            return (Criteria) this;
        }

        public Criteria andBg02IsNotNull() {
            addCriterion("bg02 is not null");
            return (Criteria) this;
        }

        public Criteria andBg02EqualTo(String value) {
            addCriterion("bg02 =", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02NotEqualTo(String value) {
            addCriterion("bg02 <>", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02GreaterThan(String value) {
            addCriterion("bg02 >", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02GreaterThanOrEqualTo(String value) {
            addCriterion("bg02 >=", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02LessThan(String value) {
            addCriterion("bg02 <", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02LessThanOrEqualTo(String value) {
            addCriterion("bg02 <=", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02Like(String value) {
            addCriterion("bg02 like", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02NotLike(String value) {
            addCriterion("bg02 not like", value, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02In(List<String> values) {
            addCriterion("bg02 in", values, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02NotIn(List<String> values) {
            addCriterion("bg02 not in", values, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02Between(String value1, String value2) {
            addCriterion("bg02 between", value1, value2, "bg02");
            return (Criteria) this;
        }

        public Criteria andBg02NotBetween(String value1, String value2) {
            addCriterion("bg02 not between", value1, value2, "bg02");
            return (Criteria) this;
        }

        public Criteria andIcoIsNull() {
            addCriterion("ico is null");
            return (Criteria) this;
        }

        public Criteria andIcoIsNotNull() {
            addCriterion("ico is not null");
            return (Criteria) this;
        }

        public Criteria andIcoEqualTo(String value) {
            addCriterion("ico =", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotEqualTo(String value) {
            addCriterion("ico <>", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoGreaterThan(String value) {
            addCriterion("ico >", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoGreaterThanOrEqualTo(String value) {
            addCriterion("ico >=", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoLessThan(String value) {
            addCriterion("ico <", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoLessThanOrEqualTo(String value) {
            addCriterion("ico <=", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoLike(String value) {
            addCriterion("ico like", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotLike(String value) {
            addCriterion("ico not like", value, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoIn(List<String> values) {
            addCriterion("ico in", values, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotIn(List<String> values) {
            addCriterion("ico not in", values, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoBetween(String value1, String value2) {
            addCriterion("ico between", value1, value2, "ico");
            return (Criteria) this;
        }

        public Criteria andIcoNotBetween(String value1, String value2) {
            addCriterion("ico not between", value1, value2, "ico");
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