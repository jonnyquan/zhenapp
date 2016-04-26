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

        public Criteria andTaskdetailidEqualTo(Integer value) {
            addCriterion("taskdetailid =", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotEqualTo(Integer value) {
            addCriterion("taskdetailid <>", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidGreaterThan(Integer value) {
            addCriterion("taskdetailid >", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskdetailid >=", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidLessThan(Integer value) {
            addCriterion("taskdetailid <", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidLessThanOrEqualTo(Integer value) {
            addCriterion("taskdetailid <=", value, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidIn(List<Integer> values) {
            addCriterion("taskdetailid in", values, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotIn(List<Integer> values) {
            addCriterion("taskdetailid not in", values, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidBetween(Integer value1, Integer value2) {
            addCriterion("taskdetailid between", value1, value2, "taskdetailid");
            return (Criteria) this;
        }

        public Criteria andTaskdetailidNotBetween(Integer value1, Integer value2) {
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

        public Criteria andTaskidEqualTo(Integer value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Integer value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Integer value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Integer value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Integer value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Integer> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Integer> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Integer value1, Integer value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Integer value1, Integer value2) {
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

        public Criteria andIscollectionIsNull() {
            addCriterion("ISCollection is null");
            return (Criteria) this;
        }

        public Criteria andIscollectionIsNotNull() {
            addCriterion("ISCollection is not null");
            return (Criteria) this;
        }

        public Criteria andIscollectionEqualTo(String value) {
            addCriterion("ISCollection =", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotEqualTo(String value) {
            addCriterion("ISCollection <>", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionGreaterThan(String value) {
            addCriterion("ISCollection >", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionGreaterThanOrEqualTo(String value) {
            addCriterion("ISCollection >=", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLessThan(String value) {
            addCriterion("ISCollection <", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLessThanOrEqualTo(String value) {
            addCriterion("ISCollection <=", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionLike(String value) {
            addCriterion("ISCollection like", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotLike(String value) {
            addCriterion("ISCollection not like", value, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionIn(List<String> values) {
            addCriterion("ISCollection in", values, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotIn(List<String> values) {
            addCriterion("ISCollection not in", values, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionBetween(String value1, String value2) {
            addCriterion("ISCollection between", value1, value2, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIscollectionNotBetween(String value1, String value2) {
            addCriterion("ISCollection not between", value1, value2, "iscollection");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIsNull() {
            addCriterion("ISShopping is null");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIsNotNull() {
            addCriterion("ISShopping is not null");
            return (Criteria) this;
        }

        public Criteria andIsshoppingEqualTo(String value) {
            addCriterion("ISShopping =", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotEqualTo(String value) {
            addCriterion("ISShopping <>", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingGreaterThan(String value) {
            addCriterion("ISShopping >", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingGreaterThanOrEqualTo(String value) {
            addCriterion("ISShopping >=", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLessThan(String value) {
            addCriterion("ISShopping <", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLessThanOrEqualTo(String value) {
            addCriterion("ISShopping <=", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingLike(String value) {
            addCriterion("ISShopping like", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotLike(String value) {
            addCriterion("ISShopping not like", value, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingIn(List<String> values) {
            addCriterion("ISShopping in", values, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotIn(List<String> values) {
            addCriterion("ISShopping not in", values, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingBetween(String value1, String value2) {
            addCriterion("ISShopping between", value1, value2, "isshopping");
            return (Criteria) this;
        }

        public Criteria andIsshoppingNotBetween(String value1, String value2) {
            addCriterion("ISShopping not between", value1, value2, "isshopping");
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

        public Criteria andTaskcountIsNull() {
            addCriterion("taskcount is null");
            return (Criteria) this;
        }

        public Criteria andTaskcountIsNotNull() {
            addCriterion("taskcount is not null");
            return (Criteria) this;
        }

        public Criteria andTaskcountEqualTo(String value) {
            addCriterion("taskcount =", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountNotEqualTo(String value) {
            addCriterion("taskcount <>", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountGreaterThan(String value) {
            addCriterion("taskcount >", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountGreaterThanOrEqualTo(String value) {
            addCriterion("taskcount >=", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountLessThan(String value) {
            addCriterion("taskcount <", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountLessThanOrEqualTo(String value) {
            addCriterion("taskcount <=", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountLike(String value) {
            addCriterion("taskcount like", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountNotLike(String value) {
            addCriterion("taskcount not like", value, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountIn(List<String> values) {
            addCriterion("taskcount in", values, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountNotIn(List<String> values) {
            addCriterion("taskcount not in", values, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountBetween(String value1, String value2) {
            addCriterion("taskcount between", value1, value2, "taskcount");
            return (Criteria) this;
        }

        public Criteria andTaskcountNotBetween(String value1, String value2) {
            addCriterion("taskcount not between", value1, value2, "taskcount");
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