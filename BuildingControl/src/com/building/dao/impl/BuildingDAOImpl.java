package com.building.dao.impl;

import com.building.dao.ifc.BuildingDAO;
import com.building.model.Building;
import com.building.model.BuildingExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BuildingDAOImpl extends SqlMapClientDaoSupport implements BuildingDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public BuildingDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int countByExample(BuildingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("building.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int deleteByExample(BuildingExample example) {
        int rows = getSqlMapClientTemplate().delete("building.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int deleteByPrimaryKey(Integer id) {
        Building key = new Building();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("building.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public void insert(Building record) {
        getSqlMapClientTemplate().insert("building.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public void insertSelective(Building record) {
        getSqlMapClientTemplate().insert("building.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public List selectByExample(BuildingExample example) {
        List list = getSqlMapClientTemplate().queryForList("building.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public Building selectByPrimaryKey(Integer id) {
        Building key = new Building();
        key.setId(id);
        Building record = (Building) getSqlMapClientTemplate().queryForObject("building.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int updateByExampleSelective(Building record, BuildingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("building.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int updateByExample(Building record, BuildingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("building.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int updateByPrimaryKeySelective(Building record) {
        int rows = getSqlMapClientTemplate().update("building.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    public int updateByPrimaryKey(Building record) {
        int rows = getSqlMapClientTemplate().update("building.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table building
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    private static class UpdateByExampleParms extends BuildingExample {
        private Object record;

        public UpdateByExampleParms(Object record, BuildingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}