package com.zhenapp.po;

import java.util.ArrayList;
import java.util.List;

public class TUserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserInfoExample() {
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

        public Criteria andUserpkIsNull() {
            addCriterion("userpk is null");
            return (Criteria) this;
        }

        public Criteria andUserpkIsNotNull() {
            addCriterion("userpk is not null");
            return (Criteria) this;
        }

        public Criteria andUserpkEqualTo(Integer value) {
            addCriterion("userpk =", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkNotEqualTo(Integer value) {
            addCriterion("userpk <>", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkGreaterThan(Integer value) {
            addCriterion("userpk >", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkGreaterThanOrEqualTo(Integer value) {
            addCriterion("userpk >=", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkLessThan(Integer value) {
            addCriterion("userpk <", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkLessThanOrEqualTo(Integer value) {
            addCriterion("userpk <=", value, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkIn(List<Integer> values) {
            addCriterion("userpk in", values, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkNotIn(List<Integer> values) {
            addCriterion("userpk not in", values, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkBetween(Integer value1, Integer value2) {
            addCriterion("userpk between", value1, value2, "userpk");
            return (Criteria) this;
        }

        public Criteria andUserpkNotBetween(Integer value1, Integer value2) {
            addCriterion("userpk not between", value1, value2, "userpk");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernickIsNull() {
            addCriterion("userNick is null");
            return (Criteria) this;
        }

        public Criteria andUsernickIsNotNull() {
            addCriterion("userNick is not null");
            return (Criteria) this;
        }

        public Criteria andUsernickEqualTo(String value) {
            addCriterion("userNick =", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotEqualTo(String value) {
            addCriterion("userNick <>", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickGreaterThan(String value) {
            addCriterion("userNick >", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickGreaterThanOrEqualTo(String value) {
            addCriterion("userNick >=", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLessThan(String value) {
            addCriterion("userNick <", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLessThanOrEqualTo(String value) {
            addCriterion("userNick <=", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickLike(String value) {
            addCriterion("userNick like", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotLike(String value) {
            addCriterion("userNick not like", value, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickIn(List<String> values) {
            addCriterion("userNick in", values, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotIn(List<String> values) {
            addCriterion("userNick not in", values, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickBetween(String value1, String value2) {
            addCriterion("userNick between", value1, value2, "usernick");
            return (Criteria) this;
        }

        public Criteria andUsernickNotBetween(String value1, String value2) {
            addCriterion("userNick not between", value1, value2, "usernick");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNull() {
            addCriterion("userPwd is null");
            return (Criteria) this;
        }

        public Criteria andUserpwdIsNotNull() {
            addCriterion("userPwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserpwdEqualTo(String value) {
            addCriterion("userPwd =", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotEqualTo(String value) {
            addCriterion("userPwd <>", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThan(String value) {
            addCriterion("userPwd >", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdGreaterThanOrEqualTo(String value) {
            addCriterion("userPwd >=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThan(String value) {
            addCriterion("userPwd <", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLessThanOrEqualTo(String value) {
            addCriterion("userPwd <=", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdLike(String value) {
            addCriterion("userPwd like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotLike(String value) {
            addCriterion("userPwd not like", value, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdIn(List<String> values) {
            addCriterion("userPwd in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotIn(List<String> values) {
            addCriterion("userPwd not in", values, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdBetween(String value1, String value2) {
            addCriterion("userPwd between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUserpwdNotBetween(String value1, String value2) {
            addCriterion("userPwd not between", value1, value2, "userpwd");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserqqIsNull() {
            addCriterion("userQQ is null");
            return (Criteria) this;
        }

        public Criteria andUserqqIsNotNull() {
            addCriterion("userQQ is not null");
            return (Criteria) this;
        }

        public Criteria andUserqqEqualTo(String value) {
            addCriterion("userQQ =", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotEqualTo(String value) {
            addCriterion("userQQ <>", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqGreaterThan(String value) {
            addCriterion("userQQ >", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqGreaterThanOrEqualTo(String value) {
            addCriterion("userQQ >=", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLessThan(String value) {
            addCriterion("userQQ <", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLessThanOrEqualTo(String value) {
            addCriterion("userQQ <=", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqLike(String value) {
            addCriterion("userQQ like", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotLike(String value) {
            addCriterion("userQQ not like", value, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqIn(List<String> values) {
            addCriterion("userQQ in", values, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotIn(List<String> values) {
            addCriterion("userQQ not in", values, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqBetween(String value1, String value2) {
            addCriterion("userQQ between", value1, value2, "userqq");
            return (Criteria) this;
        }

        public Criteria andUserqqNotBetween(String value1, String value2) {
            addCriterion("userQQ not between", value1, value2, "userqq");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIsNull() {
            addCriterion("usercardnum is null");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIsNotNull() {
            addCriterion("usercardnum is not null");
            return (Criteria) this;
        }

        public Criteria andUsercardnumEqualTo(String value) {
            addCriterion("usercardnum =", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotEqualTo(String value) {
            addCriterion("usercardnum <>", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumGreaterThan(String value) {
            addCriterion("usercardnum >", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumGreaterThanOrEqualTo(String value) {
            addCriterion("usercardnum >=", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLessThan(String value) {
            addCriterion("usercardnum <", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLessThanOrEqualTo(String value) {
            addCriterion("usercardnum <=", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLike(String value) {
            addCriterion("usercardnum like", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotLike(String value) {
            addCriterion("usercardnum not like", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIn(List<String> values) {
            addCriterion("usercardnum in", values, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotIn(List<String> values) {
            addCriterion("usercardnum not in", values, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumBetween(String value1, String value2) {
            addCriterion("usercardnum between", value1, value2, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotBetween(String value1, String value2) {
            addCriterion("usercardnum not between", value1, value2, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUserroleidIsNull() {
            addCriterion("userroleid is null");
            return (Criteria) this;
        }

        public Criteria andUserroleidIsNotNull() {
            addCriterion("userroleid is not null");
            return (Criteria) this;
        }

        public Criteria andUserroleidEqualTo(Integer value) {
            addCriterion("userroleid =", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotEqualTo(Integer value) {
            addCriterion("userroleid <>", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidGreaterThan(Integer value) {
            addCriterion("userroleid >", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userroleid >=", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidLessThan(Integer value) {
            addCriterion("userroleid <", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidLessThanOrEqualTo(Integer value) {
            addCriterion("userroleid <=", value, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidIn(List<Integer> values) {
            addCriterion("userroleid in", values, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotIn(List<Integer> values) {
            addCriterion("userroleid not in", values, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidBetween(Integer value1, Integer value2) {
            addCriterion("userroleid between", value1, value2, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserroleidNotBetween(Integer value1, Integer value2) {
            addCriterion("userroleid not between", value1, value2, "userroleid");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userphone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userphone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userphone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userphone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userphone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userphone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userphone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userphone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userphone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userphone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userphone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userphone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userphone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userphone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserstateIsNull() {
            addCriterion("userState is null");
            return (Criteria) this;
        }

        public Criteria andUserstateIsNotNull() {
            addCriterion("userState is not null");
            return (Criteria) this;
        }

        public Criteria andUserstateEqualTo(String value) {
            addCriterion("userState =", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotEqualTo(String value) {
            addCriterion("userState <>", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateGreaterThan(String value) {
            addCriterion("userState >", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateGreaterThanOrEqualTo(String value) {
            addCriterion("userState >=", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLessThan(String value) {
            addCriterion("userState <", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLessThanOrEqualTo(String value) {
            addCriterion("userState <=", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateLike(String value) {
            addCriterion("userState like", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotLike(String value) {
            addCriterion("userState not like", value, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateIn(List<String> values) {
            addCriterion("userState in", values, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotIn(List<String> values) {
            addCriterion("userState not in", values, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateBetween(String value1, String value2) {
            addCriterion("userState between", value1, value2, "userstate");
            return (Criteria) this;
        }

        public Criteria andUserstateNotBetween(String value1, String value2) {
            addCriterion("userState not between", value1, value2, "userstate");
            return (Criteria) this;
        }

        public Criteria andRegemailIsNull() {
            addCriterion("regEmail is null");
            return (Criteria) this;
        }

        public Criteria andRegemailIsNotNull() {
            addCriterion("regEmail is not null");
            return (Criteria) this;
        }

        public Criteria andRegemailEqualTo(String value) {
            addCriterion("regEmail =", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailNotEqualTo(String value) {
            addCriterion("regEmail <>", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailGreaterThan(String value) {
            addCriterion("regEmail >", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailGreaterThanOrEqualTo(String value) {
            addCriterion("regEmail >=", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailLessThan(String value) {
            addCriterion("regEmail <", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailLessThanOrEqualTo(String value) {
            addCriterion("regEmail <=", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailLike(String value) {
            addCriterion("regEmail like", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailNotLike(String value) {
            addCriterion("regEmail not like", value, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailIn(List<String> values) {
            addCriterion("regEmail in", values, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailNotIn(List<String> values) {
            addCriterion("regEmail not in", values, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailBetween(String value1, String value2) {
            addCriterion("regEmail between", value1, value2, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegemailNotBetween(String value1, String value2) {
            addCriterion("regEmail not between", value1, value2, "regemail");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNull() {
            addCriterion("regDate is null");
            return (Criteria) this;
        }

        public Criteria andRegdateIsNotNull() {
            addCriterion("regDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegdateEqualTo(String value) {
            addCriterion("regDate =", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotEqualTo(String value) {
            addCriterion("regDate <>", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThan(String value) {
            addCriterion("regDate >", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateGreaterThanOrEqualTo(String value) {
            addCriterion("regDate >=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThan(String value) {
            addCriterion("regDate <", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLessThanOrEqualTo(String value) {
            addCriterion("regDate <=", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateLike(String value) {
            addCriterion("regDate like", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotLike(String value) {
            addCriterion("regDate not like", value, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateIn(List<String> values) {
            addCriterion("regDate in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotIn(List<String> values) {
            addCriterion("regDate not in", values, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateBetween(String value1, String value2) {
            addCriterion("regDate between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegdateNotBetween(String value1, String value2) {
            addCriterion("regDate not between", value1, value2, "regdate");
            return (Criteria) this;
        }

        public Criteria andRegipIsNull() {
            addCriterion("regIp is null");
            return (Criteria) this;
        }

        public Criteria andRegipIsNotNull() {
            addCriterion("regIp is not null");
            return (Criteria) this;
        }

        public Criteria andRegipEqualTo(String value) {
            addCriterion("regIp =", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipNotEqualTo(String value) {
            addCriterion("regIp <>", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipGreaterThan(String value) {
            addCriterion("regIp >", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipGreaterThanOrEqualTo(String value) {
            addCriterion("regIp >=", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipLessThan(String value) {
            addCriterion("regIp <", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipLessThanOrEqualTo(String value) {
            addCriterion("regIp <=", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipLike(String value) {
            addCriterion("regIp like", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipNotLike(String value) {
            addCriterion("regIp not like", value, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipIn(List<String> values) {
            addCriterion("regIp in", values, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipNotIn(List<String> values) {
            addCriterion("regIp not in", values, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipBetween(String value1, String value2) {
            addCriterion("regIp between", value1, value2, "regip");
            return (Criteria) this;
        }

        public Criteria andRegipNotBetween(String value1, String value2) {
            addCriterion("regIp not between", value1, value2, "regip");
            return (Criteria) this;
        }

        public Criteria andRegdomainIsNull() {
            addCriterion("regdomain is null");
            return (Criteria) this;
        }

        public Criteria andRegdomainIsNotNull() {
            addCriterion("regdomain is not null");
            return (Criteria) this;
        }

        public Criteria andRegdomainEqualTo(String value) {
            addCriterion("regdomain =", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainNotEqualTo(String value) {
            addCriterion("regdomain <>", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainGreaterThan(String value) {
            addCriterion("regdomain >", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainGreaterThanOrEqualTo(String value) {
            addCriterion("regdomain >=", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainLessThan(String value) {
            addCriterion("regdomain <", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainLessThanOrEqualTo(String value) {
            addCriterion("regdomain <=", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainLike(String value) {
            addCriterion("regdomain like", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainNotLike(String value) {
            addCriterion("regdomain not like", value, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainIn(List<String> values) {
            addCriterion("regdomain in", values, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainNotIn(List<String> values) {
            addCriterion("regdomain not in", values, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainBetween(String value1, String value2) {
            addCriterion("regdomain between", value1, value2, "regdomain");
            return (Criteria) this;
        }

        public Criteria andRegdomainNotBetween(String value1, String value2) {
            addCriterion("regdomain not between", value1, value2, "regdomain");
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