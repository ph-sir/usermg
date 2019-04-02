package com.pengh.usermg.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_role_right_relation
 */
public class RoleRightRelation {
    /**
     * Database Column Remarks:
     *   记录标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_right_relation.role_right_id
     *
     * @mbg.generated
     */
    private Long roleRightId;

    /**
     * Database Column Remarks:
     *   角色
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_right_relation.role_id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * Database Column Remarks:
     *   权限
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_right_relation.right_id
     *
     * @mbg.generated
     */
    private Long rightId;

    /**
     * Database Column Remarks:
     *   权限类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_right_relation.right_type
     *
     * @mbg.generated
     */
    private Integer rightType;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_right_relation
     *
     * @mbg.generated
     */
    public RoleRightRelation(Long roleRightId, Long roleId, Long rightId, Integer rightType) {
        this.roleRightId = roleRightId;
        this.roleId = roleId;
        this.rightId = rightId;
        this.rightType = rightType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role_right_relation
     *
     * @mbg.generated
     */
    public RoleRightRelation() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_right_relation.role_right_id
     *
     * @return the value of t_role_right_relation.role_right_id
     *
     * @mbg.generated
     */
    public Long getRoleRightId() {
        return roleRightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_right_relation.role_right_id
     *
     * @param roleRightId the value for t_role_right_relation.role_right_id
     *
     * @mbg.generated
     */
    public void setRoleRightId(Long roleRightId) {
        this.roleRightId = roleRightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_right_relation.role_id
     *
     * @return the value of t_role_right_relation.role_id
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_right_relation.role_id
     *
     * @param roleId the value for t_role_right_relation.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_right_relation.right_id
     *
     * @return the value of t_role_right_relation.right_id
     *
     * @mbg.generated
     */
    public Long getRightId() {
        return rightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_right_relation.right_id
     *
     * @param rightId the value for t_role_right_relation.right_id
     *
     * @mbg.generated
     */
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_right_relation.right_type
     *
     * @return the value of t_role_right_relation.right_type
     *
     * @mbg.generated
     */
    public Integer getRightType() {
        return rightType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_right_relation.right_type
     *
     * @param rightType the value for t_role_right_relation.right_type
     *
     * @mbg.generated
     */
    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }
}