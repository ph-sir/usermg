package com.pengh.usermg.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_right
 */
public class Right {
    /**
     * Database Column Remarks:
     *   权限ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_right.tr_id
     *
     * @mbg.generated
     */
    private Long trId;

    /**
     * Database Column Remarks:
     *   父权限
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_right.p_tr_id
     *
     * @mbg.generated
     */
    private Long pTrId;

    /**
     * Database Column Remarks:
     *   权限名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_right.right_name
     *
     * @mbg.generated
     */
    private String rightName;

    /**
     * Database Column Remarks:
     *   权限描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_right.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_right
     *
     * @mbg.generated
     */
    public Right(Long trId, Long pTrId, String rightName, String description) {
        this.trId = trId;
        this.pTrId = pTrId;
        this.rightName = rightName;
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_right
     *
     * @mbg.generated
     */
    public Right() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_right.tr_id
     *
     * @return the value of t_right.tr_id
     *
     * @mbg.generated
     */
    public Long getTrId() {
        return trId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_right.tr_id
     *
     * @param trId the value for t_right.tr_id
     *
     * @mbg.generated
     */
    public void setTrId(Long trId) {
        this.trId = trId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_right.p_tr_id
     *
     * @return the value of t_right.p_tr_id
     *
     * @mbg.generated
     */
    public Long getpTrId() {
        return pTrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_right.p_tr_id
     *
     * @param pTrId the value for t_right.p_tr_id
     *
     * @mbg.generated
     */
    public void setpTrId(Long pTrId) {
        this.pTrId = pTrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_right.right_name
     *
     * @return the value of t_right.right_name
     *
     * @mbg.generated
     */
    public String getRightName() {
        return rightName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_right.right_name
     *
     * @param rightName the value for t_right.right_name
     *
     * @mbg.generated
     */
    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_right.description
     *
     * @return the value of t_right.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_right.description
     *
     * @param description the value for t_right.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}