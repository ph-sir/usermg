package com.pengh.usermg.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_user_group_relation
 */
public class UserGroupRelation {
    /**
     * Database Column Remarks:
     *   记录标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_group_relation.user_group_id
     *
     * @mbg.generated
     */
    private Long userGroupId;

    /**
     * Database Column Remarks:
     *   用户
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_group_relation.user_id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * Database Column Remarks:
     *   组
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_group_relation.group_id
     *
     * @mbg.generated
     */
    private Long groupId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group_relation
     *
     * @mbg.generated
     */
    public UserGroupRelation(Long userGroupId, Long userId, Long groupId) {
        this.userGroupId = userGroupId;
        this.userId = userId;
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_group_relation
     *
     * @mbg.generated
     */
    public UserGroupRelation() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_group_relation.user_group_id
     *
     * @return the value of t_user_group_relation.user_group_id
     *
     * @mbg.generated
     */
    public Long getUserGroupId() {
        return userGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_group_relation.user_group_id
     *
     * @param userGroupId the value for t_user_group_relation.user_group_id
     *
     * @mbg.generated
     */
    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_group_relation.user_id
     *
     * @return the value of t_user_group_relation.user_id
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_group_relation.user_id
     *
     * @param userId the value for t_user_group_relation.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_group_relation.group_id
     *
     * @return the value of t_user_group_relation.group_id
     *
     * @mbg.generated
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_group_relation.group_id
     *
     * @param groupId the value for t_user_group_relation.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}