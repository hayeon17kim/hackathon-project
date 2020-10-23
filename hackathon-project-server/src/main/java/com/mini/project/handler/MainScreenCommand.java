package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.project.domain.Todo;
import com.mini.util.Picture;

public class MainScreenCommand implements Command {

  List<Todo> todoList;
  public MainScreenCommand() {

  }
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    
    if (member.getId().equals("default")) {
      out.println(" ");
      out.println("비회원으로 입장합니다");
      Picture.printLogo(out);
      out.printf("프로그램을 사용하기 위해서는 로그인이 필요합니다.\n", "");
      out.println(" ");
      return;
    }
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());
    todoList = member.getTodoList();

    Picture.getHeader(out);
    getTimeScreen(out, in, timeNow);
    out.println("    " + member.getStatus() + "    ");
    Picture.getDoubleLine(out);
    String message = getTimeMessage(timeNow);
    System.out.println(timeNow);
    out.printf("%s님, %s \n", member.getName(), message);
    out.printf("%d개의 할 일이 남았습니다.\n", countTodo(todoList, date));
    out.printf("%s개의 안 읽은 메시지가 있습니다.\n", countNotReadMessage(member.getMessageList()));
    Picture.getDoubleLine(out);
    for (Todo todo : todoList) {
      if (todo.getDate().toString().equals(date)) {
        out.println(todo);
      }
    }
    Picture.getDoubleLine(out);
  }
  
  public int countNotReadMessage(List<Message> list) {
    int result = 0;
    
    for (Message message : list) {
      if (!message.isRead())
        result++;
    }
    return result;
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
  
  public String getTimeMessage(String timeNow) {
    int hour = Integer.parseInt(timeNow.substring(0, 2));
    if (12 <= hour && hour < 18) {
      return "좋은 오후입니다!";
    } else if(0 <= hour && hour < 6) {
      return "좋은 밤입니다!";
    } else if (6 <= hour && hour < 12) {
      return "오늘 하루도 화이팅하세요!";
    } else {
      return "좋은 저녁입니다.";
    }
  }
  
  public void getTimeScreen(PrintWriter out, BufferedReader in, String timeNow) {
    int hour = Integer.parseInt(timeNow.substring(0, 2));
    if (12 <= hour && hour < 18) {
      out.println("           \\  ,  /");
      out.println("        ' ,___/_\\___, '");
      out.println("          \\ /o.o\\ /");
      out.println("      -=   > \\__/ <   =-");
      out.println("          /_\\___/_\\");
      out.println("       . `   \\ /   ` .");
      out.println("            /  `  \\");
    } else if(0 <= hour && hour < 6) {
      out.println("  ☆.。.:*・°☆.。.:*・°");
      out.println("       ☆.。.:*・°☆.。.:*・°");
      out.println("   ☆.。.:*・°☆.。.:*・°");
      out.println("  `");
      out.println("     .           .");
      out.println("    /|__________/|");
      out.println("  .// /       .//|");
      out.println("  |/_/________|//|");
      out.println("  |_|_________|/");
      out.println("  |           |   ");
      
    } else if (6 <= hour && hour < 12) {
      out.println("           |");
      out.println(" _.—.  \\ _ /");
      out.println("(_._ ) )—(_) =-");
      out.println("  '—'.__   \\");
      out.println("            |");
      out.println("   ");
      out.println(" -^~^~|\\ ~^-~^~-");
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
