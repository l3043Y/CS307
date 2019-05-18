package org.sustcDB2019.service;

import org.apache.ibatis.session.SqlSession;

public class CashierService {
    public int updateCasher(Cashier cashier){
        SqlSession sqlSession=DAOService.sqlSessionFactory.openSession();
        CashierMapper mapper=sqlSession.getMapper(CashierMapper.class);//[add mapper] add casher's entity and mapper [Aready]
        mapper.updateByPrimaryKeySelective(cashier);
        return 0;
    }
}