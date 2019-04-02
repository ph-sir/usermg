package com.pengh.usermg.dao;

import com.pengh.usermg.entity.Group;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    int insertSelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    Group selectByPrimaryKey(Long groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Group record);
}