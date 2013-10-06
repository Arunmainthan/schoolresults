package com.cinglevue.service;

import java.util.List;

import com.cinglevue.dao.ResultsDao;
import com.cinglevue.domain.Result;
import com.cinglevue.domain.Subject;

public class ResultsServiceImpl implements ResultsService {

  private ResultsDao resultsDao;
  public ResultsDao getResultsDao() {
    return resultsDao;
  }
  public void setResultsDao(ResultsDao resultsDao) {
    this.resultsDao = resultsDao;
  }
  public List<Result> getAllResults() {
    // TODO Auto-generated method stub
    return resultsDao.getAllResults();
    
  }
  public List<Subject> getAllSubjects() {
    // TODO Auto-generated method stub
    return resultsDao.getAllSubjects();
  }

}
