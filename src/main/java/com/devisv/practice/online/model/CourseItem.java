package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.devisv.practice.online.core.model.OnlinePractice;
import java.util.List;


public class CourseItem extends OnlinePractice {

  @DynamoDBAttribute
  private String name;

  @DynamoDBAttribute
  private String sort;

  @DynamoDBAttribute
  @DynamoDBTypeConvertedEnum
  private CourseItemType type;

  @DynamoDBAttribute
  private String coursePk;

  @DynamoDBAttribute
  private String courseSk;

  @DynamoDBAttribute
  private List<String> lines;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public CourseItemType getType() {
    return type;
  }

  public void setType(CourseItemType type) {
    this.type = type;
  }

  public String getCoursePk() {
    return coursePk;
  }

  public void setCoursePk(String coursePk) {
    this.coursePk = coursePk;
  }

  public String getCourseSk() {
    return courseSk;
  }

  public void setCourseSk(String courseSk) {
    this.courseSk = courseSk;
  }

  public List<String> getLines() {
    return lines;
  }

  public void setLines(List<String> lines) {
    this.lines = lines;
  }
}
