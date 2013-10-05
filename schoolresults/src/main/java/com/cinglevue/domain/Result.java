package com.cinglevue.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "result", catalog = "json")
public class Result implements Serializable {

  public Result() {
    super();
  }

  private Integer resultID;
  private School school;
  private Subject subject;

  private Double latestY3;
  private Double latestY5;
  private Double latestY7;
  private Double latestY9;
  private Double rawGainY3Y5;
  private Double factoredGainY3Y5;
  private Double glgY3Y5;
  private Double latestGainInGainY3Y5;

  public Result(School school, Subject subject, Double latestY3, Double latestY5, Double latestY7,
      Double latestY9, Double rawGainY3Y5, Double factoredGainY3Y5, Double glgY3Y5,
      Double latestGainInGainY3Y5) {
    super();
    this.school = school;
    this.subject = subject;
    this.latestY3 = latestY3;
    this.latestY5 = latestY5;
    this.latestY7 = latestY7;
    this.latestY9 = latestY9;
    this.rawGainY3Y5 = rawGainY3Y5;
    this.factoredGainY3Y5 = factoredGainY3Y5;
    this.glgY3Y5 = glgY3Y5;
    this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "RESULT_ID", unique = true, nullable = false)
  public Integer getResultID() {
    return resultID;
  }

  public void setResultID(Integer resultID) {
    this.resultID = resultID;
  }

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "SCHOOL_ID", nullable = false)
  public School getSchool() {
    return school;
  }

  public void setSchool(School school) {
    this.school = school;
  }

  @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
  @JoinColumn(name = "SUBJECT_ID", nullable = false)
  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  @Column(name = "latestY3", unique = true, nullable = false, length = 20)
  public Double getLatestY3() {
    return latestY3;
  }

  public void setLatestY3(Double latestY3) {
    this.latestY3 = latestY3;
  }

  @Column(name = "latestY5", unique = true, nullable = false, length = 20)
  public Double getLatestY5() {
    return latestY5;
  }

  public void setLatestY5(Double latestY5) {
    this.latestY5 = latestY5;
  }

  @Column(name = "latestY7", unique = true, nullable = false, length = 20)
  public Double getLatestY7() {
    return latestY7;
  }

  public void setLatestY7(Double latestY7) {
    this.latestY7 = latestY7;
  }

  @Column(name = "latestY9", unique = true, nullable = false, length = 20)
  public Double getLatestY9() {
    return latestY9;
  }

  public void setLatestY9(Double latestY9) {
    this.latestY9 = latestY9;
  }

  @Column(name = "rawGainY3Y5", unique = true, nullable = false, length = 20)
  public Double getRawGainY3Y5() {
    return rawGainY3Y5;
  }

  public void setRawGainY3Y5(Double rawGainY3Y5) {
    this.rawGainY3Y5 = rawGainY3Y5;
  }

  @Column(name = "factoredGainY3Y5", unique = true, nullable = false, length = 20)
  public Double getFactoredGainY3Y5() {
    return factoredGainY3Y5;
  }

  public void setFactoredGainY3Y5(Double factoredGainY3Y5) {
    this.factoredGainY3Y5 = factoredGainY3Y5;
  }

  @Column(name = "glgY3Y5", unique = true, nullable = false, length = 20)
  public Double getGlgY3Y5() {
    return glgY3Y5;
  }

  public void setGlgY3Y5(Double glgY3Y5) {
    this.glgY3Y5 = glgY3Y5;
  }

  @Column(name = "latestGainInGainY3Y5", unique = true, nullable = false, length = 20)
  public Double getLatestGainInGainY3Y5() {
    return latestGainInGainY3Y5;
  }

  public void setLatestGainInGainY3Y5(Double latestGainInGainY3Y5) {
    this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
  }
}
