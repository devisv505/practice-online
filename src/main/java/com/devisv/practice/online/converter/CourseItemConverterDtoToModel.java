package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.InputLessonDto;
import com.devisv.practice.online.model.Lesson;
import org.springframework.stereotype.Component;

@Component
public class CourseItemConverterDtoToModel implements Converter<InputLessonDto, Lesson> {

  @Override
  public Lesson convert(InputLessonDto inputLessonDto) {
    Lesson lesson = new Lesson();
    lesson.setSortedKey(inputLessonDto.getCourseSk());
    lesson.setSort(inputLessonDto.getSort());
    lesson.setPartitionKey(inputLessonDto.getCoursePk());
    lesson.setCoursePk(inputLessonDto.getCoursePk());
    lesson.setCourseSk(inputLessonDto.getCourseSk());
    lesson.setName(inputLessonDto.getName());
    lesson.setType(inputLessonDto.getType());

    return lesson;
  }
}
