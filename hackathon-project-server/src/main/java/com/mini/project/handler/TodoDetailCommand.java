package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Picture;
import com.mini.util.Prompt;

public class TodoDetailCommand implements Command {

  List<Todo> todoList;

  /*
  public TodoDetailCommand(List<Todo> list) {
    this.todoList = list;
  }
  */

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    todoList = loggedInMember.getTodoList();
    try {
      out.println("[할 일 상세보기]");
      String title = Prompt.inputString("제목", out, in);
      Todo todo = findByTitle(title);

      if (todo == null) {
        out.println("해당 제목의 작업이 없습니다.");
        return;
      }
      Picture.printScreen(out, todo.getCategory());

      out.printf("내용: %s\n", todo.getContent());
      out.printf("날짜: %s\n", todo.getDate());
      String categories = null;
      switch (todo.getCategory()) {
        case 1:
          categories = "어학";
          break;
        case 2:
          categories = "독서";
          break;
        case 3:
          categories = "운동";
          break;
        case 4:
          categories = "코딩";
          break;
        default:
          categories = "기타";
      }
      out.printf("카테고리: %s\n", categories);
      out.printf("할일: %s\n", todo.getTitle());
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private Todo findByTitle(String title) {
    for (int i = 0; i < todoList.size(); i++) {
      Todo todo = todoList.get(i);
      if (todo.getTitle().equals(title)) {
        return todo;
      }
    }
    return null;
  }
}