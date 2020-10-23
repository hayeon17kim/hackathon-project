package com.mini.project.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import com.mini.project.domain.Member;
import com.mini.project.domain.Message;
import com.mini.util.Prompt;

public class MessageDeleteCommand implements Command {


  List<Member> memberList;
  List<Message> messageList;

  public MessageDeleteCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Member loggedInMember) {
    messageList = loggedInMember.getMessageList();
    try {
      out.println("[메시지 삭제]");
      String title = Prompt.inputString("제목", out, in);
      int index = indexOf(title);

      if (index == -1) {
        out.println("해당 제목의 메시지가 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("메시지 삭제를 취소하였습니다.");
        return;
      }

      messageList.remove(index);
      out.println("메시지를 삭제하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private int indexOf(String title) {
    for (int i = 0; i < messageList.size(); i++) {
      Message message = messageList.get(i);
      if (message.getTitle().equals(title)) {
        return i;
      }
    }
    return -1;
  }
}