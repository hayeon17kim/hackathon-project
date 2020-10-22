package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;

public class ReportCommand implements Command {
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    try {
      List<Todo> todoList =  member.getTodoList();
      out.println("===================================");
      out.println("       %s님의 일주일       ");
      Thread.sleep(300);
      out.println("===================================");
      out.printf("  %s님은 이번 한주간       ", member.getName());
      out.printf("  '%s'을 가장 많이하셨네요!");
      out.println("  '%s'을 좀더 열심히 하세요 !!");
      report(out, 1);
    } catch (Exception e) {
      System.out.println("리포트 출력 중 에러 발생!");
      e.printStackTrace();
    }
  }
 
  public String getCalcBest(List<Todo> todoList) {
    int[] counts = new int[4];
    String result = "";
    
    for (Todo todo : todoList) {
      switch (todo.getCategory()) {
        case 1:
          counts[0]++;
          break;
        case 2:
          counts[1]++;
          break;
        case 3:
          counts
          break;
        case 4:
          result = "코딩";
          break;
      }
    }
    
    return 1;
  }
  
  public void report(PrintWriter out, int category) throws InterruptedException {
    switch (category) {
      case 1: 
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        break;
      case 2:
        out.println("     ______ ______");
        out.println("    _/      Y      \\_");
        out.println("   // ~~ ~~ | ~~ ~  \\\\");
        out.println("  // ~ ~ ~~ | ~~~ ~~ \\\\ ");
        out.println(" //________.|.________\\\\    ");
        out.println("`----------`-'----------'");
        break;
      case 3:
        out.println("            _( }");
        out.println("   -=  _  <<  \\");
        out.println("      `.\\__/`/\\\\");
        out.println(" -=     '--'\\\\  `");
        out.println("      -=    //");
        out.println("jgs         \\)");
        break;
      case 4:
        Thread.sleep(300);
        out.println("         .-----.");
        out.println("        |.-----.|");
        out.println("        ||x . x||");
        Thread.sleep(300);
        out.println("        ||_.-._||");
        out.println("        `--)-(--`");
        Thread.sleep(300);
        out.println("       __[=== o]___\'");
        out.println("       |:::::::::::|\'");
        out.println("       `-=========-`()");
        break;

        
        
    }
  }

}