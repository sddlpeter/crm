package com.powernode.crm.workbench.mapper;

import com.powernode.crm.workbench.domain.Activity;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Sat Jul 15 10:21:01 PDT 2023
     */
    int deleteByPrimaryKey(String id);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Sat Jul 15 10:21:01 PDT 2023
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Sat Jul 15 10:21:01 PDT 2023
     */
    Activity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Sat Jul 15 10:21:01 PDT 2023
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbg.generated Sat Jul 15 10:21:01 PDT 2023
     */
    int updateByPrimaryKey(Activity record);

    /**
     * 保存创建的市场活动
     */
    int insertActivity(Activity activity);
}