package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.InputCourseDto;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterDtoToModel implements Converter<InputCourseDto, Course> {

  @Override
  public Course convert(InputCourseDto inputCourseDto) {
    Course course = new Course();
    course.setCost(inputCourseDto.getCost());
    course.setEnabledForUnregistered(inputCourseDto.isEnabledForUnregistered());
    course.setFinished(inputCourseDto.getFinished());
    course.setFree(inputCourseDto.isFree());
    course.setLevel(inputCourseDto.getLevel());
    course.setLikes(inputCourseDto.getLikes());
    course.setStarted(inputCourseDto.getStarted());
    course.setName(inputCourseDto.getName());

    return course;
  }

}
