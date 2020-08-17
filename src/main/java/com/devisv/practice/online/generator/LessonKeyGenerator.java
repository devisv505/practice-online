package com.devisv.practice.online.generator;

import com.devisv.practice.online.core.keygenerator.PrimaryKeyGenerator;
import com.devisv.practice.online.model.Lesson;
import org.springframework.stereotype.Service;

@Service
public class LessonKeyGenerator implements PrimaryKeyGenerator<Lesson> {

  private static final String PK = "LESSON#%s";

  @Override
  public Lesson generate(Lesson lesson) {
    lesson.setPartitionKey(String.format(PK, lesson.getCourseSk()));
    lesson.setSortedKey(lesson.getType() + "#" + lesson.getName().replace(" ", "_").toUpperCase());
    return lesson;
  }

}
