package com.mini.project.domain;

import java.sql.Date;

public class Todo {

  private Date date;
  private String title;
  private String content;
  private boolean isDone = false;
  private Category category;


  enum Category {
    language {
      public String toString() {
        return "어학";
      }
    },
    reading {
      public String toString() {
        return "독서";
      }
    },
    workout {
      public String toString() {
        return "운동";
      }
    },
    coding {
      public String toString() {
        return "코딩";
      }
    },
  }

  @Override
  public String toString() {
    return  (isDone ? "● " : "○ ") + date + " | "+ category.toString() + " | " + title  ;
  }



  // 테스트
  public static void main(String[] args) {
    Todo test = new Todo();
    test.title = "스레드풀 공부";
    test.date = Date.valueOf("2020-10-20");
    test.content = "자바";
    test.category = Category.coding;

    System.out.println(test);
  }

}
