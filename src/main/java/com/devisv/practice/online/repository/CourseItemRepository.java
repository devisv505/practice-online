package com.devisv.practice.online.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.devisv.practice.online.core.repository.SimpleCrudRepository;
import com.devisv.practice.online.model.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public class CourseItemRepository extends SimpleCrudRepository<Lesson, String, String> {

  protected CourseItemRepository(DynamoDBMapper mapper) {
    super(mapper);
  }

}
