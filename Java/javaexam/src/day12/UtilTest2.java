package day12;
import java.util.*;
public class UtilTest2 {
   public static void main(String args[]) {
      Date d = new Date();

      System.out.println("현재 시간 : " + d);
      System.out.println("1970년 1월 1월 0시부터 경과한 밀리초 단위의 현재 시간 : " + 
                             d.getTime());
      long nextDay = d.getTime() + 60*60*24*1000;
      d.setTime(nextDay);
      System.out.println("하루 지난 시간 : " + d);
      System.out.println( "현재로 부터 하루 지난 1970년 1월 1월 0시부터"+
                                       " 밀리초 단위의 시간 : " + d.getTime());
   }
}

