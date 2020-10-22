package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class TodoAddCommand implements Command {

  List<Todo> todoList;

  /*
  public TodoAddCommand(List<Todo> list) {
    this.todoList = list;
  }
  */

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    todoList = loggedInMember.getTodoList();
    try {
      out.println("[스케쥴 등록]");

      Todo todo = new Todo();
      todo.setNo(Prompt.inputInt("번호? ", out, in));
      int index = indexOf(todo.getNo());

      if (index == 0) {
        out.println("해당 번호의 작업이 이미 존재합니다.");
        return;
      }
      todo.setDate(Prompt.inputDate("날짜 ?",out ,in));
      todo.setTitle(Prompt.inputString("할일 ? ",out ,in));
      todo.setContent(Prompt.inputString("내용 ? ",out ,in));
      todo.setCategory(Prompt.inputInt("카테고리?\n1: 어학\n2: 독서\n3: 운동\n4: 코딩\n> ",out ,in));
      todo.setRegisteredDate(new Date(System.currentTimeMillis()));
      todoList.add(todo);
    }catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }

    out.println("스케줄을 등록하였습니다.");
  }
  private int indexOf(int no) {
    for (int i = 0; i < todoList.size(); i++) {
      Todo todo = todoList.get(i);
      if (todo.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}