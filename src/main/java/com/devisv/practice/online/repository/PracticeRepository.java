package com.devisv.practice.online.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.devisv.practice.online.model.Practice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PracticeRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(PracticeRepository.class);

  private final DynamoDBMapper dynamoDBMapper;

  public PracticeRepository(DynamoDBMapper dynamoDBMapper) {
    this.dynamoDBMapper = dynamoDBMapper;
  }

  public void create(Practice practice) {
    dynamoDBMapper.save(practice);
  }

  public void update(Practice practice) {
    try {
      dynamoDBMapper.save(practice, getDynamoDBSaveExpression(practice));
    } catch (ConditionalCheckFailedException e) {
      LOGGER.error("Invalid data ", e);
    }
  }

  private DynamoDBSaveExpression getDynamoDBSaveExpression(Practice practice) {
    DynamoDBSaveExpression expression = new DynamoDBSaveExpression();

    ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue(new AttributeValue(practice.getPracticeId()))
        .withComparisonOperator(ComparisonOperator.LE);

    expression.setExpected(Map.of("practiceId", expectedAttributeValue));

    return expression;
  }
}
