package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TPackageInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPackageInfoExample() {
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

        public Criteria andPackagepkIsNull() {
            addCriterion("packagepk is null");
            return (Criteria) this;
        }

        public Criteria andPackagepkIsNotNull() {
            addCriterion("packagepk is not null");
            return (Criteria) this;
        }

        public Criteria andPackagepkEqualTo(Integer value) {
            addCriterion("packagepk =", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkNotEqualTo(Integer value) {
            addCriterion("packagepk <>", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkGreaterThan(Integer value) {
            addCriterion("packagepk >", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkGreaterThanOrEqualTo(Integer value) {
            addCriterion("packagepk >=", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkLessThan(Integer value) {
            addCriterion("packagepk <", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkLessThanOrEqualTo(Integer value) {
            addCriterion("packagepk <=", value, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkIn(List<Integer> values) {
            addCriterion("packagepk in", values, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkNotIn(List<Integer> values) {
            addCriterion("packagepk not in", values, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkBetween(Integer value1, Integer value2) {
            addCriterion("packagepk between", value1, value2, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackagepkNotBetween(Integer value1, Integer value2) {
            addCriterion("packagepk not between", value1, value2, "packagepk");
            return (Criteria) this;
        }

        public Criteria andPackageidIsNull() {
            addCriterion("packageid is null");
            return (Criteria) this;
        }

        public Criteria andPackageidIsNotNull() {
            addCriterion("packageid is not null");
            return (Criteria) this;
        }

        public Criteria andPackageidEqualTo(Integer value) {
            addCriterion("packageid =", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotEqualTo(Integer value) {
            addCriterion("packageid <>", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThan(Integer value) {
            addCriterion("packageid >", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("packageid >=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThan(Integer value) {
            addCriterion("packageid <", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThanOrEqualTo(Integer value) {
            addCriterion("packageid <=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidIn(List<Integer> values) {
            addCriterion("packageid in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotIn(List<Integer> values) {
            addCriterion("packageid not in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidBetween(Integer value1, Integer value2) {
            addCriterion("packageid between", value1, value2, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotBetween(Integer value1, Integer value2) {
            addCriterion("packageid not between", value1, value2, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackagenameIsNull() {
            addCriterion("packagename is null");
            return (Criteria) this;
        }

        public Criteria andPackagenameIsNotNull() {
            addCriterion("packagename is not null");
            return (Criteria) this;
        }

        public Criteria andPackagenameEqualTo(String value) {
            addCriterion("packagename =", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotEqualTo(String value) {
            addCriterion("packagename <>", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThan(String value) {
            addCriterion("packagename >", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThanOrEqualTo(String value) {
            addCriterion("packagename >=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThan(String value) {
            addCriterion("packagename <", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThanOrEqualTo(String value) {
            addCriterion("packagename <=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLike(String value) {
            addCriterion("packagename like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotLike(String value) {
            addCriterion("packagename not like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameIn(List<String> values) {
            addCriterion("packagename in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotIn(List<String> values) {
            addCriterion("packagename not in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameBetween(String value1, String value2) {
            addCriterion("packagename between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotBetween(String value1, String value2) {
            addCriterion("packagename not between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagepriceIsNull() {
            addCriterion("packageprice is null");
            return (Criteria) this;
        }

        public Criteria andPackagepriceIsNotNull() {
            addCriterion("packageprice is not null");
            return (Criteria) this;
        }

        public Criteria andPackagepriceEqualTo(String value) {
            addCriterion("packageprice =", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotEqualTo(String value) {
            addCriterion("packageprice <>", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceGreaterThan(String value) {
            addCriterion("packageprice >", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceGreaterThanOrEqualTo(String value) {
            addCriterion("packageprice >=", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceLessThan(String value) {
            addCriterion("packageprice <", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceLessThanOrEqualTo(String value) {
            addCriterion("packageprice <=", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceLike(String value) {
            addCriterion("packageprice like", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotLike(String value) {
            addCriterion("packageprice not like", value, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceIn(List<String> values) {
            addCriterion("packageprice in", values, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotIn(List<String> values) {
            addCriterion("packageprice not in", values, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceBetween(String value1, String value2) {
            addCriterion("packageprice between", value1, value2, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagepriceNotBetween(String value1, String value2) {
            addCriterion("packageprice not between", value1, value2, "packageprice");
            return (Criteria) this;
        }

        public Criteria andPackagestateIsNull() {
            addCriterion("packagestate is null");
            return (Criteria) this;
        }

        public Criteria andPackagestateIsNotNull() {
            addCriterion("packagestate is not null");
            return (Criteria) this;
        }

        public Criteria andPackagestateEqualTo(Integer value) {
            addCriterion("packagestate =", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateNotEqualTo(Integer value) {
            addCriterion("packagestate <>", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateGreaterThan(Integer value) {
            addCriterion("packagestate >", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("packagestate >=", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateLessThan(Integer value) {
            addCriterion("packagestate <", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateLessThanOrEqualTo(Integer value) {
            addCriterion("packagestate <=", value, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateIn(List<Integer> values) {
            addCriterion("packagestate in", values, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateNotIn(List<Integer> values) {
            addCriterion("packagestate not in", values, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateBetween(Integer value1, Integer value2) {
            addCriterion("packagestate between", value1, value2, "packagestate");
            return (Criteria) this;
        }

        public Criteria andPackagestateNotBetween(Integer value1, Integer value2) {
            addCriterion("packagestate not between", value1, value2, "packagestate");
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