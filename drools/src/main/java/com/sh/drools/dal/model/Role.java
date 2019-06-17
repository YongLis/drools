package com.sh.drools.dal.model;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.ID
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.DESCRIPTION
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.ROLE_NAME
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.STATUS
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.value1
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String value1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_role.value2
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    private String value2;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.ID
     *
     * @return the value of crm_role.ID
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.ID
     *
     * @param id the value for crm_role.ID
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.DESCRIPTION
     *
     * @return the value of crm_role.DESCRIPTION
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.DESCRIPTION
     *
     * @param description the value for crm_role.DESCRIPTION
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.ROLE_NAME
     *
     * @return the value of crm_role.ROLE_NAME
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.ROLE_NAME
     *
     * @param roleName the value for crm_role.ROLE_NAME
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.STATUS
     *
     * @return the value of crm_role.STATUS
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.STATUS
     *
     * @param status the value for crm_role.STATUS
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.value1
     *
     * @return the value of crm_role.value1
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getValue1() {
        return value1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.value1
     *
     * @param value1 the value for crm_role.value1
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_role.value2
     *
     * @return the value of crm_role.value2
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public String getValue2() {
        return value2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_role.value2
     *
     * @param value2 the value for crm_role.value2
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }
}