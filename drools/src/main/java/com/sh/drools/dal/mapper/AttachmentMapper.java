package com.sh.drools.dal.mapper;

import com.sh.drools.dal.model.Attachment;

public interface AttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int insert(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int insertSelective(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    Attachment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int updateByPrimaryKeySelective(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_attachment
     *
     * @mbggenerated Mon Jun 17 16:09:28 CST 2019
     */
    int updateByPrimaryKey(Attachment record);
}