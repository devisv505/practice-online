package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.InputCourseDto;
import com.devisv.practice.online.dto.OutputCourseDto;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterModelToDto implements Converter<Course, OutputCourseDto> {

  @Override
  public OutputCourseDto convert(Course course) {
    OutputCourseDto inputCourseDto = new OutputCourseDto();
    inputCourseDto.setCost(course.getCost());
    inputCourseDto.setEnabledForUnregistered(course.isEnabledForUnregistered());
    inputCourseDto.setFinished(course.getFinished());
    inputCourseDto.setFree(course.isFree());
    inputCourseDto.setLevel(course.getLevel());
    inputCourseDto.setLikes(course.getLikes());
    inputCourseDto.setName(course.getName());
    inputCourseDto.setStarted(course.getStarted());
    inputCourseDto.setEnabledForUnregistered(course.isEnabledForUnregistered());

    inputCourseDto.setPk(course.getPartitionKey());
    inputCourseDto.setSk(course.getSortedKey());

    return inputCourseDto;
  }

}
