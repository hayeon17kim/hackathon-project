package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.util.Picture;
import com.mini.util.Prompt;

public class LogInCommand implements Command {
  
  List<Member> memberList;

  public LogInCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member member) {
    try {
      logIn(out, in);      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public Member logIn(PrintWriter out, BufferedReader in) throws Exception {
      out.println("아이디와 비밀번호를 입력해주세요. ");
      out.println("아이디에 빈 문자열을 입력하시면 취소됩니다.");
      while (true) {
        String id = Prompt.inputString("아이디: ", out, in);
        if (id.equals(""))
          return null;
        
        String password = Prompt.inputString("비밀번호: ", out, in);
        
        if (findById(id) == null) {
          out.println("아이디를 찾을 수 없습니다.");
          
        } else if (!findById(id).getPassword().equals(password)) {
          out.println("비밀번호가 틀렸습니다.");
        } else {
          out.println("$%$" +  id);
          Picture.printLogo(out);
          out.printf("%13s님, 안녕하세요!\n", findById(id).getName());
          out.println();
          out.flush();
          return findById(id);
        }
      }
  }
  
  public Member findById(String id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

}
