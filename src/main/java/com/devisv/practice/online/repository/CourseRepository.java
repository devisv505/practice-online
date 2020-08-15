package com.devisv.practice.online.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.devisv.practice.online.core.repository.SimpleCrudRepository;
import com.devisv.practice.online.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository extends SimpleCrudRepository<Course, String, String> {

  protected CourseRepository(DynamoDBMapper mapper) {
    super(mapper);
  }

}
