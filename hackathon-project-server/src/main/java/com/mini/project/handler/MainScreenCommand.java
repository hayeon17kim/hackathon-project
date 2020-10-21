package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainScreenCommand implements Command {

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    Date date = new Date();
    System.out.println(date);
    
    SimpleDateFormat simpl = new SimpleDateFormat("yyyy년 mm월 dd일 hh시 mm분");
    String s = simpl.format(date);
    System.out.println("date: " + s);
  }
  
  /*
  public void list(Member member) {
    System.out.println(member.);
  }
  */
}
