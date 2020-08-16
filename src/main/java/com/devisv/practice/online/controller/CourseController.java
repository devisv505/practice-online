package com.devisv.practice.online.controller;

import com.devisv.practice.online.core.controller.SimpleCrudController;
import com.devisv.practice.online.core.convertor.Converter;
import com.devisv.practice.online.core.convertor.ConverterQualifier;
import com.devisv.practice.online.dto.InputCourseDto;
import com.devisv.practice.online.dto.InputCourseItemDto;
import com.devisv.practice.online.dto.OutputCourseDto;
import com.devisv.practice.online.dto.OutputCourseItemDto;
import com.devisv.practice.online.model.Course;
import com.devisv.practice.online.model.CourseItem;
import com.devisv.practice.online.service.CourseItemService;
import com.devisv.practice.online.service.CourseService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/courses")
public class CourseController extends SimpleCrudController<InputCourseDto, OutputCourseDto, Course, String, String> {

  private final CourseItemService courseItemService;

  private final Converter<InputCourseItemDto, CourseItem> converterCounterItemDtoToModel;
  private final Converter<CourseItem, OutputCourseItemDto> converterCounterItemModelToDto;

  protected CourseController(CourseService crudService, ConverterQualifier converterQualifier, CourseItemService courseItemService) {
    super(crudService, converterQualifier);
    this.courseItemService = courseItemService;

    converterCounterItemDtoToModel = converterQualifier.getConverter(InputCourseItemDto.class, CourseItem.class);
    converterCounterItemModelToDto = converterQualifier.getConverter(CourseItem.class, OutputCourseItemDto.class);
  }

  @GetMapping("/{courseSk}/items")
  public List<OutputCourseItemDto> getCourseItems(@PathVariable String courseSk) {
    return courseItemService.getAll("COURSE_ITEM#" + courseSk)
        .stream()
        .map(converterCounterItemModelToDto::convert)
        .collect(Collectors.toList());
  }

  @PostMapping("/{courseSk}/items")
  public OutputCourseItemDto postCourseItem(@PathVariable String courseSk, @RequestBody InputCourseItemDto courseItemDto) {

    if (isEmpty(courseItemDto.getCourseSk())) {
      courseItemDto.setCourseSk(courseSk);
    }

    if (isEmpty(courseItemDto.getCoursePk())) {
      courseItemDto.setCoursePk("COURSE");
    }

    return converterCounterItemModelToDto.convert(
        courseItemService.create(
            converterCounterItemDtoToModel.convert(courseItemDto)
        )
    );
  }

  @Override
  protected String getPartitionKey() {
    return "COURSE";
  }
}
