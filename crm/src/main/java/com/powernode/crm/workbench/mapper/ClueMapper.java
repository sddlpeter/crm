package com.powernode.crm.workbench.mapper;

import com.powernode.crm.workbench.domain.Clue;

public interface ClueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    int insert(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    int insertSelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    Clue selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    int updateByPrimaryKeySelective(Clue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_clue
     *
     * @mbg.generated Wed Jul 26 16:01:31 PDT 2023
     */
    int updateByPrimaryKey(Clue record);

    int insertClue(Clue clue);

    Clue selectClueForDetailById(String id);
}