package com.cinglevue.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "subject", catalog = "json", uniqueConstraints = @UniqueConstraint(columnNames = "SUBJECT_NAME"))
public class Subject implements java.io.Serializable{
  
  public Subject() {
    super();
  }

  private Integer subjectId;
  private String subjectName;
  
  @Column(name = "SUBJECT_NAME", unique = true, nullable = false, length = 20)
  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "SUBJECT_ID", unique = true, nullable = false)
  public Integer getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(Integer subjectId) {
    this.subjectId = subjectId;
  }

  public Subject(String subjectName) {
    super();
    this.subjectName = subjectName;
  }
}