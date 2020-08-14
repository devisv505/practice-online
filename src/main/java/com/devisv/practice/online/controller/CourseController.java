package com.devisv.practice.online.controller;

import com.devisv.practice.online.core.controller.SimpleCrudController;
import com.devisv.practice.online.core.convertor.ConverterQualifier;
import com.devisv.practice.online.dto.CourseDto;
import com.devisv.practice.online.model.Course;
import com.devisv.practice.online.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends SimpleCrudController<CourseDto, CourseDto, Course, String, String> {

  protected CourseController(CourseService crudService, ConverterQualifier converterQualifier) {
    super(crudService, converterQualifier);
  }

}
