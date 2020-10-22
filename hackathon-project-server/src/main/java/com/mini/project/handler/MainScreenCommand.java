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

  
  public MainScreenCommand() {

  }
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    out.println("============================");
    SimpleDateFormat simpl = new SimpleDateFormat("yyyy-mm-dd                        hh:mm");
    out.println("============================");
    
    
    out.println("아스키아트 나오는 곳");
    out.println("명언 랜덤으로 나오는 곳");
    out.printf("%s님, 총 %d개의 할 일이 남았습니다.", member.getName(), member.getTodoList().size());
    
    Date date = new Date();
    System.out.println(date);
    
    String s = simpl.format(date);
    System.out.println("date: " + s);
  }
  
  public int calcHowManyTodo(List<Todo> list) {
    //for (int i = )
    
    return 0;
  }
  
  
  public void list() {
    System.out.println();
  }
  
  public static void mainMorning() throws InterruptedException {
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());


    System.out.println("===================================");
    System.out.printf("%s                 %s\n", date, timeNow);
    System.out.println("===================================");
    System.out.println("           \\  ,  /");
    Thread.sleep(300);
    System.out.println("        ' ,___/_\\___, '");
    System.out.println("          \\ /o.o\\ /");
    Thread.sleep(300);
    System.out.println("      -=   > \\__/ <   =-");
    System.out.println("          /_\\___/_\\");
    Thread.sleep(300);
    System.out.println("       . `   \\ /   ` .");
    System.out.println("            /  `  \\");
  }
}
