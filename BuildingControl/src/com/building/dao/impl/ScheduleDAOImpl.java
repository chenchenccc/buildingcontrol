package com.building.dao.impl;

import com.building.dao.ifc.ScheduleDAO;
import com.building.model.Schedule;
import com.building.model.ScheduleExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ScheduleDAOImpl extends SqlMapClientDaoSupport implements ScheduleDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public ScheduleDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int countByExample(ScheduleExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("schedule.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int deleteByExample(ScheduleExample example) {
        int rows = getSqlMapClientTemplate().delete("schedule.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int deleteByPrimaryKey(Integer id) {
        Schedule key = new Schedule();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("schedule.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void insert(Schedule record) {
        getSqlMapClientTemplate().insert("schedule.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void insertSelective(Schedule record) {
        getSqlMapClientTemplate().insert("schedule.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public List selectByExample(ScheduleExample example) {
        List list = getSqlMapClientTemplate().queryForList("schedule.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Schedule selectByPrimaryKey(Integer id) {
        Schedule key = new Schedule();
        key.setId(id);
        Schedule record = (Schedule) getSqlMapClientTemplate().queryForObject("schedule.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByExampleSelective(Schedule record, ScheduleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("schedule.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByExample(Schedule record, ScheduleExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("schedule.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByPrimaryKeySelective(Schedule record) {
        int rows = getSqlMapClientTemplate().update("schedule.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByPrimaryKey(Schedule record) {
        int rows = getSqlMapClientTemplate().update("schedule.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table schedule
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private static class UpdateByExampleParms extends ScheduleExample {
        private Object record;

        public UpdateByExampleParms(Object record, ScheduleExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}