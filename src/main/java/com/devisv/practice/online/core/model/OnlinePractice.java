package com.devisv.practice.online.core.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;

@DynamoDBTable(tableName = "practice")
public abstract class OnlinePractice implements Serializable {

  @DynamoDBHashKey(attributeName = "pk")
  private String partitionKey;

  @DynamoDBRangeKey(attributeName = "sk")
  private String sortedKey;

  public String getPartitionKey() {
    return partitionKey;
  }

  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  public String getSortedKey() {
    return sortedKey;
  }

  public void setSortedKey(String sortedKey) {
    this.sortedKey = sortedKey;
  }
}
