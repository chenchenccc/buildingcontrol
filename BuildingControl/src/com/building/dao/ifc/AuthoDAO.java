package com.building.dao.ifc;

import com.building.model.Autho;
import com.building.model.AuthoExample;
import java.util.List;

public interface AuthoDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int countByExample(AuthoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int deleteByExample(AuthoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    void insert(Autho record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    void insertSelective(Autho record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    List selectByExample(AuthoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    Autho selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int updateByExampleSelective(Autho record, AuthoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int updateByExample(Autho record, AuthoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int updateByPrimaryKeySelective(Autho record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table autho
     *
     * @ibatorgenerated Tue Jun 02 23:04:46 CST 2015
     */
    int updateByPrimaryKey(Autho record);
}