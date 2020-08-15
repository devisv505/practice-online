package com.devisv.practice.online.core.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.devisv.practice.online.core.model.OnlinePractice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.core.ResolvableType;

public abstract class SimpleCrudRepository<MODEL extends OnlinePractice, PK, SK> implements CrudRepository<MODEL,PK,SK> {

  private final DynamoDBMapper mapper;

  private final Class<MODEL> modelClassType;

  protected SimpleCrudRepository(DynamoDBMapper mapper) {
    this.mapper = mapper;
    modelClassType = (Class<MODEL>) ResolvableType.forClass(this.getClass()).as(CrudRepository.class).getGeneric(0).toClass();
  }

  public MODEL create(MODEL model) {
    mapper.save(model);
    return model;
  }

  public List<MODEL> getList(PK pk) {

    Map<String, AttributeValue> pkValue = new HashMap<>();
    pkValue.put(":pk", new AttributeValue().withS((String) pk));

    DynamoDBQueryExpression<MODEL> queryExpression = new DynamoDBQueryExpression<MODEL>()
        .withKeyConditionExpression("pk = :pk").withExpressionAttributeValues(pkValue);

    return mapper.query(modelClassType, queryExpression);
  }

  public Optional<MODEL> getById(PK pk, SK sk) {
    Map<String, AttributeValue> pkValue = new HashMap<>();
    pkValue.put(":pk", new AttributeValue().withS((String) pk));
    pkValue.put(":sk", new AttributeValue().withS((String) sk));

    DynamoDBQueryExpression<MODEL> queryExpression = new DynamoDBQueryExpression<MODEL>()
        .withKeyConditionExpression("pk = :pk and sk = :sk").withExpressionAttributeValues(pkValue);

    return mapper.query(modelClassType, queryExpression).stream().findFirst();
  }

  public MODEL update(MODEL model, PK pk, SK sk) {
    try {

      if (model.getSortedKey().equals(sk) && model.getPartitionKey().equals(pk)) {

        DynamoDBSaveExpression expression = new DynamoDBSaveExpression();
        expression.withExpected(Map.of(
            "pk", new ExpectedAttributeValue(new AttributeValue().withS((String) pk)).withComparisonOperator(ComparisonOperator.EQ),
            "sk", new ExpectedAttributeValue(new AttributeValue().withS((String) sk)).withComparisonOperator(ComparisonOperator.EQ))
        );

        mapper.save(model, expression);
      } else {
        throw new RuntimeException("Cannot update primary key");
        // delete(pk, sk);
        // create(model);
      }
    } catch (ConditionalCheckFailedException e) {
      throw new RuntimeException("Invalid data", e);
    }

    return model;
  }

  public void delete(PK pk, SK sk) {
    getById(pk, sk).ifPresent(model -> mapper.delete(model));
  }
}
