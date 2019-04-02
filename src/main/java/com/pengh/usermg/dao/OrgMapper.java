package com.pengh.usermg.dao;

import com.pengh.usermg.entity.Org;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    int insert(Org record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    int insertSelective(Org record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    Org selectByPrimaryKey(Long orgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Org record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_org
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Org record);

    List<Org> selectAll(String orgName);
}