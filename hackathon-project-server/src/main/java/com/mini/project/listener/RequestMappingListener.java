package com.mini.project.listener;

import java.util.List;
import java.util.Map;
import com.mini.context.ApplicationContextListener;
import com.mini.project.domain.Board;
import com.mini.project.domain.Member;
import com.mini.project.domain.Project;
import com.mini.project.domain.Task;

import com.mini.project.handler.CalculatorCommand;
import com.mini.project.handler.HelloCommand;
import com.mini.project.handler.LogInCommand;
import com.mini.project.handler.MainScreenCommand;
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

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.s
    List<Member> memberList = (List<Member>) context.get("memberList");
    List<Project> projectList = (List<Project>) context.get("projectList");


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
    context.put("/login", new LogInCommand(memberList));
    
    context.put("/main", new MainScreenCommand());

    context.put("/hello", new HelloCommand());

    context.put("/calc", new CalculatorCommand());
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }
}
