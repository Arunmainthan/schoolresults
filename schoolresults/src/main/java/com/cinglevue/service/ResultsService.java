package com.cinglevue.service;

import java.util.List;

import com.cinglevue.domain.Result;
import com.cinglevue.domain.Subject;

public interface ResultsService {

  List<Result> getAllResults();

  List<Subject> getAllSubjects();

}
