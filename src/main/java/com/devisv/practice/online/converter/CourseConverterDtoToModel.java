package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.CourseDto;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverterDtoToModel implements Converter<CourseDto, Course> {

  @Override
  public Course convert(CourseDto courseDto) {
    return null;
  }

}
