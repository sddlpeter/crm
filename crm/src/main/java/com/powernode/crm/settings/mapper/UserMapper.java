package com.powernode.crm.settings.mapper;

import com.powernode.crm.settings.domain.User;

import java.util.Map;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    User selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_user
     *
     * @mbg.generated Tue Jul 11 17:15:40 PDT 2023
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据账户名和密码来查询数据库
     * @param map
     * @return
     */
    User selectUserByLoginActAndPwd(Map<String, Object> map);
}