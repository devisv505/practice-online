package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;

@DynamoDBTable(tableName = "practice")
public class Practice implements Serializable {

  private String practiceId;

  private Level level;

  private Sentence sentence;

  @DynamoDBHashKey(attributeName = "pk")
  public String getPracticeId() {
    return practiceId;
  }

  public void setPracticeId(String practiceId) {
    this.practiceId = practiceId;
  }

  @DynamoDBAttribute
  public Sentence getSentence() {
    return sentence;
  }

  public void setSentence(Sentence sentence) {
    this.sentence = sentence;
  }

  @DynamoDBRangeKey(attributeName = "sk")
  public String getLevel() {
    return level.toString();
  }

  public void setLevel(Level level) {
    this.level = level;
  }
}
