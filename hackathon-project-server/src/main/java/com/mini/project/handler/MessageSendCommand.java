package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.util.Prompt;

public class MessageSendCommand implements Command {
  
  List<Member> memberList;

  public MessageSendCommand (List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    try {
      String id = Prompt.inputString("아이디: ", out, in);
      Member member = findById(id);

      if (member == null) {
        out.println("해당 아이디의 회원이 없습니다.");
        return;
      }
      String title = Prompt.inputString("메시지 제목: ", out, in);
      String content = Prompt.inputString("메시지 내용: ", out, in);
      Message message = new Message(loggedInMember, title, content);
      
      member.getMessageList().add(message);
      
      out.printf("%s님께 메시지를 보냈습니다!\n", member.getName());
      
    } catch (Exception e) {
      e.printStackTrace();
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
