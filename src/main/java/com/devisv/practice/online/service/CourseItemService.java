package com.devisv.practice.online.service;

import com.devisv.practice.online.core.keygenerator.SimplePrimaryKeyGeneratorQualifier;
import com.devisv.practice.online.core.service.SimpleCrudService;
import com.devisv.practice.online.model.CourseItem;
import com.devisv.practice.online.repository.CourseItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseItemService extends SimpleCrudService<CourseItem, String, String> {

  protected CourseItemService(CourseItemRepository crudRepository, SimplePrimaryKeyGeneratorQualifier keyGeneratorQualifier) {
    super(crudRepository, keyGeneratorQualifier);
  }
}
