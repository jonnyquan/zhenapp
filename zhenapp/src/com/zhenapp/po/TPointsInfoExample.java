package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TPointsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPointsInfoExample() {
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

        public Criteria andPointspkIsNull() {
            addCriterion("pointspk is null");
            return (Criteria) this;
        }

        public Criteria andPointspkIsNotNull() {
            addCriterion("pointspk is not null");
            return (Criteria) this;
        }

        public Criteria andPointspkEqualTo(Integer value) {
            addCriterion("pointspk =", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkNotEqualTo(Integer value) {
            addCriterion("pointspk <>", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkGreaterThan(Integer value) {
            addCriterion("pointspk >", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkGreaterThanOrEqualTo(Integer value) {
            addCriterion("pointspk >=", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkLessThan(Integer value) {
            addCriterion("pointspk <", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkLessThanOrEqualTo(Integer value) {
            addCriterion("pointspk <=", value, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkIn(List<Integer> values) {
            addCriterion("pointspk in", values, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkNotIn(List<Integer> values) {
            addCriterion("pointspk not in", values, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkBetween(Integer value1, Integer value2) {
            addCriterion("pointspk between", value1, value2, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointspkNotBetween(Integer value1, Integer value2) {
            addCriterion("pointspk not between", value1, value2, "pointspk");
            return (Criteria) this;
        }

        public Criteria andPointsidIsNull() {
            addCriterion("pointsid is null");
            return (Criteria) this;
        }

        public Criteria andPointsidIsNotNull() {
            addCriterion("pointsid is not null");
            return (Criteria) this;
        }

        public Criteria andPointsidEqualTo(String value) {
            addCriterion("pointsid =", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidNotEqualTo(String value) {
            addCriterion("pointsid <>", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidGreaterThan(String value) {
            addCriterion("pointsid >", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidGreaterThanOrEqualTo(String value) {
            addCriterion("pointsid >=", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidLessThan(String value) {
            addCriterion("pointsid <", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidLessThanOrEqualTo(String value) {
            addCriterion("pointsid <=", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidLike(String value) {
            addCriterion("pointsid like", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidNotLike(String value) {
            addCriterion("pointsid not like", value, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidIn(List<String> values) {
            addCriterion("pointsid in", values, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidNotIn(List<String> values) {
            addCriterion("pointsid not in", values, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidBetween(String value1, String value2) {
            addCriterion("pointsid between", value1, value2, "pointsid");
            return (Criteria) this;
        }

        public Criteria andPointsidNotBetween(String value1, String value2) {
            addCriterion("pointsid not between", value1, value2, "pointsid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andPointstypeIsNull() {
            addCriterion("pointstype is null");
            return (Criteria) this;
        }

        public Criteria andPointstypeIsNotNull() {
            addCriterion("pointstype is not null");
            return (Criteria) this;
        }

        public Criteria andPointstypeEqualTo(String value) {
            addCriterion("pointstype =", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeNotEqualTo(String value) {
            addCriterion("pointstype <>", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeGreaterThan(String value) {
            addCriterion("pointstype >", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeGreaterThanOrEqualTo(String value) {
            addCriterion("pointstype >=", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeLessThan(String value) {
            addCriterion("pointstype <", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeLessThanOrEqualTo(String value) {
            addCriterion("pointstype <=", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeLike(String value) {
            addCriterion("pointstype like", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeNotLike(String value) {
            addCriterion("pointstype not like", value, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeIn(List<String> values) {
            addCriterion("pointstype in", values, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeNotIn(List<String> values) {
            addCriterion("pointstype not in", values, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeBetween(String value1, String value2) {
            addCriterion("pointstype between", value1, value2, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointstypeNotBetween(String value1, String value2) {
            addCriterion("pointstype not between", value1, value2, "pointstype");
            return (Criteria) this;
        }

        public Criteria andPointsupdateIsNull() {
            addCriterion("pointsupdate is null");
            return (Criteria) this;
        }

        public Criteria andPointsupdateIsNotNull() {
            addCriterion("pointsupdate is not null");
            return (Criteria) this;
        }

        public Criteria andPointsupdateEqualTo(Integer value) {
            addCriterion("pointsupdate =", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateNotEqualTo(Integer value) {
            addCriterion("pointsupdate <>", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateGreaterThan(Integer value) {
            addCriterion("pointsupdate >", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pointsupdate >=", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateLessThan(Integer value) {
            addCriterion("pointsupdate <", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateLessThanOrEqualTo(Integer value) {
            addCriterion("pointsupdate <=", value, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateIn(List<Integer> values) {
            addCriterion("pointsupdate in", values, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateNotIn(List<Integer> values) {
            addCriterion("pointsupdate not in", values, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateBetween(Integer value1, Integer value2) {
            addCriterion("pointsupdate between", value1, value2, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsupdateNotBetween(Integer value1, Integer value2) {
            addCriterion("pointsupdate not between", value1, value2, "pointsupdate");
            return (Criteria) this;
        }

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Integer value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Integer value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Integer value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Integer value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Integer value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Integer> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Integer> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Integer value1, Integer value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointreasonIsNull() {
            addCriterion("pointreason is null");
            return (Criteria) this;
        }

        public Criteria andPointreasonIsNotNull() {
            addCriterion("pointreason is not null");
            return (Criteria) this;
        }

        public Criteria andPointreasonEqualTo(String value) {
            addCriterion("pointreason =", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonNotEqualTo(String value) {
            addCriterion("pointreason <>", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonGreaterThan(String value) {
            addCriterion("pointreason >", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonGreaterThanOrEqualTo(String value) {
            addCriterion("pointreason >=", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonLessThan(String value) {
            addCriterion("pointreason <", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonLessThanOrEqualTo(String value) {
            addCriterion("pointreason <=", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonLike(String value) {
            addCriterion("pointreason like", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonNotLike(String value) {
            addCriterion("pointreason not like", value, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonIn(List<String> values) {
            addCriterion("pointreason in", values, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonNotIn(List<String> values) {
            addCriterion("pointreason not in", values, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonBetween(String value1, String value2) {
            addCriterion("pointreason between", value1, value2, "pointreason");
            return (Criteria) this;
        }

        public Criteria andPointreasonNotBetween(String value1, String value2) {
            addCriterion("pointreason not between", value1, value2, "pointreason");
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