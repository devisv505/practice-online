package com.devisv.practice.online.dto;

import com.devisv.practice.online.model.Level;

public class InputCourseDto {

  private String name;

  private Level level;

  private boolean enabledForUnregistered;

  private boolean free;

  private int likes;

  private int started;

  private int finished;

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
