package com.devisv.practice.online.controller;

import com.devisv.practice.online.core.controller.SimpleCrudController;
import com.devisv.practice.online.core.convertor.ConverterQualifier;
import com.devisv.practice.online.dto.InputCourseDto;
import com.devisv.practice.online.dto.OutputCourseDto;
import com.devisv.practice.online.model.Course;
import com.devisv.practice.online.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseItemController extends SimpleCrudController<InputCourseDto, OutputCourseDto, Course, String, String> {

  protected CourseItemController(CourseService crudService, ConverterQualifier converterQualifier) {
    super(crudService, converterQualifier);
  }

  @Override
  protected String getPartitionKey() {
    return "COURSES";
  }
}
