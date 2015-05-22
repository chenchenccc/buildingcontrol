package com.building.dao.impl;

import com.building.dao.ifc.DeviceDAO;
import com.building.model.Device;
import com.building.model.DeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeviceDAOImpl extends SqlMapClientDaoSupport implements DeviceDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public DeviceDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int countByExample(DeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("device.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int deleteByExample(DeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("device.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int deleteByPrimaryKey(Integer id) {
        Device key = new Device();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("device.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void insert(Device record) {
        getSqlMapClientTemplate().insert("device.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void insertSelective(Device record) {
        getSqlMapClientTemplate().insert("device.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public List selectByExample(DeviceExample example) {
        List list = getSqlMapClientTemplate().queryForList("device.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Device selectByPrimaryKey(Integer id) {
        Device key = new Device();
        key.setId(id);
        Device record = (Device) getSqlMapClientTemplate().queryForObject("device.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByExampleSelective(Device record, DeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("device.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByExample(Device record, DeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("device.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByPrimaryKeySelective(Device record) {
        int rows = getSqlMapClientTemplate().update("device.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public int updateByPrimaryKey(Device record) {
        int rows = getSqlMapClientTemplate().update("device.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table device
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private static class UpdateByExampleParms extends DeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, DeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}