package com.devisv.practice.online.converter;

import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.dto.InputCourseItemDto;
import com.devisv.practice.online.model.CourseItem;
import org.springframework.stereotype.Component;

@Component
public class CourseItemConverterDtoToModel implements Converter<InputCourseItemDto, CourseItem> {

  @Override
  public CourseItem convert(InputCourseItemDto inputCourseItemDto) {
    return null;
  }
}
