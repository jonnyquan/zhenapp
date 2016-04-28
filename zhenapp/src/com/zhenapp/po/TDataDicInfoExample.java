package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TDataDicInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDataDicInfoExample() {
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

        public Criteria andDicinfoidIsNull() {
            addCriterion("dicinfoid is null");
            return (Criteria) this;
        }

        public Criteria andDicinfoidIsNotNull() {
            addCriterion("dicinfoid is not null");
            return (Criteria) this;
        }

        public Criteria andDicinfoidEqualTo(Integer value) {
            addCriterion("dicinfoid =", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidNotEqualTo(Integer value) {
            addCriterion("dicinfoid <>", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidGreaterThan(Integer value) {
            addCriterion("dicinfoid >", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dicinfoid >=", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidLessThan(Integer value) {
            addCriterion("dicinfoid <", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("dicinfoid <=", value, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidIn(List<Integer> values) {
            addCriterion("dicinfoid in", values, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidNotIn(List<Integer> values) {
            addCriterion("dicinfoid not in", values, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidBetween(Integer value1, Integer value2) {
            addCriterion("dicinfoid between", value1, value2, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("dicinfoid not between", value1, value2, "dicinfoid");
            return (Criteria) this;
        }

        public Criteria andDicinfonameIsNull() {
            addCriterion("dicinfoname is null");
            return (Criteria) this;
        }

        public Criteria andDicinfonameIsNotNull() {
            addCriterion("dicinfoname is not null");
            return (Criteria) this;
        }

        public Criteria andDicinfonameEqualTo(String value) {
            addCriterion("dicinfoname =", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameNotEqualTo(String value) {
            addCriterion("dicinfoname <>", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameGreaterThan(String value) {
            addCriterion("dicinfoname >", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameGreaterThanOrEqualTo(String value) {
            addCriterion("dicinfoname >=", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameLessThan(String value) {
            addCriterion("dicinfoname <", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameLessThanOrEqualTo(String value) {
            addCriterion("dicinfoname <=", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameLike(String value) {
            addCriterion("dicinfoname like", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameNotLike(String value) {
            addCriterion("dicinfoname not like", value, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameIn(List<String> values) {
            addCriterion("dicinfoname in", values, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameNotIn(List<String> values) {
            addCriterion("dicinfoname not in", values, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameBetween(String value1, String value2) {
            addCriterion("dicinfoname between", value1, value2, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfonameNotBetween(String value1, String value2) {
            addCriterion("dicinfoname not between", value1, value2, "dicinfoname");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeIsNull() {
            addCriterion("dicinfocode is null");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeIsNotNull() {
            addCriterion("dicinfocode is not null");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeEqualTo(String value) {
            addCriterion("dicinfocode =", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeNotEqualTo(String value) {
            addCriterion("dicinfocode <>", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeGreaterThan(String value) {
            addCriterion("dicinfocode >", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeGreaterThanOrEqualTo(String value) {
            addCriterion("dicinfocode >=", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeLessThan(String value) {
            addCriterion("dicinfocode <", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeLessThanOrEqualTo(String value) {
            addCriterion("dicinfocode <=", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeLike(String value) {
            addCriterion("dicinfocode like", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeNotLike(String value) {
            addCriterion("dicinfocode not like", value, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeIn(List<String> values) {
            addCriterion("dicinfocode in", values, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeNotIn(List<String> values) {
            addCriterion("dicinfocode not in", values, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeBetween(String value1, String value2) {
            addCriterion("dicinfocode between", value1, value2, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfocodeNotBetween(String value1, String value2) {
            addCriterion("dicinfocode not between", value1, value2, "dicinfocode");
            return (Criteria) this;
        }

        public Criteria andDicinfostateIsNull() {
            addCriterion("dicinfostate is null");
            return (Criteria) this;
        }

        public Criteria andDicinfostateIsNotNull() {
            addCriterion("dicinfostate is not null");
            return (Criteria) this;
        }

        public Criteria andDicinfostateEqualTo(Integer value) {
            addCriterion("dicinfostate =", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateNotEqualTo(Integer value) {
            addCriterion("dicinfostate <>", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateGreaterThan(Integer value) {
            addCriterion("dicinfostate >", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateGreaterThanOrEqualTo(Integer value) {
            addCriterion("dicinfostate >=", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateLessThan(Integer value) {
            addCriterion("dicinfostate <", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateLessThanOrEqualTo(Integer value) {
            addCriterion("dicinfostate <=", value, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateIn(List<Integer> values) {
            addCriterion("dicinfostate in", values, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateNotIn(List<Integer> values) {
            addCriterion("dicinfostate not in", values, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateBetween(Integer value1, Integer value2) {
            addCriterion("dicinfostate between", value1, value2, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDicinfostateNotBetween(Integer value1, Integer value2) {
            addCriterion("dicinfostate not between", value1, value2, "dicinfostate");
            return (Criteria) this;
        }

        public Criteria andDictypecodeIsNull() {
            addCriterion("dictypecode is null");
            return (Criteria) this;
        }

        public Criteria andDictypecodeIsNotNull() {
            addCriterion("dictypecode is not null");
            return (Criteria) this;
        }

        public Criteria andDictypecodeEqualTo(String value) {
            addCriterion("dictypecode =", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeNotEqualTo(String value) {
            addCriterion("dictypecode <>", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeGreaterThan(String value) {
            addCriterion("dictypecode >", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("dictypecode >=", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeLessThan(String value) {
            addCriterion("dictypecode <", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeLessThanOrEqualTo(String value) {
            addCriterion("dictypecode <=", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeLike(String value) {
            addCriterion("dictypecode like", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeNotLike(String value) {
            addCriterion("dictypecode not like", value, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeIn(List<String> values) {
            addCriterion("dictypecode in", values, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeNotIn(List<String> values) {
            addCriterion("dictypecode not in", values, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeBetween(String value1, String value2) {
            addCriterion("dictypecode between", value1, value2, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypecodeNotBetween(String value1, String value2) {
            addCriterion("dictypecode not between", value1, value2, "dictypecode");
            return (Criteria) this;
        }

        public Criteria andDictypenameIsNull() {
            addCriterion("dictypename is null");
            return (Criteria) this;
        }

        public Criteria andDictypenameIsNotNull() {
            addCriterion("dictypename is not null");
            return (Criteria) this;
        }

        public Criteria andDictypenameEqualTo(String value) {
            addCriterion("dictypename =", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotEqualTo(String value) {
            addCriterion("dictypename <>", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameGreaterThan(String value) {
            addCriterion("dictypename >", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameGreaterThanOrEqualTo(String value) {
            addCriterion("dictypename >=", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLessThan(String value) {
            addCriterion("dictypename <", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLessThanOrEqualTo(String value) {
            addCriterion("dictypename <=", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameLike(String value) {
            addCriterion("dictypename like", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotLike(String value) {
            addCriterion("dictypename not like", value, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameIn(List<String> values) {
            addCriterion("dictypename in", values, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotIn(List<String> values) {
            addCriterion("dictypename not in", values, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameBetween(String value1, String value2) {
            addCriterion("dictypename between", value1, value2, "dictypename");
            return (Criteria) this;
        }

        public Criteria andDictypenameNotBetween(String value1, String value2) {
            addCriterion("dictypename not between", value1, value2, "dictypename");
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