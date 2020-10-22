package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class TodoListCommand implements Command {

  List<Todo> todoList;
  Calendar c = Calendar.getInstance();

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    todoList = loggedInMember.getTodoList();
    Date[] thisWeek = getCurWeek();
    
    Date date;
    try {
      String keyword = Prompt.inputString("검색: ", out, in);
      
      switch (keyword) {
        case "weekly":
          out.println(weeklyTodos(thisWeek));
          break;
        default:
          out.printf("[%s 일정]\n", keyword);
          out.println(findByDate(Date.valueOf(keyword)));
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public String weeklyTodos(Date[] dates) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < 7; i++) {
      switch (i) {
        case 0:
          sb.append("(일) ");
          break;
        case 1:
          sb.append("(월) ");
          break;
        case 2:
          sb.append("(화) ");
          break;
        case 3:
          sb.append("(수) ");
          break;
        case 4:
          sb.append("(목) ");
          break;
        case 5:
          sb.append("(금) ");
          break;
        case 6:
          sb.append("(토) ");
          break;
      }
      sb.append(findByDate(dates[i]));
    }
    return sb.toString();
  }
  
  public StringBuilder findByDate(Date date) {
    StringBuilder sb = new StringBuilder(date.toString()+ "\n");
    for (Todo todo : todoList) {
      if (todo.getDate().toString().equals(date.toString())) {
        sb.append(todo);
        sb.append("\n");
      }
    }
    return sb;
  }
  
  public static Date[] getCurWeek() {
    Date[] thisWeek = new Date[7];
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    
    for (int i = 0; i < 7; i++) {
      c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY + i);
      thisWeek[i] = Date.valueOf(formatter.format(c.getTime()));      
    }
    return thisWeek;
  }
 
  
}