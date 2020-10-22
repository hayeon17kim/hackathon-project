package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.util.Picture;
import com.mini.util.Prompt;

public class MessageDetailCommand implements Command {

  List<Message> messageList;
  
  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    messageList = loggedInMember.getMessageList();
    try {
      String title = Prompt.inputString("제목", out, in);
      Message message = findByTitle(title);

      if (message == null) {
        out.println("해당 제목의 메시지가 없습니다.");
        return;
      }
      message.setRead(true);
      Picture.getHeader(out);
      out.printf("     %s     \n", title);
      Picture.getSingleLine(out);
      out.printf(" 제목 | %s\n", message.getTitle());
      Picture.getSingleLine(out);
      out.printf(" 발신 | %s\n", message.getSender().getName());
      out.printf(" 날짜 | %s\n", getTime(message.getTime()));
      out.printf(" 내용 | %s\n", message.getContent());

      Picture.getDoubleLine(out);
    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
  public static String getTime(long time) {
    SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String str = dayTime.format(new Date(time));
    return str;
  }
  private Message findByTitle(String title) {
    for (Message message : messageList) {
      if (message.getTitle().equals(title)) {
        return message;
      }
    }
    return null;
  }
}