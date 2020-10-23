package com.mini.util;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Picture {
  
  
  public static void getHeader(PrintWriter out) {
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());

    getDoubleLine(out);
    out.printf("%s%20s\n", date, timeNow);
    getDoubleLine(out);
  }
  
  public static void printMailBox(PrintWriter out, int count) {
    out.println("      _________");
    out.println("    .`.        `.");
    out.println("   /   \\ .======.\\");
    out.println("   |   | |______||");
    out.printf("   |   |   _____ | %d개의 \n", count);
    out.println("   |   |  /    / | 안 읽은");
    out.println("   |   | /____/  | 메시지");
    out.println("   | _ |         |");
    out.println("   |/ \\|.-\"```\"-.|");
    out.println("   `` |||      |||");
    out.println("      `\"`      `\"");
    
  }
  
  public static void getSingleLine(PrintWriter out) {
    out.println("------------------------------");
  }
  
  public static void getDoubleLine(PrintWriter out) {
    out.println("==============================");
  }
  
  public static void getStarLine(PrintWriter out) {
    out.println("******************************");
  }
  

  public static void startScreen() throws InterruptedException {
    System.out.println("===========================================================");
    System.out.println("====OOOOOOOO======OOOOOO=======OOOOOOOO=========OOOOOO=====");
    Thread.sleep(300);
    System.out.println("=======OO=======OOO====OOO=====OO====OOO======OOO====OOO===");
    System.out.println("=======OO======OOO======OOO====OO======OO====OOO======OOO==");
    Thread.sleep(300);
    System.out.println("=======OO======OOO======OOO====OO======OO====OOO======OOO==");
    System.out.println("=======OO=======OOO====OOO=====OO====OOO======OOO====OOO===");
    Thread.sleep(300);
    System.out.println("=======OO=========OOOOOO=======OOOOOOOO=========OOOOOO=====");
    System.out.println("===========================================================");
    Thread.sleep(300);
    System.out.println("===========OO=========OOOOOO=====OOOOOO=====OOOOOOOO=======");
    System.out.println("===========OO===========OO=====OOOO============OO==========");
    Thread.sleep(300);
    System.out.println("===========OO===========OO=======OOOOO=========OO==========");
    System.out.println("===========OO===========OO==========OOOOO======OO==========");
    Thread.sleep(300);
    System.out.println("===========OO===========OO=========OOOO========OO==========");
    System.out.println("===========OOOOOOOO===OOOOOO====OOOOOO=========OO==========");
    Thread.sleep(300);
    System.out.println("===========================================================");
    System.out.println("=====================*******************===================");
    Thread.sleep(300);
    System.out.println("=====================로그인==||=회원가입===================");
    System.out.println("=====================*******************===================");
    Thread.sleep(300);
    System.out.println("===========================================================");
    System.out.println("===========================================================");
  }
  public static void mainMorning() throws InterruptedException {
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());


    System.out.println("===================================");
    System.out.printf("%s                 %s\n", date, timeNow);
    System.out.println("===================================");
    System.out.println("           \\  ,  /");
    Thread.sleep(300);
    System.out.println("        ' ,___/_\\___, '");
    System.out.println("          \\ /o.o\\ /");
    Thread.sleep(300);
    System.out.println("      -=   > \\__/ <   =-");
    System.out.println("          /_\\___/_\\");
    Thread.sleep(300);
    System.out.println("       . `   \\ /   ` .");
    System.out.println("            /  `  \\");
  }
  
  
  
  public static void mainNight() throws InterruptedException {
    SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat date2 = new SimpleDateFormat("HH : mm");

    Calendar time = Calendar.getInstance();
    String date = date1.format(time.getTime());
    String timeNow = date2.format(time.getTime());


    System.out.println("===================================");
    System.out.printf("%s                 %s\n", date, timeNow);
    Thread.sleep(300);
    System.out.println("===================================");
    System.out.println("              ___");
    Thread.sleep(300);
    System.out.println("      ~*    .'`  _\\");
    System.out.println("           /  (o/       *");
    Thread.sleep(300);
    System.out.println("*         |      _\\           *");
    System.out.println("           \\  '==.    *");
    Thread.sleep(300);
    System.out.println("        *   '.____\\       ~*");
    System.out.println();
    Thread.sleep(300);
    System.out.println("===================================");
    System.out.println("===================================");
    System.out.println("===================================");
  }
  public static void menuScreen() throws InterruptedException {
    System.out.println("===================================");
    System.out.println("==============일정완료=============");
    System.out.println("-----------------------------------");
    System.out.println("----일정추가---- * ----일정조회----");
    System.out.println("----일정수정---- * ----일정삭제----");
    System.out.println("-----------------------------------");
  }
  public static void weeksReport() throws InterruptedException {

    System.out.println("===================================");
    System.out.println("       %s님의 일주일       ");
    Thread.sleep(300);
    System.out.println("===================================");
    System.out.println("===================================");
    Thread.sleep(300);
    System.out.println("  %s님은 이번 한주간       ");
    System.out.println("  '%s'을 가장 많이하셨네요!");
    System.out.println("  '%s'을 좀더 열심히 하세요 !!");
    Thread.sleep(300);
    System.out.println("         .-----.");
    System.out.println("        |.-----.|");
    System.out.println("        ||x . x||");
    Thread.sleep(300);
    System.out.println("        ||_.-._||");
    System.out.println("        `--)-(--`");
    Thread.sleep(300);
    System.out.println("       __[=== o]___\'");
    System.out.println("       |:::::::::::|\'");
    System.out.println("       `-=========-`()");
    Thread.sleep(300);
    System.out.println("===================================");
    System.out.println("어학==||============================");
    System.out.println("운동==||===========================");
    Thread.sleep(300);
    System.out.println("코딩==||===========================");
    System.out.println("독서==||===========================");
    System.out.println("===================================");
  }


  public static void printScreen(PrintWriter out, int category) {
    switch (category) {
      case 1: 
        out.println(" Blah!");
        out.println("  Blah!      _'._|\\\\/: ");
        out.println("  .          '- '   /_   ");
        out.println("    \\       _/,    \"_< ");
        out.println("     \\__   '._____  _)\\");
        out.println("       —        _/ /    ");
        out.println("               `;—:     ");
        out.println("              _ _ :|_\\: ");
        break;
      case 2:
        out.println("     ______ ______");
        out.println("    _/      Y      \\_");
        out.println("   // ~~ ~~ | ~~ ~  \\\\");
        out.println("  // ~ ~ ~~ | ~~~ ~~ \\\\ ");
        out.println(" //________.|.________\\\\    ");
        out.println("`----------`-'----------'");
        break;
      case 3:
        out.println("            _( }");
        out.println("   -=  _  <<  \\");
        out.println("      `.\\__/`/\\\\");
        out.println(" -=     '--'\\\\  `");
        out.println("      -=    //");
        out.println("jgs         \\)");
        break;
      case 4:
        out.println("         .-----.");
        out.println("        |.-----.|");
        out.println("        ||x . x||");
        out.println("        ||_.-._||");
        out.println("        `--)-(--`");
        out.println("       __[=== o]___\'");
        out.println("       |:::::::::::|\'");
        out.println("       `-=========-`()");
        break;

        
        
    }
  }

}