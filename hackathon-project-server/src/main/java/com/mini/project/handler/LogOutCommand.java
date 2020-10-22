package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.mini.project.domain.Member;

public class LogOutCommand implements Command {
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    out.println("$%$$%$");
    out.println();
    out.flush();
  }
}
