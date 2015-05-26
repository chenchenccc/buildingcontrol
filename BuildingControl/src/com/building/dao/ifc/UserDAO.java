package com.building.dao.ifc;

import com.building.model.User;
import com.building.model.UserExample;
import java.util.List;

public interface UserDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    void insert(User record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    void insertSelective(User record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    List selectByExample(UserExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByExampleSelective(User record, UserExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByExample(User record, UserExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user
     *
     * @ibatorgenerated Tue May 26 21:29:16 CST 2015
     */
    int updateByPrimaryKey(User record);
}