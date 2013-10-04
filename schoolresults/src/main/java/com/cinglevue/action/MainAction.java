package com.cinglevue.action;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cinglevue.domain.Result;
import com.cinglevue.domain.School;
import com.cinglevue.domain.Subject;
import com.cinglevue.util.HibernateUtil;

public class MainAction {

  //List of schools
  private List<School> schoolList;

  public List<School> getSchoolList() {
    return schoolList;
  }

  public void setSchoolList(List<School> schoolList) {
    this.schoolList = schoolList;
  }

  // all struts logic here
  public String execute() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Result result = (Result)session.get(Result.class, new Integer(1));
    if(result == null){
      initializeData();
    }
    return "DataLoaded";

  }

  private void initializeData() {


    JSONParser parser = new JSONParser();
    Map<String, School> schoolMap = new HashMap<String, School>();
    Map<String, Subject> subjectMap = new HashMap<String, Subject>();
    Set<Result> results = new HashSet<Result>();
    try {

      Object obj = parser.parse(new FileReader("d://data.json"));

      JSONObject jsonObject = (JSONObject) obj;

      JSONArray schoolList = (JSONArray) jsonObject.get("schools");

      Iterator iteratorSchools = schoolList.iterator();



      while (iteratorSchools.hasNext()) {

        JSONObject schoolProperties = (JSONObject) iteratorSchools.next();

        String schoolName =
            ((JSONObject) schoolProperties.get("school")).get("schoolName").toString();
        String subjectname = schoolProperties.get("subject").toString();
        Double latestY3 = Double.parseDouble(schoolProperties.get("latestY3").toString());
        Double latestY5 = Double.parseDouble(schoolProperties.get("latestY5").toString());
        Double latestY7 = Double.parseDouble(schoolProperties.get("latestY7").toString());
        Double latestY9 = Double.parseDouble(schoolProperties.get("latestY9").toString());
        Double rawGainY3Y5 = Double.parseDouble(schoolProperties.get("rawGainY3Y5").toString());
        Double factoredGainY3Y5 =
            Double.parseDouble(schoolProperties.get("factoredGainY3Y5").toString());
        Double glgY3Y5 = Double.parseDouble(schoolProperties.get("glgY3Y5").toString());
        Double latestGainInGainY3Y5 =
            Double.parseDouble(schoolProperties.get("latestGainInGainY3Y5").toString());

        // school

        if (!schoolMap.containsKey(schoolName)) {
          schoolMap.put(schoolName, new School(schoolName));
        }
        if (!subjectMap.containsKey(subjectname)) {
          subjectMap.put(subjectname, new Subject(subjectname));
        }

        School school = schoolMap.get(schoolName);
        Subject subject = subjectMap.get(subjectname);
        Result result =
            new Result(school, subject, latestY3, latestY5, latestY7, latestY9, rawGainY3Y5,
                factoredGainY3Y5, glgY3Y5, latestGainInGainY3Y5);
        if (!results.contains(result)) {
          results.add(result);
          Session session = HibernateUtil.getSessionFactory().openSession();
          System.out.println("Hibernate one to many (Annotation)");

          session.beginTransaction();
          session.save(result);
          session.getTransaction().commit();
        }
      }


    } catch (Exception e) {
      e.printStackTrace();
    }



  
    
  }

}
