package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Picture;

public class ReportCommand implements Command {
  int[] counts = new int[4];
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    try {
      List<Todo> todoList =  member.getTodoList();
      calcCounts(todoList);
      int[] rates = calcRate();

      out.println("===================================");
      out.printf("       %s님의 리포트       \n", member.getName());
      out.println("===================================");
      out.printf("  '%s'을 가장 많이하셨네요!\n", categoryString(calcBest(rates)));
      out.println("-----------------------------------");
      Picture.printScreen(out, calcBest(rates));      
      out.println("-----------------------------------");
      out.printf("  '%s'은 좀 더 분발하셔야겠어요.\n", categoryString(calcWorst(rates)));
      out.println("-----------------------------------");
      Picture.printScreen(out, calcWorst(rates));
      out.println("-----------------------------------");
      printGraph(out, rates);
      out.println("-----------------------------------");
      /*
      out.printf("  '%s'을 가장 많이하셨네요!");
      out.println("  '%s'을 좀더 열심히 하세요 !!");
      System.out.println("============================");
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
      report(out, 1);
      */
    } catch (Exception e) {
      System.out.println("리포트 출력 중 에러 발생!");
      e.printStackTrace();
    }
  }
  
  public int calcBest(int[] rates) {
    int maxIdx = 0;
    for (int i = 1; i < rates.length; i++) {
      if (rates[maxIdx] < rates[i])
        maxIdx = i;
    }    
    return maxIdx + 1;
  }
  
  public int calcWorst(int[] rates) {
    int minIdx = 0;
    for (int i = 1; i < rates.length; i++) {
      if (rates[minIdx] > rates[i])
        minIdx = i;
    }    
    return minIdx + 1;
  }
  
  
  public String categoryString(int category) {
    switch (category) {
      case 1:
        return "어학";
      case 2:
        return "독서";
      case 3:
        return "운동";
      default:
        return "코딩";
    }
  }
  
  
  public void calcCounts(List<Todo> todoList) {
    for (Todo todo : todoList) {
      counts[todo.getCategory() - 1]++;
    }
  }
  
  public int[] calcRate() {
    int[] rates = new int[4];
    int sum = counts[0] + counts[1] + counts[2] + counts[3];
    for (int i = 0; i < counts.length; i++) {
      rates[i] = (int) ((double) counts[i] / (double) sum * 30);
    }
    return rates;
  }
 
  public void printGraph(PrintWriter out, int[] rates) {
    out.print("어학 | ");
    printStars(out, rates[0]);
    out.print("독서 | ");
    printStars(out, rates[1]);
    out.print("운동 | ");
    printStars(out, rates[2]);
    out.print("코딩 | ");
    printStars(out, rates[3]);
  }
  
  
  public void printStars(PrintWriter out, int count) {
    for (int i = 0; i < count; i++) {
      out.print("*");
    }
    out.println();
  }
  

}