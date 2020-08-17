package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.OutputLessonDto;
import com.devisv.practice.online.model.Lesson;
import org.springframework.stereotype.Component;

@Component
public class CourseItemConverterModelToDto implements Converter<Lesson, OutputLessonDto> {

  @Override
  public OutputLessonDto convert(Lesson lesson) {
    OutputLessonDto output = new OutputLessonDto();
    output.setPk(lesson.getPartitionKey());
    output.setSk(lesson.getSortedKey());
    output.setCoursePk(lesson.getCoursePk());
    output.setCourseSk(lesson.getCourseSk());
    output.setName(lesson.getName());
    output.setSort(lesson.getSort());
    output.setType(lesson.getType());

    return output;
  }

}
