package com.devisv.practice.online.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.devisv.practice.online.core.model.OnlinePractice;

public class Course extends OnlinePractice {

  @DynamoDBAttribute
  private String name;

  @DynamoDBAttribute
  private Level level;

  @DynamoDBAttribute
  private boolean enabledForUnregistered;

  @DynamoDBAttribute
  private boolean free;

  @DynamoDBAttribute
  private int likes;

  @DynamoDBAttribute
  private int started;

  @DynamoDBAttribute
  private int finished;

  @DynamoDBAttribute
  private int cost;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public boolean isEnabledForUnregistered() {
    return enabledForUnregistered;
  }

  public void setEnabledForUnregistered(boolean enabledForUnregistered) {
    this.enabledForUnregistered = enabledForUnregistered;
  }

  public boolean isFree() {
    return free;
  }

  public void setFree(boolean free) {
    this.free = free;
  }

  public int getLikes() {
    return likes;
  }

  public void setLikes(int likes) {
    this.likes = likes;
  }

  public int getStarted() {
    return started;
  }

  public void setStarted(int started) {
    this.started = started;
  }

  public int getFinished() {
    return finished;
  }

  public void setFinished(int finished) {
    this.finished = finished;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

}
