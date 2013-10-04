package com.cinglevue.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;

@Entity
@Table(name = "school", catalog = "json", uniqueConstraints = @UniqueConstraint(columnNames = "SCHOOL_NAME"))
public class School implements java.io.Serializable {
  public School() {
    super();
  }

  private Integer schoolId;
  private String schoolName;
  
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "SCHOOL_ID", unique = true, nullable = false)
  public Integer getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(Integer schoolId) {
    this.schoolId = schoolId;
  }

  @Column(name = "SCHOOL_NAME", unique = true, nullable = false, length = 50)
  public String getSchoolName() {
    return schoolName;
  }

  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }

  public School(String schoolName) {
    super();
    this.schoolName = schoolName;
  }
}
