package com.building.dao.impl;

import com.building.dao.ifc.AuthoDAO;
import com.building.model.Autho;
import com.building.model.AuthoExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AuthoDAOImpl extends SqlMapClientDaoSupport implements AuthoDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public AuthoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int countByExample(AuthoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("autho.ibatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int deleteByExample(AuthoExample example) {
        int rows = getSqlMapClientTemplate().delete("autho.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int deleteByPrimaryKey(Integer id) {
        Autho key = new Autho();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("autho.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public void insert(Autho record) {
        getSqlMapClientTemplate().insert("autho.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public void insertSelective(Autho record) {
        getSqlMapClientTemplate().insert("autho.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public List selectByExample(AuthoExample example) {
        List list = getSqlMapClientTemplate().queryForList("autho.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public Autho selectByPrimaryKey(Integer id) {
        Autho key = new Autho();
        key.setId(id);
        Autho record = (Autho) getSqlMapClientTemplate().queryForObject("autho.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int updateByExampleSelective(Autho record, AuthoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("autho.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int updateByExample(Autho record, AuthoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("autho.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int updateByPrimaryKeySelective(Autho record) {
        int rows = getSqlMapClientTemplate().update("autho.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    public int updateByPrimaryKey(Autho record) {
        int rows = getSqlMapClientTemplate().update("autho.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    private static class UpdateByExampleParms extends AuthoExample {
        private Object record;

        public UpdateByExampleParms(Object record, AuthoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}