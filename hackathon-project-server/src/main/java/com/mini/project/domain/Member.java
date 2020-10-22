package com.mini.project.domain;

import java.util.ArrayList;
import java.util.List;

//Member 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class Member {
  private String name;
  private String id;
  private String password;
  private List<Todo> todoList;
  private List<Message> messageList;
  private String status = "기본 상태메시지";
  
   
  public Member() {
    todoList = new ArrayList<>();
    messageList = new ArrayList<>();
  }
  
  public Member(String name, String id, String password, List<Todo> list) {
    this.name = name;
    this.id = id;
    this.password = password;
    this.todoList = list;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public List<Todo> getTodoList() {
    return todoList;
  }
  public void setTodoList(List<Todo> todoList) {
    this.todoList = todoList;
  }

  public List<Message> getMessageList() {
    return messageList;
  }

  public void setMessageList(List<Message> messageList) {
    this.messageList = messageList;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
  
  
}
