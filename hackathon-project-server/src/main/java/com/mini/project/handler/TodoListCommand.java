package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;

public class TodoListCommand implements Command {

  List<Todo> todoList;

  /*
  public TodoListCommand(List<Todo> list) {
    this.todoList = list;
  }
  */


  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    todoList = loggedInMember.getTodoList();
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());
    out.println("[스케줄 목록]");
    out.println("===================================");
    out.printf("%s                 %s\n", date, timeNow);
    out.println("===================================");
    out.println("===================================");
    out.println("         .-----.");
    out.println("        |.-----.|");
    out.println("        ||x . x||");
    out.println("        ||_.-._||");
    out.println("        `--)-(--`");
    out.println("       __[=== o]___\'");
    out.println("       |:::::::::::|\'");
    out.println("       `-=========-`()");
    out.println("===================================");
    out.println("===================================");
    out.println("===================================");

    Iterator<Todo> iterator = todoList.iterator();

    while (iterator.hasNext()) {
      Todo todo = iterator.next();

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
      out.printf((todo.isDone() ? "● " : "○ ") + "%s" + " | "+ "%s" + " | " + "%s\n",
          todo.getDate(),
          categories,
          todo.getTitle());
    }
    out.println("===================================");
    out.println("===================================");
  }
}