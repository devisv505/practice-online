package com.devisv.practice.online.dto;

import com.devisv.practice.online.model.CourseItemType;
import java.util.List;

public class InputCourseItemDto {

  private String name;

  private String sort;

  private CourseItemType type;

  private String coursePk;

  private String courseSk;

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
