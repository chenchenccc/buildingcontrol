package com.building.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public UserExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    protected UserExample(UserExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table user
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List dateList = new ArrayList();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(((Date)iter.next()).getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return this;
        }

        public Criteria andUsernameIn(List values) {
            addCriterion("username in", values, "username");
            return this;
        }

        public Criteria andUsernameNotIn(List values) {
            addCriterion("username not in", values, "username");
            return this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return this;
        }

        public Criteria andPasswordIn(List values) {
            addCriterion("password in", values, "password");
            return this;
        }

        public Criteria andPasswordNotIn(List values) {
            addCriterion("password not in", values, "password");
            return this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return this;
        }

        public Criteria andLastLoginEqualTo(Date value) {
            addCriterionForJDBCDate("last_login =", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_login <>", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            addCriterionForJDBCDate("last_login >", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_login >=", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginLessThan(Date value) {
            addCriterionForJDBCDate("last_login <", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_login <=", value, "lastLogin");
            return this;
        }

        public Criteria andLastLoginIn(List values) {
            addCriterionForJDBCDate("last_login in", values, "lastLogin");
            return this;
        }

        public Criteria andLastLoginNotIn(List values) {
            addCriterionForJDBCDate("last_login not in", values, "lastLogin");
            return this;
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_login between", value1, value2, "lastLogin");
            return this;
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_login not between", value1, value2, "lastLogin");
            return this;
        }

        public Criteria andIsOnlineIsNull() {
            addCriterion("is_online is null");
            return this;
        }

        public Criteria andIsOnlineIsNotNull() {
            addCriterion("is_online is not null");
            return this;
        }

        public Criteria andIsOnlineEqualTo(Long value) {
            addCriterion("is_online =", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineNotEqualTo(Long value) {
            addCriterion("is_online <>", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineGreaterThan(Long value) {
            addCriterion("is_online >", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineGreaterThanOrEqualTo(Long value) {
            addCriterion("is_online >=", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineLessThan(Long value) {
            addCriterion("is_online <", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineLessThanOrEqualTo(Long value) {
            addCriterion("is_online <=", value, "isOnline");
            return this;
        }

        public Criteria andIsOnlineIn(List values) {
            addCriterion("is_online in", values, "isOnline");
            return this;
        }

        public Criteria andIsOnlineNotIn(List values) {
            addCriterion("is_online not in", values, "isOnline");
            return this;
        }

        public Criteria andIsOnlineBetween(Long value1, Long value2) {
            addCriterion("is_online between", value1, value2, "isOnline");
            return this;
        }

        public Criteria andIsOnlineNotBetween(Long value1, Long value2) {
            addCriterion("is_online not between", value1, value2, "isOnline");
            return this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return this;
        }

        public Criteria andIsDelIn(List values) {
            addCriterion("is_del in", values, "isDel");
            return this;
        }

        public Criteria andIsDelNotIn(List values) {
            addCriterion("is_del not in", values, "isDel");
            return this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return this;
        }
    }
}