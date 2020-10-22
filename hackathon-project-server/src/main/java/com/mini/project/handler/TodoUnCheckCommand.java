package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class TodoUnCheckCommand implements Command {

  List<Todo> todoList;

  /*
  public TodoDeleteCommand(List<Todo> list) {
    this.todoList = list;
  }
  */

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    todoList = loggedInMember.getTodoList();
    try {
      out.println("[한 일 체크 해제]");
      String title = Prompt.inputString("제목? ", out, in);
      int index = indexOf(title);

      if (index == -1) {
        out.println("해당 제목의 작업이 없습니다.");
        return;
      }

      todoList.get(index).setDone(false);;
      out.println("작업이 체크 해제되었습니다.");
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private int indexOf(String title) {
    for (int i = 0; i < todoList.size(); i++) {
      Todo todo = todoList.get(i);
      if (todo.getTitle().equals(title)) {
        return i;
      }
    }
    return -1;
  }
}