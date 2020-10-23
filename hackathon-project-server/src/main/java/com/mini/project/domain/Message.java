package com.mini.project.domain;

public class Message {

  public Message(String senderId, String title, String content) {
    this.isRead = false;
    this.senderId = senderId;
    this.title = title;
    this.content = content;
    this.time = System.currentTimeMillis();
  }
  
  boolean isRead;
  String senderId;
  String title;
  String content;
  long time;

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean isRead) {
    this.isRead = isRead;
  }

  public String getSender() {
    return senderId;
  }

  public void setSender(String senderId) {
    this.senderId = senderId;
  }

  public String getContent() {
    return content;
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
