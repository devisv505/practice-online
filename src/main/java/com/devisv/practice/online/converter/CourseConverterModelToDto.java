package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.CourseDto;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterModelToDto implements Converter<Course, CourseDto> {

  @Override
  public CourseDto convert(Course course) {
    return null;
  }

}
