package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import com.mini.project.domain.Member;
import com.mini.util.Picture;

public class LogOutCommand implements Command {
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    out.println("$%$$%$");
    Picture.printLogo(out);
    out.printf("%10s님, 안녕히가세요!\n", member.getName());
    out.println();
    out.flush();
  }
}
