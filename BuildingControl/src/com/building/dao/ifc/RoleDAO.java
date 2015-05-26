package com.building.dao.ifc;

import com.building.model.Role;
import com.building.model.RoleExample;
import java.util.List;

public interface RoleDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int countByExample(RoleExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    void insert(Role record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    void insertSelective(Role record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    List selectByExample(RoleExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByExampleSelective(Role record, RoleExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByExample(Role record, RoleExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table role
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByPrimaryKey(Role record);
}