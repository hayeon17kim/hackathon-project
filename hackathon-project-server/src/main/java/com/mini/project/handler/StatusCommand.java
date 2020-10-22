package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class StatusCommand implements Command {

  List<Todo> todoList;

  public StatusCommand() {
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    todoList = member.getTodoList();

    try {
      Todo todo = new Todo();
      while (true){
        member.setStatus(Prompt.inputString("상태 메시지를 적어주세요", out, in));
        if (todo.equals("")) {
          out.println("상태메시지 등록이 취소되었습니다.");
        }  return;
      }
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }

  }
}