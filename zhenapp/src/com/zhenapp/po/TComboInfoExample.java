package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TComboInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TComboInfoExample() {
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

        public Criteria andCombopkIsNull() {
            addCriterion("combopk is null");
            return (Criteria) this;
        }

        public Criteria andCombopkIsNotNull() {
            addCriterion("combopk is not null");
            return (Criteria) this;
        }

        public Criteria andCombopkEqualTo(Integer value) {
            addCriterion("combopk =", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkNotEqualTo(Integer value) {
            addCriterion("combopk <>", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkGreaterThan(Integer value) {
            addCriterion("combopk >", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkGreaterThanOrEqualTo(Integer value) {
            addCriterion("combopk >=", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkLessThan(Integer value) {
            addCriterion("combopk <", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkLessThanOrEqualTo(Integer value) {
            addCriterion("combopk <=", value, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkIn(List<Integer> values) {
            addCriterion("combopk in", values, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkNotIn(List<Integer> values) {
            addCriterion("combopk not in", values, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkBetween(Integer value1, Integer value2) {
            addCriterion("combopk between", value1, value2, "combopk");
            return (Criteria) this;
        }

        public Criteria andCombopkNotBetween(Integer value1, Integer value2) {
            addCriterion("combopk not between", value1, value2, "combopk");
            return (Criteria) this;
        }

        public Criteria andComboidIsNull() {
            addCriterion("comboid is null");
            return (Criteria) this;
        }

        public Criteria andComboidIsNotNull() {
            addCriterion("comboid is not null");
            return (Criteria) this;
        }

        public Criteria andComboidEqualTo(String value) {
            addCriterion("comboid =", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotEqualTo(String value) {
            addCriterion("comboid <>", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidGreaterThan(String value) {
            addCriterion("comboid >", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidGreaterThanOrEqualTo(String value) {
            addCriterion("comboid >=", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLessThan(String value) {
            addCriterion("comboid <", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLessThanOrEqualTo(String value) {
            addCriterion("comboid <=", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidLike(String value) {
            addCriterion("comboid like", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotLike(String value) {
            addCriterion("comboid not like", value, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidIn(List<String> values) {
            addCriterion("comboid in", values, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotIn(List<String> values) {
            addCriterion("comboid not in", values, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidBetween(String value1, String value2) {
            addCriterion("comboid between", value1, value2, "comboid");
            return (Criteria) this;
        }

        public Criteria andComboidNotBetween(String value1, String value2) {
            addCriterion("comboid not between", value1, value2, "comboid");
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

        public Criteria andCombonameIsNull() {
            addCriterion("comboname is null");
            return (Criteria) this;
        }

        public Criteria andCombonameIsNotNull() {
            addCriterion("comboname is not null");
            return (Criteria) this;
        }

        public Criteria andCombonameEqualTo(String value) {
            addCriterion("comboname =", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotEqualTo(String value) {
            addCriterion("comboname <>", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameGreaterThan(String value) {
            addCriterion("comboname >", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameGreaterThanOrEqualTo(String value) {
            addCriterion("comboname >=", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLessThan(String value) {
            addCriterion("comboname <", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLessThanOrEqualTo(String value) {
            addCriterion("comboname <=", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameLike(String value) {
            addCriterion("comboname like", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotLike(String value) {
            addCriterion("comboname not like", value, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameIn(List<String> values) {
            addCriterion("comboname in", values, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotIn(List<String> values) {
            addCriterion("comboname not in", values, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameBetween(String value1, String value2) {
            addCriterion("comboname between", value1, value2, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombonameNotBetween(String value1, String value2) {
            addCriterion("comboname not between", value1, value2, "comboname");
            return (Criteria) this;
        }

        public Criteria andCombomoneyIsNull() {
            addCriterion("combomoney is null");
            return (Criteria) this;
        }

        public Criteria andCombomoneyIsNotNull() {
            addCriterion("combomoney is not null");
            return (Criteria) this;
        }

        public Criteria andCombomoneyEqualTo(Integer value) {
            addCriterion("combomoney =", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyNotEqualTo(Integer value) {
            addCriterion("combomoney <>", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyGreaterThan(Integer value) {
            addCriterion("combomoney >", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("combomoney >=", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyLessThan(Integer value) {
            addCriterion("combomoney <", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyLessThanOrEqualTo(Integer value) {
            addCriterion("combomoney <=", value, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyIn(List<Integer> values) {
            addCriterion("combomoney in", values, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyNotIn(List<Integer> values) {
            addCriterion("combomoney not in", values, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyBetween(Integer value1, Integer value2) {
            addCriterion("combomoney between", value1, value2, "combomoney");
            return (Criteria) this;
        }

        public Criteria andCombomoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("combomoney not between", value1, value2, "combomoney");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(String value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(String value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(String value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(String value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(String value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLike(String value) {
            addCriterion("discount like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotLike(String value) {
            addCriterion("discount not like", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<String> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<String> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(String value1, String value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(String value1, String value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNull() {
            addCriterion("unitprice is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIsNotNull() {
            addCriterion("unitprice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceEqualTo(String value) {
            addCriterion("unitprice =", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotEqualTo(String value) {
            addCriterion("unitprice <>", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThan(String value) {
            addCriterion("unitprice >", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceGreaterThanOrEqualTo(String value) {
            addCriterion("unitprice >=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThan(String value) {
            addCriterion("unitprice <", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLessThanOrEqualTo(String value) {
            addCriterion("unitprice <=", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceLike(String value) {
            addCriterion("unitprice like", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotLike(String value) {
            addCriterion("unitprice not like", value, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceIn(List<String> values) {
            addCriterion("unitprice in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotIn(List<String> values) {
            addCriterion("unitprice not in", values, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceBetween(String value1, String value2) {
            addCriterion("unitprice between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andUnitpriceNotBetween(String value1, String value2) {
            addCriterion("unitprice not between", value1, value2, "unitprice");
            return (Criteria) this;
        }

        public Criteria andCombointegralIsNull() {
            addCriterion("combointegral is null");
            return (Criteria) this;
        }

        public Criteria andCombointegralIsNotNull() {
            addCriterion("combointegral is not null");
            return (Criteria) this;
        }

        public Criteria andCombointegralEqualTo(Integer value) {
            addCriterion("combointegral =", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralNotEqualTo(Integer value) {
            addCriterion("combointegral <>", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralGreaterThan(Integer value) {
            addCriterion("combointegral >", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("combointegral >=", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralLessThan(Integer value) {
            addCriterion("combointegral <", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralLessThanOrEqualTo(Integer value) {
            addCriterion("combointegral <=", value, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralIn(List<Integer> values) {
            addCriterion("combointegral in", values, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralNotIn(List<Integer> values) {
            addCriterion("combointegral not in", values, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralBetween(Integer value1, Integer value2) {
            addCriterion("combointegral between", value1, value2, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombointegralNotBetween(Integer value1, Integer value2) {
            addCriterion("combointegral not between", value1, value2, "combointegral");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyIsNull() {
            addCriterion("combogivemoney is null");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyIsNotNull() {
            addCriterion("combogivemoney is not null");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyEqualTo(Integer value) {
            addCriterion("combogivemoney =", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyNotEqualTo(Integer value) {
            addCriterion("combogivemoney <>", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyGreaterThan(Integer value) {
            addCriterion("combogivemoney >", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("combogivemoney >=", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyLessThan(Integer value) {
            addCriterion("combogivemoney <", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyLessThanOrEqualTo(Integer value) {
            addCriterion("combogivemoney <=", value, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyIn(List<Integer> values) {
            addCriterion("combogivemoney in", values, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyNotIn(List<Integer> values) {
            addCriterion("combogivemoney not in", values, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyBetween(Integer value1, Integer value2) {
            addCriterion("combogivemoney between", value1, value2, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogivemoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("combogivemoney not between", value1, value2, "combogivemoney");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralIsNull() {
            addCriterion("combogiveintegral is null");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralIsNotNull() {
            addCriterion("combogiveintegral is not null");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralEqualTo(Integer value) {
            addCriterion("combogiveintegral =", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralNotEqualTo(Integer value) {
            addCriterion("combogiveintegral <>", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralGreaterThan(Integer value) {
            addCriterion("combogiveintegral >", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("combogiveintegral >=", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralLessThan(Integer value) {
            addCriterion("combogiveintegral <", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralLessThanOrEqualTo(Integer value) {
            addCriterion("combogiveintegral <=", value, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralIn(List<Integer> values) {
            addCriterion("combogiveintegral in", values, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralNotIn(List<Integer> values) {
            addCriterion("combogiveintegral not in", values, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralBetween(Integer value1, Integer value2) {
            addCriterion("combogiveintegral between", value1, value2, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombogiveintegralNotBetween(Integer value1, Integer value2) {
            addCriterion("combogiveintegral not between", value1, value2, "combogiveintegral");
            return (Criteria) this;
        }

        public Criteria andCombodescIsNull() {
            addCriterion("combodesc is null");
            return (Criteria) this;
        }

        public Criteria andCombodescIsNotNull() {
            addCriterion("combodesc is not null");
            return (Criteria) this;
        }

        public Criteria andCombodescEqualTo(String value) {
            addCriterion("combodesc =", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescNotEqualTo(String value) {
            addCriterion("combodesc <>", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescGreaterThan(String value) {
            addCriterion("combodesc >", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescGreaterThanOrEqualTo(String value) {
            addCriterion("combodesc >=", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescLessThan(String value) {
            addCriterion("combodesc <", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescLessThanOrEqualTo(String value) {
            addCriterion("combodesc <=", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescLike(String value) {
            addCriterion("combodesc like", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescNotLike(String value) {
            addCriterion("combodesc not like", value, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescIn(List<String> values) {
            addCriterion("combodesc in", values, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescNotIn(List<String> values) {
            addCriterion("combodesc not in", values, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescBetween(String value1, String value2) {
            addCriterion("combodesc between", value1, value2, "combodesc");
            return (Criteria) this;
        }

        public Criteria andCombodescNotBetween(String value1, String value2) {
            addCriterion("combodesc not between", value1, value2, "combodesc");
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