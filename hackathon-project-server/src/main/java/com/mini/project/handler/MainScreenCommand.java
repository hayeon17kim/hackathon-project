package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;

public class MainScreenCommand implements Command {

  List<Todo> todoList;
  public MainScreenCommand() {

  }
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());
    todoList = member.getTodoList();

    out.println("==============================");
    out.printf("%s          %s\n", date, timeNow);
    out.println("==============================");
    getTimeScreen(out, in, timeNow);
    out.println("============================");
    out.printf("%s님, 총 %d개의 할 일이 남았습니다.\n", member.getName(), countTodo(todoList, date));
    out.println("============================");
    for (Todo todo : todoList) {
      if (todo.getDate().toString().equals(date)) {
        out.println(todo);
      }
    }
    out.println("============================");
  }
  
  
  
  public int countTodo(List<Todo> list, String date) {
    int count = 0;
    for (Todo todo : todoList) {
      if (todo.getDate().toString().equals(date) && !todo.isDone()) {
        count++;
      }
    }
    return count;
  }
  
  
  public void getTimeScreen(PrintWriter out, BufferedReader in, String timeNow) {
    int hour = Integer.parseInt(timeNow.substring(0, 2));
    if (hour < 15) {
      out.println("           \\  ,  /");
      out.println("        ' ,___/_\\___, '");
      out.println("          \\ /o.o\\ /");
      out.println("      -=   > \\__/ <   =-");
      out.println("          /_\\___/_\\");
      out.println("       . `   \\ /   ` .");
      out.println("            /  `  \\");
    } else {
      out.println("              ___");
      out.println("      ~*    .'`  _\\");
      out.println("           /  (o/       *");
      out.println("*         |      _\\           *");
      out.println("           \\  '==.    *");
      out.println("        *   '.____\\       ~*");
    }
  }
  
}
