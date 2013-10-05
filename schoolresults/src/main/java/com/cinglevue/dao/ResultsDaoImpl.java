package com.cinglevue.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cinglevue.domain.Result;

public class ResultsDaoImpl extends HibernateDaoSupport  implements ResultsDao {

  public List<Result> getAllResults() {
    // TODO Auto-generated method stub
    return getHibernateTemplate().find("from Result");
  }

}
