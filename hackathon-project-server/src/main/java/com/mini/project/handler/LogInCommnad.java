package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.util.Prompt;

public class LogInCommnad implements Command {
  
  List<Member> memberList;
  Member loggedMember;

  public LogInCommnad(List<Member> list, Member member) {
    this.memberList = list;
    this.loggedMember = member;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    //..
  }
  
  public Member logIn() {
    System.out.println("아이디와 비밀번호를 입력해주세요. ");
    System.out.println("아이디에 빈 문자열을 입력하시면 취소됩니다.");
    while (true) {
      String Id = Prompt.inputString("아이디: ");
      if (Id.equals(""))
        return null;

      String password = Prompt.inputString("비밀번호: ");

      if (findById(Id) == null) {
        System.out.println("아이디를 찾을 수 없습니다.");

      } else if (!findById(Id).getPassword().equals(password)) {
        System.out.println("비밀번호가 틀렸습니다.");
      } else {
        return findById(Id);
      }
    }
  }
  
  public Member findById(String Id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getId().equals(Id)) {
        return member;
      }
    }
    return null;
  }

}
