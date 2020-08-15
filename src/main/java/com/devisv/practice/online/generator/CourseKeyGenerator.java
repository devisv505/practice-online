package com.devisv.practice.online.generator;

import com.devisv.practice.online.core.keygenerator.PrimaryKeyGenerator;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseKeyGenerator implements PrimaryKeyGenerator<Course> {

  private static final String PK = "COURSES";

  @Override
  public Course generate(Course course) {
    course.setPartitionKey(PK);
    course.setSortedKey(course.getLevel() + "#" + course.getName().replaceAll(" ", "_").toUpperCase());
    return course;
  }
}
