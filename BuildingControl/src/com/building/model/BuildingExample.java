package com.building.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Iterator;

public class BuildingExample {
    protected int limitStart = 0;
    protected int limitEnd = 20;
    
    public int getLimitStart() {
        return limitStart;
    }

    
    public void setLimitStart( int limitStart ) {
        this.limitStart = limitStart;
    }

    
    public int getLimitEnd() {
        return limitEnd;
    }

    
    public void setLimitEnd( int limitEnd ) {
        this.limitEnd = limitEnd;
    }
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    protected String orderByClause;
    /**
     * This field was generated by Apache iBATIS ibator. This field corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public BuildingExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    protected BuildingExample( BuildingExample example ) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public void setOrderByClause( String orderByClause ) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public void or( Criteria criteria ) {
        oredCriteria.add( criteria );
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add( criteria );
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator. This class corresponds to the database table building
     * @ibatorgenerated  Tue May 26 21:29:16 CST 2015
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
            return criteriaWithoutValue.size() > 0 || criteriaWithSingleValue.size() > 0
                    || criteriaWithListValue.size() > 0 || criteriaWithBetweenValue.size() > 0;
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
        
        protected void addCriterion( String condition ) {
            if (condition == null) {
                throw new RuntimeException( "Value for condition cannot be null" );
            }
            criteriaWithoutValue.add( condition );
        }
        
        protected void addCriterion( String condition, Object value, String property ) {
            if (value == null) {
                throw new RuntimeException( "Value for " + property + " cannot be null" );
            }
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "value", value );
            criteriaWithSingleValue.add( map );
        }
        
        protected void addCriterion( String condition, List values, String property ) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException( "Value list for " + property
                        + " cannot be null or empty" );
            }
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "values", values );
            criteriaWithListValue.add( map );
        }
        
        protected void addCriterion( String condition, Object value1, Object value2, String property ) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException( "Between values for " + property + " cannot be null" );
            }
            List list = new ArrayList();
            list.add( value1 );
            list.add( value2 );
            Map map = new HashMap();
            map.put( "condition", condition );
            map.put( "values", list );
            criteriaWithBetweenValue.add( map );
        }
        
        protected void addCriterionForJDBCDate( String condition, Date value, String property ) {
            addCriterion( condition, new java.sql.Date( value.getTime() ), property );
        }
        
        protected void addCriterionForJDBCDate( String condition, List values, String property ) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException( "Value list for " + property
                        + " cannot be null or empty" );
            }
            List dateList = new ArrayList();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add( new java.sql.Date( ((Date) iter.next()).getTime() ) );
            }
            addCriterion( condition, dateList, property );
        }
        
        protected void addCriterionForJDBCDate( String condition, Date value1, Date value2,
                String property ) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException( "Between values for " + property + " cannot be null" );
            }
            addCriterion( condition, new java.sql.Date( value1.getTime() ), new java.sql.Date(
                    value2.getTime() ), property );
        }
        
        public Criteria andIdIsNull() {
            addCriterion( "id is null" );
            return this;
        }
        
        public Criteria andIdIsNotNull() {
            addCriterion( "id is not null" );
            return this;
        }
        
        public Criteria andIdEqualTo( Integer value ) {
            addCriterion( "id =", value, "id" );
            return this;
        }
        
        public Criteria andIdNotEqualTo( Integer value ) {
            addCriterion( "id <>", value, "id" );
            return this;
        }
        
        public Criteria andIdGreaterThan( Integer value ) {
            addCriterion( "id >", value, "id" );
            return this;
        }
        
        public Criteria andIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "id >=", value, "id" );
            return this;
        }
        
        public Criteria andIdLessThan( Integer value ) {
            addCriterion( "id <", value, "id" );
            return this;
        }
        
        public Criteria andIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "id <=", value, "id" );
            return this;
        }
        
        public Criteria andIdIn( List values ) {
            addCriterion( "id in", values, "id" );
            return this;
        }
        
        public Criteria andIdNotIn( List values ) {
            addCriterion( "id not in", values, "id" );
            return this;
        }
        
        public Criteria andIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "id between", value1, value2, "id" );
            return this;
        }
        
        public Criteria andIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "id not between", value1, value2, "id" );
            return this;
        }
        
        public Criteria andBuildingNameIsNull() {
            addCriterion( "building_name is null" );
            return this;
        }
        
        public Criteria andBuildingNameIsNotNull() {
            addCriterion( "building_name is not null" );
            return this;
        }
        
        public Criteria andBuildingNameEqualTo( String value ) {
            addCriterion( "building_name =", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameNotEqualTo( String value ) {
            addCriterion( "building_name <>", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameGreaterThan( String value ) {
            addCriterion( "building_name >", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameGreaterThanOrEqualTo( String value ) {
            addCriterion( "building_name >=", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameLessThan( String value ) {
            addCriterion( "building_name <", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameLessThanOrEqualTo( String value ) {
            addCriterion( "building_name <=", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameLike( String value ) {
            addCriterion( "building_name like", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameNotLike( String value ) {
            addCriterion( "building_name not like", value, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameIn( List values ) {
            addCriterion( "building_name in", values, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameNotIn( List values ) {
            addCriterion( "building_name not in", values, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameBetween( String value1, String value2 ) {
            addCriterion( "building_name between", value1, value2, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingNameNotBetween( String value1, String value2 ) {
            addCriterion( "building_name not between", value1, value2, "buildingName" );
            return this;
        }
        
        public Criteria andBuildingTypeIsNull() {
            addCriterion( "building_type is null" );
            return this;
        }
        
        public Criteria andBuildingTypeIsNotNull() {
            addCriterion( "building_type is not null" );
            return this;
        }
        
        public Criteria andBuildingTypeEqualTo( Integer value ) {
            addCriterion( "building_type =", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeNotEqualTo( Integer value ) {
            addCriterion( "building_type <>", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeGreaterThan( Integer value ) {
            addCriterion( "building_type >", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "building_type >=", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeLessThan( Integer value ) {
            addCriterion( "building_type <", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeLessThanOrEqualTo( Integer value ) {
            addCriterion( "building_type <=", value, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeIn( List values ) {
            addCriterion( "building_type in", values, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeNotIn( List values ) {
            addCriterion( "building_type not in", values, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeBetween( Integer value1, Integer value2 ) {
            addCriterion( "building_type between", value1, value2, "buildingType" );
            return this;
        }
        
        public Criteria andBuildingTypeNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "building_type not between", value1, value2, "buildingType" );
            return this;
        }
        
        public Criteria andSuperIdIsNull() {
            addCriterion( "super_id is null" );
            return this;
        }
        
        public Criteria andSuperIdIsNotNull() {
            addCriterion( "super_id is not null" );
            return this;
        }
        
        public Criteria andSuperIdEqualTo( Integer value ) {
            addCriterion( "super_id =", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdNotEqualTo( Integer value ) {
            addCriterion( "super_id <>", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdGreaterThan( Integer value ) {
            addCriterion( "super_id >", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "super_id >=", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdLessThan( Integer value ) {
            addCriterion( "super_id <", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "super_id <=", value, "superId" );
            return this;
        }
        
        public Criteria andSuperIdIn( List values ) {
            addCriterion( "super_id in", values, "superId" );
            return this;
        }
        
        public Criteria andSuperIdNotIn( List values ) {
            addCriterion( "super_id not in", values, "superId" );
            return this;
        }
        
        public Criteria andSuperIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "super_id between", value1, value2, "superId" );
            return this;
        }
        
        public Criteria andSuperIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "super_id not between", value1, value2, "superId" );
            return this;
        }
        
        public Criteria andIsDelIsNull() {
            addCriterion( "is_del is null" );
            return this;
        }
        
        public Criteria andIsDelIsNotNull() {
            addCriterion( "is_del is not null" );
            return this;
        }
        
        public Criteria andIsDelEqualTo( Integer value ) {
            addCriterion( "is_del =", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotEqualTo( Integer value ) {
            addCriterion( "is_del <>", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelGreaterThan( Integer value ) {
            addCriterion( "is_del >", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "is_del >=", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelLessThan( Integer value ) {
            addCriterion( "is_del <", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelLessThanOrEqualTo( Integer value ) {
            addCriterion( "is_del <=", value, "isDel" );
            return this;
        }
        
        public Criteria andIsDelIn( List values ) {
            addCriterion( "is_del in", values, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotIn( List values ) {
            addCriterion( "is_del not in", values, "isDel" );
            return this;
        }
        
        public Criteria andIsDelBetween( Integer value1, Integer value2 ) {
            addCriterion( "is_del between", value1, value2, "isDel" );
            return this;
        }
        
        public Criteria andIsDelNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "is_del not between", value1, value2, "isDel" );
            return this;
        }
        
        public Criteria andCenterLatIsNull() {
            addCriterion( "center_lat is null" );
            return this;
        }
        
        public Criteria andCenterLatIsNotNull() {
            addCriterion( "center_lat is not null" );
            return this;
        }
        
        public Criteria andCenterLatEqualTo( Double value ) {
            addCriterion( "center_lat =", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatNotEqualTo( Double value ) {
            addCriterion( "center_lat <>", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatGreaterThan( Double value ) {
            addCriterion( "center_lat >", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatGreaterThanOrEqualTo( Double value ) {
            addCriterion( "center_lat >=", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatLessThan( Double value ) {
            addCriterion( "center_lat <", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatLessThanOrEqualTo( Double value ) {
            addCriterion( "center_lat <=", value, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatIn( List values ) {
            addCriterion( "center_lat in", values, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatNotIn( List values ) {
            addCriterion( "center_lat not in", values, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatBetween( Double value1, Double value2 ) {
            addCriterion( "center_lat between", value1, value2, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLatNotBetween( Double value1, Double value2 ) {
            addCriterion( "center_lat not between", value1, value2, "centerLat" );
            return this;
        }
        
        public Criteria andCenterLngIsNull() {
            addCriterion( "center_lng is null" );
            return this;
        }
        
        public Criteria andCenterLngIsNotNull() {
            addCriterion( "center_lng is not null" );
            return this;
        }
        
        public Criteria andCenterLngEqualTo( Double value ) {
            addCriterion( "center_lng =", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngNotEqualTo( Double value ) {
            addCriterion( "center_lng <>", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngGreaterThan( Double value ) {
            addCriterion( "center_lng >", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngGreaterThanOrEqualTo( Double value ) {
            addCriterion( "center_lng >=", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngLessThan( Double value ) {
            addCriterion( "center_lng <", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngLessThanOrEqualTo( Double value ) {
            addCriterion( "center_lng <=", value, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngIn( List values ) {
            addCriterion( "center_lng in", values, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngNotIn( List values ) {
            addCriterion( "center_lng not in", values, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngBetween( Double value1, Double value2 ) {
            addCriterion( "center_lng between", value1, value2, "centerLng" );
            return this;
        }
        
        public Criteria andCenterLngNotBetween( Double value1, Double value2 ) {
            addCriterion( "center_lng not between", value1, value2, "centerLng" );
            return this;
        }
        
        public Criteria andCreateUserIdIsNull() {
            addCriterion( "create_user_id is null" );
            return this;
        }
        
        public Criteria andCreateUserIdIsNotNull() {
            addCriterion( "create_user_id is not null" );
            return this;
        }
        
        public Criteria andCreateUserIdEqualTo( Integer value ) {
            addCriterion( "create_user_id =", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdNotEqualTo( Integer value ) {
            addCriterion( "create_user_id <>", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdGreaterThan( Integer value ) {
            addCriterion( "create_user_id >", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "create_user_id >=", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdLessThan( Integer value ) {
            addCriterion( "create_user_id <", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "create_user_id <=", value, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdIn( List values ) {
            addCriterion( "create_user_id in", values, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdNotIn( List values ) {
            addCriterion( "create_user_id not in", values, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "create_user_id between", value1, value2, "createUserId" );
            return this;
        }
        
        public Criteria andCreateUserIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "create_user_id not between", value1, value2, "createUserId" );
            return this;
        }
        
        public Criteria andCreateTimeIsNull() {
            addCriterion( "create_time is null" );
            return this;
        }
        
        public Criteria andCreateTimeIsNotNull() {
            addCriterion( "create_time is not null" );
            return this;
        }
        
        public Criteria andCreateTimeEqualTo( Date value ) {
            addCriterionForJDBCDate( "create_time =", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeNotEqualTo( Date value ) {
            addCriterionForJDBCDate( "create_time <>", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeGreaterThan( Date value ) {
            addCriterionForJDBCDate( "create_time >", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeGreaterThanOrEqualTo( Date value ) {
            addCriterionForJDBCDate( "create_time >=", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeLessThan( Date value ) {
            addCriterionForJDBCDate( "create_time <", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeLessThanOrEqualTo( Date value ) {
            addCriterionForJDBCDate( "create_time <=", value, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeIn( List values ) {
            addCriterionForJDBCDate( "create_time in", values, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeNotIn( List values ) {
            addCriterionForJDBCDate( "create_time not in", values, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeBetween( Date value1, Date value2 ) {
            addCriterionForJDBCDate( "create_time between", value1, value2, "createTime" );
            return this;
        }
        
        public Criteria andCreateTimeNotBetween( Date value1, Date value2 ) {
            addCriterionForJDBCDate( "create_time not between", value1, value2, "createTime" );
            return this;
        }
        
        public Criteria andUpdateUserIdIsNull() {
            addCriterion( "update_user_id is null" );
            return this;
        }
        
        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion( "update_user_id is not null" );
            return this;
        }
        
        public Criteria andUpdateUserIdEqualTo( Integer value ) {
            addCriterion( "update_user_id =", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdNotEqualTo( Integer value ) {
            addCriterion( "update_user_id <>", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdGreaterThan( Integer value ) {
            addCriterion( "update_user_id >", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdGreaterThanOrEqualTo( Integer value ) {
            addCriterion( "update_user_id >=", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdLessThan( Integer value ) {
            addCriterion( "update_user_id <", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdLessThanOrEqualTo( Integer value ) {
            addCriterion( "update_user_id <=", value, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdIn( List values ) {
            addCriterion( "update_user_id in", values, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdNotIn( List values ) {
            addCriterion( "update_user_id not in", values, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdBetween( Integer value1, Integer value2 ) {
            addCriterion( "update_user_id between", value1, value2, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateUserIdNotBetween( Integer value1, Integer value2 ) {
            addCriterion( "update_user_id not between", value1, value2, "updateUserId" );
            return this;
        }
        
        public Criteria andUpdateTimeIsNull() {
            addCriterion( "update_time is null" );
            return this;
        }
        
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion( "update_time is not null" );
            return this;
        }
        
        public Criteria andUpdateTimeEqualTo( Date value ) {
            addCriterionForJDBCDate( "update_time =", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeNotEqualTo( Date value ) {
            addCriterionForJDBCDate( "update_time <>", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeGreaterThan( Date value ) {
            addCriterionForJDBCDate( "update_time >", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeGreaterThanOrEqualTo( Date value ) {
            addCriterionForJDBCDate( "update_time >=", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeLessThan( Date value ) {
            addCriterionForJDBCDate( "update_time <", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeLessThanOrEqualTo( Date value ) {
            addCriterionForJDBCDate( "update_time <=", value, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeIn( List values ) {
            addCriterionForJDBCDate( "update_time in", values, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeNotIn( List values ) {
            addCriterionForJDBCDate( "update_time not in", values, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeBetween( Date value1, Date value2 ) {
            addCriterionForJDBCDate( "update_time between", value1, value2, "updateTime" );
            return this;
        }
        
        public Criteria andUpdateTimeNotBetween( Date value1, Date value2 ) {
            addCriterionForJDBCDate( "update_time not between", value1, value2, "updateTime" );
            return this;
        }
    }
}