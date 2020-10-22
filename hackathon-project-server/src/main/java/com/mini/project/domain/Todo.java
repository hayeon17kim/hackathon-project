package com.mini.project.domain;

import java.sql.Date;

public class Todo {
  private Date date;
  private String title;
  private String content;
  private boolean isDone = false;
  private int category;

  public String categoryString() {
    switch(category) {
      case 1:
        return "어학";
      case 2:
        return "독서";
      case 3:
        return "운동";
      default:
        return "코딩";
    }
  }
  
  @Override
  public String toString() {
    return  (isDone ? " ●" : " ○") + /*date + */" | "+ categoryString() + " | " + title  ;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setDone(boolean isDone) {
    this.isDone = isDone;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }
}
