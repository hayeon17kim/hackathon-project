package com.mini.project.domain;

import java.sql.Date;
import java.util.List;
import java.util.Map;

//Member 클래스는 더이상 CsvObject를 구현할 필요가 없다.
//
public class Member {
  private String name;
  private String email;
  private String password;
  private List<Todo> TodoList;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
