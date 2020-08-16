package com.devisv.practice.online.generator;

import com.devisv.practice.online.core.keygenerator.PrimaryKeyGenerator;
import com.devisv.practice.online.model.CourseItem;
import org.springframework.stereotype.Service;

@Service
public class CourseItemKeyGenerator implements PrimaryKeyGenerator<CourseItem> {

  private static final String PK = "COURSE_ITEM#%s";

  @Override
  public CourseItem generate(CourseItem courseItem) {
    courseItem.setPartitionKey(String.format(PK, courseItem.getCourseSk()));
    courseItem.setSortedKey(courseItem.getType() + "#" + courseItem.getSort());
    return courseItem;
  }

}
