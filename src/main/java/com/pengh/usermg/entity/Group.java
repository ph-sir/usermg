package com.pengh.usermg.entity;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_group
 */
public class Group {
    /**
     * Database Column Remarks:
     *   组ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.group_id
     *
     * @mbg.generated
     */
    private Long groupId;

    /**
     * Database Column Remarks:
     *   父组
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.p_group_id
     *
     * @mbg.generated
     */
    private Long pGroupId;

    /**
     * Database Column Remarks:
     *   组名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.group_name
     *
     * @mbg.generated
     */
    private String groupName;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.gen_time
     *
     * @mbg.generated
     */
    private Date genTime;

    /**
     * Database Column Remarks:
     *   组描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    public Group(Long groupId, Long pGroupId, String groupName, Date genTime, String description) {
        this.groupId = groupId;
        this.pGroupId = pGroupId;
        this.groupName = groupName;
        this.genTime = genTime;
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated
     */
    public Group() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.group_id
     *
     * @return the value of t_group.group_id
     *
     * @mbg.generated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.group_id
     *
     * @param groupId the value for t_group.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.p_group_id
     *
     * @return the value of t_group.p_group_id
     *
     * @mbg.generated
     */
    public Long getpGroupId() {
        return pGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.p_group_id
     *
     * @param pGroupId the value for t_group.p_group_id
     *
     * @mbg.generated
     */
    public void setpGroupId(Long pGroupId) {
        this.pGroupId = pGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.group_name
     *
     * @return the value of t_group.group_name
     *
     * @mbg.generated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.group_name
     *
     * @param groupName the value for t_group.group_name
     *
     * @mbg.generated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.gen_time
     *
     * @return the value of t_group.gen_time
     *
     * @mbg.generated
     */
    public Date getGenTime() {
        return genTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.gen_time
     *
     * @param genTime the value for t_group.gen_time
     *
     * @mbg.generated
     */
    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.description
     *
     * @return the value of t_group.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.description
     *
     * @param description the value for t_group.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}