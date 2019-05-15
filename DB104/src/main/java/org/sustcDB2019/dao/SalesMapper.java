package org.sustcDB2019.dao;

import org.sustcDB2019.entity.Sales;

public interface SalesMapper {
    int deleteByPrimaryKey(Integer salesId);

    int insert(Sales record);

    int insertSelective(Sales record);

    Sales selectByPrimaryKey(Integer salesId);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}