package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;

public class MainScreenCommand implements Command {

  Member member;
  
  public MainScreenCommand(Member member) {
    this.member = member;
  }
  
  @Override
  public void execute(PrintWriter out, BufferedReader in) {
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
    return 0;
  }
  
  
  public void list(Member member) {
    System.out.println(member.);
  }
}
