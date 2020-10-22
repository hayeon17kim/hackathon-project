package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class TodoCheckCommand implements Command {

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
      out.println("[스케줄 완료]");
      String title = Prompt.inputString("제목? ", out, in);
      int index = indexOf(title);

      if (index == -1) {
        out.println("해당 번호의 작업이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 완료하셨습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("작업 완료를 취소하였습니다.");
        return;
      }

      todoList.get(index).setDone(true);;
      out.println("작업을 체크하였습니다.");
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