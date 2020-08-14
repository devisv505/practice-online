package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.devisv.practice.online.core.model.OnlinePractice;


public class Practice extends OnlinePractice {

  @DynamoDBAttribute
  private Sentence sentence;

  public Sentence getSentence() {
    return sentence;
  }

  public void setSentence(Sentence sentence) {
    this.sentence = sentence;
  }
}
