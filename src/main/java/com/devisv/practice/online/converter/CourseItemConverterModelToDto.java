package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.OutputCourseDto;
import com.devisv.practice.online.dto.OutputCourseItemDto;
import com.devisv.practice.online.model.Course;
import com.devisv.practice.online.model.CourseItem;
import org.springframework.stereotype.Component;

@Component
public class CourseItemConverterModelToDto implements Converter<CourseItem, OutputCourseItemDto> {

  @Override
  public OutputCourseItemDto convert(CourseItem courseItem) {
    return null;
  }

}
