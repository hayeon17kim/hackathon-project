package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.util.Picture;

public class MessageListCommand implements Command {
  
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    try {
      
      Picture.getHeader(out);
      out.println("      메시지함     ");
      Picture.printMailBox(out);
      
      Picture.getSingleLine(out);
      
      
      for (Message message : loggedInMember.getMessageList()) {
        out.println((message.isRead()  ? " ●" : " ○") + " | " + message.getSender().getName() + " | " + message.getContent());
      }
      Picture.getDoubleLine(out);
      

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

}
