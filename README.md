# ✍ 일정관리 앱✨
 
- 비트캠프 2차 해커톤에서 진행한 팀 프로젝트입니다.
- 팀원: 이승혁, 김하연

## 일지
### 2020-10-21
#### 기획

**Command List**
* Member
 - /member/add    - 새로운 회원가입을 받는다.
 - /member/list   - 가입된 회원 정보를 본다. (Command 클래스에 Member 을 받으며 로그인을 하지 않으면 사용 할수 없다.)
 - /member/detail - 아이디 정보를 입력하여 회원정보를 간략히 출력해준다.
 - /member/update - 아이디 입력으로 회원정보를 수정할 수 있다.
 - /member/delete - 회원정보를 삭제할 수 있다.
 
* Todo
 - /todo/add      - 스케줄을 추가할수 있다.
 - /todo/delete   - 이미 등록된 스케줄을 삭제할 수 있다.
 - /todo/detail   - 등록된 스케줄의 상세정보를 확인할 수 있다.
 - /todo/list     - 스케줄 정보를 현재 날짜에 맞추어 출력해 준다.
 - /todo/update   - 등록된 할 일 정보를 수정할 수 있다.
 - /todo/check    - 해야할 일의 완료,비완료 상태를 체크할 수 있다.
 
 * Message
  - /message/send - 입력한 회원에게 메시지를 전송할 수 있다.
  - /message/list - 현재 회원정보를 바탕으로 전송받은 메시지 리스트를 출력해준다.
  - /message/delete - 제목 검색을 통해 전송받은 메시지를 삭제할 수 있다.
  - /message/detail - 제목 검색을 통해 메시지를 스크린에 표시해준다.
  
 * indenpendent Command

 - /              - 현재시간, 상태, 오늘의 할일을 출력한다.
 - /login         - 등록된 회원정보를 바탕으로 로그인 할수 있다.
 - /status        - 간단한 상태메시지를 등록하고 main화면에 보여준다.
 - /report        - 주간 완료한 일을 바탕으로, 많이한 일, 부족한 일 의 상태를 출력한다.
 - /hello         - 로그인 정보를 바탕으로 간단한 메시지를 출력한다.
 

**메인 화면**


- 현재 시스템의 날짜와 시간을 출력합니다.
- 현재 시스템의 시간 정보에 맞게 아스키 아트를 출력합니다.
- 현재 상태메시지를 등록하고 상태 메시지를 출력합니다.
- "`로그인 한 멤버명`님, 총 `완료하지 않은 Todo 개수` 개의 할 일이 남았습니다." 메시지를 출력한다.
- 시스템 날짜에 따른 할 일 정보 목록을 출력한다.
 - 시간 순으로 정렬한다.
 - 할 일 정보: 완료여부(● : 완료, ○ : 미완료), 항목, 제목

*예시 화면*

![image](https://user-images.githubusercontent.com/50407047/96745433-18e33b80-1401-11eb-8556-57512df9b50f.png)

![image](https://user-images.githubusercontent.com/50407047/96745570-3ca68180-1401-11eb-96f3-e4f8d01838f5.png)


**일주일 통계 화면**
- 일주일 간 완료한 Todo 항목의 비율을 계산해 그래프로 출력합니다.
- 일주일 간 많이 한 항목에 해당하는 아스키 아트를 출력합니다.

*예시 화면*

![image](https://user-images.githubusercontent.com/50407047/96745057-aa05e280-1400-11eb-8448-83fec3f4f148.png)

![image](https://user-images.githubusercontent.com/50407047/96745158-c99d0b00-1400-11eb-9314-ddd14f6392ac.png)


