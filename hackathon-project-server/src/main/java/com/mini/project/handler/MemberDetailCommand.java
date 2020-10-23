package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Todo;
import com.mini.util.Prompt;

public class MemberDetailCommand implements Command {

  List<Member> memberList;

  public MemberDetailCommand(List<Member> list) {
    this.memberList = list;
  }

  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    try {
      out.println("[회원 상세보기]");
      String id = Prompt.inputString("아이디? ", out, in);
      Member member = findById(id);

      if (member == null) {
        out.println("해당 이름의 회원이 없습니다.");
        return;
      }

      out.printf("이름: %s\n", member.getName());
      out.printf("비밀번호: %s\n", member.getPassword());
      out.printf("[Todo List]\n");
      for (Todo todo : member.getTodoList()) {
        out.println(todo);
      }

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private Member findById(String id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }


}
