package com.mini.project.domain;

public class Message {
  
  public Message(Member sender, String title, String content) {
    this.isRead = false;
    this.sender = sender;
    this.title = title;
    this.content = content;
    this.time = System.currentTimeMillis();
  }
  
  boolean isRead;
  Member sender;
  String title;
  String content;
  long time;

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean isRead) {
    this.isRead = isRead;
  }

  public Member getSender() {
    return sender;
  }

  public void setSender(Member sender) {
    this.sender = sender;
  }

  public String getContent() {
    return title;
  }

  public void setContent(String content) {
    this.title = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }
  
  
}
