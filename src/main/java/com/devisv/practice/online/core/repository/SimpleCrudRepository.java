package com.devisv.practice.online.core.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.devisv.practice.online.core.model.OnlinePractice;
import com.devisv.practice.online.model.Practice;
import java.util.List;
import java.util.Map;

public abstract class SimpleCrudRepository<MODEL extends OnlinePractice, PK, SK> implements CrudRepository<MODEL, PK, SK> {

  private final DynamoDBMapper mapper;

  protected SimpleCrudRepository(DynamoDBMapper mapper) {
    this.mapper = mapper;
  }

  public MODEL create(MODEL model) {
    mapper.save(model);
    return model;
  }

  public List<MODEL> getList() {
    return null;
  }

  public MODEL getById(PK pk, SK sk) {
    return null;
  }

  public MODEL update(MODEL model, PK pk, SK sk) {
    return null;
  }

  public void delete(PK pk, SK sk) {

  }

  private DynamoDBSaveExpression getDynamoDBSaveExpression(Practice practice) {
    DynamoDBSaveExpression expression = new DynamoDBSaveExpression();

    ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue(
            new AttributeValue(
                practice.getPrimaryKey()
            )
        )
        .withComparisonOperator(ComparisonOperator.EQ)
        ;

    expression.setExpected(Map.of("pk", expectedAttributeValue));

    return expression;
  }

}
