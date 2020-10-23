package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.util.Picture;

public class MessageListCommand implements Command {
  
  List<Member> memberList;
  List<Message> messageList;

  public MessageListCommand(List<Member> list) {
    this.memberList = list;
  }
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    try {
      messageList = loggedInMember.getMessageList();
      
      Picture.getHeader(out);
      out.printf("    %s님의 메시지함   \n", loggedInMember.getName());
      Picture.printMailBox(out, countNotReadMessage(loggedInMember.getMessageList()));
      
      Picture.getSingleLine(out);
      
      
      
      for (Message message : loggedInMember.getMessageList()) {
        Member sender = findById(message.getSender());
        out.println((message.isRead()  ? " ●" : " ○") + " | " + sender.getId() + " | " + message.getTitle());
      }
      Picture.getDoubleLine(out);
      

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
  public int countNotReadMessage(List<Message> list) {
    int result = 0;
    
    for (Message message : list) {
      if (!message.isRead())
        result++;
    }
    return result;
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
