package com.sh.drools.dal.model;

import java.util.List;

public class Resource {
    private Integer id;
    private String funUrls;
    private String menuUrl;
    private String resKey;
    private String resName;
    private String resType;
    private Integer status;
    private Integer weight;
    private Integer parentId;
    private String value1;
    private String value2;
    private Resource parent;
    private List<Resource> children;

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.ID
     *
     * @param id the value for crm_resource.ID
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.FUN_URLS
     *
     * @return the value of crm_resource.FUN_URLS
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getFunUrls() {
        return funUrls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.FUN_URLS
     *
     * @param funUrls the value for crm_resource.FUN_URLS
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setFunUrls(String funUrls) {
        this.funUrls = funUrls == null ? null : funUrls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.MENU_URL
     *
     * @return the value of crm_resource.MENU_URL
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.MENU_URL
     *
     * @param menuUrl the value for crm_resource.MENU_URL
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.RES_KEY
     *
     * @return the value of crm_resource.RES_KEY
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getResKey() {
        return resKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.RES_KEY
     *
     * @param resKey the value for crm_resource.RES_KEY
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setResKey(String resKey) {
        this.resKey = resKey == null ? null : resKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.RES_NAME
     *
     * @return the value of crm_resource.RES_NAME
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getResName() {
        return resName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.RES_NAME
     *
     * @param resName the value for crm_resource.RES_NAME
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.RES_TYPE
     *
     * @return the value of crm_resource.RES_TYPE
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getResType() {
        return resType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.RES_TYPE
     *
     * @param resType the value for crm_resource.RES_TYPE
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.STATUS
     *
     * @return the value of crm_resource.STATUS
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.STATUS
     *
     * @param status the value for crm_resource.STATUS
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.WEIGHT
     *
     * @return the value of crm_resource.WEIGHT
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.WEIGHT
     *
     * @param weight the value for crm_resource.WEIGHT
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.PARENT_ID
     *
     * @return the value of crm_resource.PARENT_ID
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.PARENT_ID
     *
     * @param parentId the value for crm_resource.PARENT_ID
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.value1
     *
     * @return the value of crm_resource.value1
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getValue1() {
        return value1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.value1
     *
     * @param value1 the value for crm_resource.value1
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setValue1(String value1) {
        this.value1 = value1 == null ? null : value1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_resource.value2
     *
     * @return the value of crm_resource.value2
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public String getValue2() {
        return value2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_resource.value2
     *
     * @param value2 the value for crm_resource.value2
     *
     * @mbggenerated Wed Jun 19 11:52:41 CST 2019
     */
    public void setValue2(String value2) {
        this.value2 = value2 == null ? null : value2.trim();
    }
}