package com.mini.project.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Member 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class Member {
  private String name;
  private String id;
  private String password;
  private List<Todo> todoList;
  private List<Member> friendsList;
  
  public Member() {
    todoList = new ArrayList<>();
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

  public List<Member> getFriendsList() {
    return friendsList;
  }

  public void setFriendsList(List<Member> friendsList) {
    this.friendsList = friendsList;
  }
  
}
