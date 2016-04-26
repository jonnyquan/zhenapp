package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TTbaccountInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTbaccountInfoExample() {
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

        public Criteria andTbaccountpkIsNull() {
            addCriterion("tbaccountpk is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkIsNotNull() {
            addCriterion("tbaccountpk is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkEqualTo(Integer value) {
            addCriterion("tbaccountpk =", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkNotEqualTo(Integer value) {
            addCriterion("tbaccountpk <>", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkGreaterThan(Integer value) {
            addCriterion("tbaccountpk >", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("tbaccountpk >=", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkLessThan(Integer value) {
            addCriterion("tbaccountpk <", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkLessThanOrEqualTo(Integer value) {
            addCriterion("tbaccountpk <=", value, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkIn(List<Integer> values) {
            addCriterion("tbaccountpk in", values, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkNotIn(List<Integer> values) {
            addCriterion("tbaccountpk not in", values, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkBetween(Integer value1, Integer value2) {
            addCriterion("tbaccountpk between", value1, value2, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountpkNotBetween(Integer value1, Integer value2) {
            addCriterion("tbaccountpk not between", value1, value2, "tbaccountpk");
            return (Criteria) this;
        }

        public Criteria andTbaccountidIsNull() {
            addCriterion("tbaccountid is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountidIsNotNull() {
            addCriterion("tbaccountid is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountidEqualTo(String value) {
            addCriterion("tbaccountid =", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidNotEqualTo(String value) {
            addCriterion("tbaccountid <>", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidGreaterThan(String value) {
            addCriterion("tbaccountid >", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidGreaterThanOrEqualTo(String value) {
            addCriterion("tbaccountid >=", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidLessThan(String value) {
            addCriterion("tbaccountid <", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidLessThanOrEqualTo(String value) {
            addCriterion("tbaccountid <=", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidLike(String value) {
            addCriterion("tbaccountid like", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidNotLike(String value) {
            addCriterion("tbaccountid not like", value, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidIn(List<String> values) {
            addCriterion("tbaccountid in", values, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidNotIn(List<String> values) {
            addCriterion("tbaccountid not in", values, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidBetween(String value1, String value2) {
            addCriterion("tbaccountid between", value1, value2, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountidNotBetween(String value1, String value2) {
            addCriterion("tbaccountid not between", value1, value2, "tbaccountid");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameIsNull() {
            addCriterion("tbaccountname is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameIsNotNull() {
            addCriterion("tbaccountname is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameEqualTo(String value) {
            addCriterion("tbaccountname =", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameNotEqualTo(String value) {
            addCriterion("tbaccountname <>", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameGreaterThan(String value) {
            addCriterion("tbaccountname >", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("tbaccountname >=", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameLessThan(String value) {
            addCriterion("tbaccountname <", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameLessThanOrEqualTo(String value) {
            addCriterion("tbaccountname <=", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameLike(String value) {
            addCriterion("tbaccountname like", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameNotLike(String value) {
            addCriterion("tbaccountname not like", value, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameIn(List<String> values) {
            addCriterion("tbaccountname in", values, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameNotIn(List<String> values) {
            addCriterion("tbaccountname not in", values, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameBetween(String value1, String value2) {
            addCriterion("tbaccountname between", value1, value2, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountnameNotBetween(String value1, String value2) {
            addCriterion("tbaccountname not between", value1, value2, "tbaccountname");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdIsNull() {
            addCriterion("tbaccountpwd is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdIsNotNull() {
            addCriterion("tbaccountpwd is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdEqualTo(String value) {
            addCriterion("tbaccountpwd =", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdNotEqualTo(String value) {
            addCriterion("tbaccountpwd <>", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdGreaterThan(String value) {
            addCriterion("tbaccountpwd >", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdGreaterThanOrEqualTo(String value) {
            addCriterion("tbaccountpwd >=", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdLessThan(String value) {
            addCriterion("tbaccountpwd <", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdLessThanOrEqualTo(String value) {
            addCriterion("tbaccountpwd <=", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdLike(String value) {
            addCriterion("tbaccountpwd like", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdNotLike(String value) {
            addCriterion("tbaccountpwd not like", value, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdIn(List<String> values) {
            addCriterion("tbaccountpwd in", values, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdNotIn(List<String> values) {
            addCriterion("tbaccountpwd not in", values, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdBetween(String value1, String value2) {
            addCriterion("tbaccountpwd between", value1, value2, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccountpwdNotBetween(String value1, String value2) {
            addCriterion("tbaccountpwd not between", value1, value2, "tbaccountpwd");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeIsNull() {
            addCriterion("tbaccounttime is null");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeIsNotNull() {
            addCriterion("tbaccounttime is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeEqualTo(Integer value) {
            addCriterion("tbaccounttime =", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeNotEqualTo(Integer value) {
            addCriterion("tbaccounttime <>", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeGreaterThan(Integer value) {
            addCriterion("tbaccounttime >", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tbaccounttime >=", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeLessThan(Integer value) {
            addCriterion("tbaccounttime <", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeLessThanOrEqualTo(Integer value) {
            addCriterion("tbaccounttime <=", value, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeIn(List<Integer> values) {
            addCriterion("tbaccounttime in", values, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeNotIn(List<Integer> values) {
            addCriterion("tbaccounttime not in", values, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeBetween(Integer value1, Integer value2) {
            addCriterion("tbaccounttime between", value1, value2, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccounttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("tbaccounttime not between", value1, value2, "tbaccounttime");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidIsNull() {
            addCriterion("tbaccountphoneid is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidIsNotNull() {
            addCriterion("tbaccountphoneid is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidEqualTo(String value) {
            addCriterion("tbaccountphoneid =", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidNotEqualTo(String value) {
            addCriterion("tbaccountphoneid <>", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidGreaterThan(String value) {
            addCriterion("tbaccountphoneid >", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidGreaterThanOrEqualTo(String value) {
            addCriterion("tbaccountphoneid >=", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidLessThan(String value) {
            addCriterion("tbaccountphoneid <", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidLessThanOrEqualTo(String value) {
            addCriterion("tbaccountphoneid <=", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidLike(String value) {
            addCriterion("tbaccountphoneid like", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidNotLike(String value) {
            addCriterion("tbaccountphoneid not like", value, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidIn(List<String> values) {
            addCriterion("tbaccountphoneid in", values, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidNotIn(List<String> values) {
            addCriterion("tbaccountphoneid not in", values, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidBetween(String value1, String value2) {
            addCriterion("tbaccountphoneid between", value1, value2, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountphoneidNotBetween(String value1, String value2) {
            addCriterion("tbaccountphoneid not between", value1, value2, "tbaccountphoneid");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateIsNull() {
            addCriterion("tbaccountstate is null");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateIsNotNull() {
            addCriterion("tbaccountstate is not null");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateEqualTo(String value) {
            addCriterion("tbaccountstate =", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateNotEqualTo(String value) {
            addCriterion("tbaccountstate <>", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateGreaterThan(String value) {
            addCriterion("tbaccountstate >", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateGreaterThanOrEqualTo(String value) {
            addCriterion("tbaccountstate >=", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateLessThan(String value) {
            addCriterion("tbaccountstate <", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateLessThanOrEqualTo(String value) {
            addCriterion("tbaccountstate <=", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateLike(String value) {
            addCriterion("tbaccountstate like", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateNotLike(String value) {
            addCriterion("tbaccountstate not like", value, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateIn(List<String> values) {
            addCriterion("tbaccountstate in", values, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateNotIn(List<String> values) {
            addCriterion("tbaccountstate not in", values, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateBetween(String value1, String value2) {
            addCriterion("tbaccountstate between", value1, value2, "tbaccountstate");
            return (Criteria) this;
        }

        public Criteria andTbaccountstateNotBetween(String value1, String value2) {
            addCriterion("tbaccountstate not between", value1, value2, "tbaccountstate");
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