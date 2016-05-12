package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TFilepathInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFilepathInfoExample() {
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

        public Criteria andFilepathpkIsNull() {
            addCriterion("filepathpk is null");
            return (Criteria) this;
        }

        public Criteria andFilepathpkIsNotNull() {
            addCriterion("filepathpk is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathpkEqualTo(Integer value) {
            addCriterion("filepathpk =", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkNotEqualTo(Integer value) {
            addCriterion("filepathpk <>", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkGreaterThan(Integer value) {
            addCriterion("filepathpk >", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("filepathpk >=", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkLessThan(Integer value) {
            addCriterion("filepathpk <", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkLessThanOrEqualTo(Integer value) {
            addCriterion("filepathpk <=", value, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkIn(List<Integer> values) {
            addCriterion("filepathpk in", values, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkNotIn(List<Integer> values) {
            addCriterion("filepathpk not in", values, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkBetween(Integer value1, Integer value2) {
            addCriterion("filepathpk between", value1, value2, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathpkNotBetween(Integer value1, Integer value2) {
            addCriterion("filepathpk not between", value1, value2, "filepathpk");
            return (Criteria) this;
        }

        public Criteria andFilepathidIsNull() {
            addCriterion("filepathid is null");
            return (Criteria) this;
        }

        public Criteria andFilepathidIsNotNull() {
            addCriterion("filepathid is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathidEqualTo(String value) {
            addCriterion("filepathid =", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidNotEqualTo(String value) {
            addCriterion("filepathid <>", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidGreaterThan(String value) {
            addCriterion("filepathid >", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidGreaterThanOrEqualTo(String value) {
            addCriterion("filepathid >=", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidLessThan(String value) {
            addCriterion("filepathid <", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidLessThanOrEqualTo(String value) {
            addCriterion("filepathid <=", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidLike(String value) {
            addCriterion("filepathid like", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidNotLike(String value) {
            addCriterion("filepathid not like", value, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidIn(List<String> values) {
            addCriterion("filepathid in", values, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidNotIn(List<String> values) {
            addCriterion("filepathid not in", values, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidBetween(String value1, String value2) {
            addCriterion("filepathid between", value1, value2, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathidNotBetween(String value1, String value2) {
            addCriterion("filepathid not between", value1, value2, "filepathid");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filepath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filepath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filepath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filepath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filepath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filepath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filepath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filepath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filepath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filepath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filepath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filepath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filepath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filepath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathdescIsNull() {
            addCriterion("filepathdesc is null");
            return (Criteria) this;
        }

        public Criteria andFilepathdescIsNotNull() {
            addCriterion("filepathdesc is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathdescEqualTo(String value) {
            addCriterion("filepathdesc =", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescNotEqualTo(String value) {
            addCriterion("filepathdesc <>", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescGreaterThan(String value) {
            addCriterion("filepathdesc >", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescGreaterThanOrEqualTo(String value) {
            addCriterion("filepathdesc >=", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescLessThan(String value) {
            addCriterion("filepathdesc <", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescLessThanOrEqualTo(String value) {
            addCriterion("filepathdesc <=", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescLike(String value) {
            addCriterion("filepathdesc like", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescNotLike(String value) {
            addCriterion("filepathdesc not like", value, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescIn(List<String> values) {
            addCriterion("filepathdesc in", values, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescNotIn(List<String> values) {
            addCriterion("filepathdesc not in", values, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescBetween(String value1, String value2) {
            addCriterion("filepathdesc between", value1, value2, "filepathdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathdescNotBetween(String value1, String value2) {
            addCriterion("filepathdesc not between", value1, value2, "filepathdesc");
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