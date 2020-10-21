package com.mini.project.listener;

import java.util.List;
import java.util.Map;
import com.mini.context.ApplicationContextListener;
import com.mini.project.domain.Board;
import com.mini.project.domain.Member;
import com.mini.project.domain.Project;
import com.mini.project.domain.Task;
import com.mini.project.handler.BoardAddCommand;
import com.mini.project.handler.BoardDeleteCommand;
import com.mini.project.handler.BoardDetailCommand;
import com.mini.project.handler.BoardListCommand;
import com.mini.project.handler.BoardUpdateCommand;
import com.mini.project.handler.CalculatorCommand;
import com.mini.project.handler.HelloCommand;
import com.mini.project.handler.MemberAddCommand;
import com.mini.project.handler.MemberDeleteCommand;
import com.mini.project.handler.MemberDetailCommand;
import com.mini.project.handler.MemberListCommand;
import com.mini.project.handler.MemberUpdateCommand;
import com.mini.project.handler.ProjectAddCommand;
import com.mini.project.handler.ProjectDeleteCommand;
import com.mini.project.handler.ProjectDetailCommand;
import com.mini.project.handler.ProjectListCommand;
import com.mini.project.handler.ProjectUpdateCommand;
import com.mini.project.handler.TaskAddCommand;
import com.mini.project.handler.TaskDeleteCommand;
import com.mini.project.handler.TaskDetailCommand;
import com.mini.project.handler.TaskListCommand;
import com.mini.project.handler.TaskUpdateCommand;

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.
    List<Board> boardList = (List<Board>) context.get("boardList");
    List<Member> memberList = (List<Member>) context.get("memberList");
    List<Project> projectList = (List<Project>) context.get("projectList");
    List<Task> taskList = (List<Task>) context.get("taskList");

    context.put("/board/add", new BoardAddCommand(boardList));
    context.put("/board/list", new BoardListCommand(boardList));
    context.put("/board/detail", new BoardDetailCommand(boardList));
    context.put("/board/update", new BoardUpdateCommand(boardList));
    context.put("/board/delete", new BoardDeleteCommand(boardList));

    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    context.put("/member/add", new MemberAddCommand(memberList));
    context.put("/member/list", memberListCommand);
    context.put("/member/detail", new MemberDetailCommand(memberList));
    context.put("/member/update", new MemberUpdateCommand(memberList));
    context.put("/member/delete", new MemberDeleteCommand(memberList));

    context.put("/project/add", new ProjectAddCommand(projectList, memberListCommand));
    context.put("/project/list", new ProjectListCommand(projectList));
    context.put("/project/detail", new ProjectDetailCommand(projectList));
    context.put("/project/update", new ProjectUpdateCommand(projectList, memberListCommand));
    context.put("/project/delete", new ProjectDeleteCommand(projectList));

    context.put("/task/add", new TaskAddCommand(taskList, memberListCommand));
    context.put("/task/list", new TaskListCommand(taskList));
    context.put("/task/detail", new TaskDetailCommand(taskList));
    context.put("/task/update", new TaskUpdateCommand(taskList, memberListCommand));
    context.put("/task/delete", new TaskDeleteCommand(taskList));

    context.put("/hello", new HelloCommand());

    context.put("/calc", new CalculatorCommand());
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
