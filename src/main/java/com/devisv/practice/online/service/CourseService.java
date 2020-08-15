package com.devisv.practice.online.service;

import com.devisv.practice.online.core.keygenerator.SimplePrimaryKeyGeneratorQualifier;
import com.devisv.practice.online.core.service.SimpleCrudService;
import com.devisv.practice.online.model.Course;
import com.devisv.practice.online.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends SimpleCrudService<Course, String, String> {

  protected CourseService(CourseRepository crudRepository, SimplePrimaryKeyGeneratorQualifier keyGeneratorQualifier) {
    super(crudRepository, keyGeneratorQualifier);
  }
}
