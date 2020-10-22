package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.mini.project.domain.Member;

// Command 규칙에 따라 클래스를 정의한다.
public class HelloCommand implements Command {

  public void execute(PrintWriter out, BufferedReader in, Member member) {
    if (member.getId().equals(("$%$"))) {
      out.println("로그인 먼저 해주세요.");
    } else {
      out.printf("%s님, 안녕하세요!\n", member.getId());      
    }
    out.println();
    out.flush();
  }
}
