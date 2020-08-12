package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import java.io.Serializable;

@DynamoDBDocument
public class Sentence implements Serializable {

  private String value;

  @DynamoDBAttribute
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
