package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;

@DynamoDBTable(tableName = "practice")
public abstract class OnlinePractice implements Serializable {

  @DynamoDBHashKey(attributeName = "pk")
  private String primaryKey;

  @DynamoDBRangeKey(attributeName = "sk")
  private String sortedKey;

  public String getPrimaryKey() {
    return primaryKey;
  }

  public void setPrimaryKey(String primaryKey) {
    this.primaryKey = primaryKey;
  }

  public String getSortedKey() {
    return sortedKey;
  }

  public void setSortedKey(String sortedKey) {
    this.sortedKey = sortedKey;
  }
}
