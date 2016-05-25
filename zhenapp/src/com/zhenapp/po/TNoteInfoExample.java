package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TNoteInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TNoteInfoExample() {
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

        public Criteria andNotepkIsNull() {
            addCriterion("notepk is null");
            return (Criteria) this;
        }

        public Criteria andNotepkIsNotNull() {
            addCriterion("notepk is not null");
            return (Criteria) this;
        }

        public Criteria andNotepkEqualTo(Integer value) {
            addCriterion("notepk =", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkNotEqualTo(Integer value) {
            addCriterion("notepk <>", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkGreaterThan(Integer value) {
            addCriterion("notepk >", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkGreaterThanOrEqualTo(Integer value) {
            addCriterion("notepk >=", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkLessThan(Integer value) {
            addCriterion("notepk <", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkLessThanOrEqualTo(Integer value) {
            addCriterion("notepk <=", value, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkIn(List<Integer> values) {
            addCriterion("notepk in", values, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkNotIn(List<Integer> values) {
            addCriterion("notepk not in", values, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkBetween(Integer value1, Integer value2) {
            addCriterion("notepk between", value1, value2, "notepk");
            return (Criteria) this;
        }

        public Criteria andNotepkNotBetween(Integer value1, Integer value2) {
            addCriterion("notepk not between", value1, value2, "notepk");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNull() {
            addCriterion("noteid is null");
            return (Criteria) this;
        }

        public Criteria andNoteidIsNotNull() {
            addCriterion("noteid is not null");
            return (Criteria) this;
        }

        public Criteria andNoteidEqualTo(String value) {
            addCriterion("noteid =", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotEqualTo(String value) {
            addCriterion("noteid <>", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThan(String value) {
            addCriterion("noteid >", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidGreaterThanOrEqualTo(String value) {
            addCriterion("noteid >=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThan(String value) {
            addCriterion("noteid <", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLessThanOrEqualTo(String value) {
            addCriterion("noteid <=", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidLike(String value) {
            addCriterion("noteid like", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotLike(String value) {
            addCriterion("noteid not like", value, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidIn(List<String> values) {
            addCriterion("noteid in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotIn(List<String> values) {
            addCriterion("noteid not in", values, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidBetween(String value1, String value2) {
            addCriterion("noteid between", value1, value2, "noteid");
            return (Criteria) this;
        }

        public Criteria andNoteidNotBetween(String value1, String value2) {
            addCriterion("noteid not between", value1, value2, "noteid");
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

        public Criteria andNotetypeIsNull() {
            addCriterion("notetype is null");
            return (Criteria) this;
        }

        public Criteria andNotetypeIsNotNull() {
            addCriterion("notetype is not null");
            return (Criteria) this;
        }

        public Criteria andNotetypeEqualTo(String value) {
            addCriterion("notetype =", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeNotEqualTo(String value) {
            addCriterion("notetype <>", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeGreaterThan(String value) {
            addCriterion("notetype >", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeGreaterThanOrEqualTo(String value) {
            addCriterion("notetype >=", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeLessThan(String value) {
            addCriterion("notetype <", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeLessThanOrEqualTo(String value) {
            addCriterion("notetype <=", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeLike(String value) {
            addCriterion("notetype like", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeNotLike(String value) {
            addCriterion("notetype not like", value, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeIn(List<String> values) {
            addCriterion("notetype in", values, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeNotIn(List<String> values) {
            addCriterion("notetype not in", values, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeBetween(String value1, String value2) {
            addCriterion("notetype between", value1, value2, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotetypeNotBetween(String value1, String value2) {
            addCriterion("notetype not between", value1, value2, "notetype");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNull() {
            addCriterion("notename is null");
            return (Criteria) this;
        }

        public Criteria andNotenameIsNotNull() {
            addCriterion("notename is not null");
            return (Criteria) this;
        }

        public Criteria andNotenameEqualTo(String value) {
            addCriterion("notename =", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotEqualTo(String value) {
            addCriterion("notename <>", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThan(String value) {
            addCriterion("notename >", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameGreaterThanOrEqualTo(String value) {
            addCriterion("notename >=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThan(String value) {
            addCriterion("notename <", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLessThanOrEqualTo(String value) {
            addCriterion("notename <=", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameLike(String value) {
            addCriterion("notename like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotLike(String value) {
            addCriterion("notename not like", value, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameIn(List<String> values) {
            addCriterion("notename in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotIn(List<String> values) {
            addCriterion("notename not in", values, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameBetween(String value1, String value2) {
            addCriterion("notename between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andNotenameNotBetween(String value1, String value2) {
            addCriterion("notename not between", value1, value2, "notename");
            return (Criteria) this;
        }

        public Criteria andNotestateIsNull() {
            addCriterion("notestate is null");
            return (Criteria) this;
        }

        public Criteria andNotestateIsNotNull() {
            addCriterion("notestate is not null");
            return (Criteria) this;
        }

        public Criteria andNotestateEqualTo(String value) {
            addCriterion("notestate =", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateNotEqualTo(String value) {
            addCriterion("notestate <>", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateGreaterThan(String value) {
            addCriterion("notestate >", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateGreaterThanOrEqualTo(String value) {
            addCriterion("notestate >=", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateLessThan(String value) {
            addCriterion("notestate <", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateLessThanOrEqualTo(String value) {
            addCriterion("notestate <=", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateLike(String value) {
            addCriterion("notestate like", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateNotLike(String value) {
            addCriterion("notestate not like", value, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateIn(List<String> values) {
            addCriterion("notestate in", values, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateNotIn(List<String> values) {
            addCriterion("notestate not in", values, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateBetween(String value1, String value2) {
            addCriterion("notestate between", value1, value2, "notestate");
            return (Criteria) this;
        }

        public Criteria andNotestateNotBetween(String value1, String value2) {
            addCriterion("notestate not between", value1, value2, "notestate");
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