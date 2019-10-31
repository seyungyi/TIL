package day12;
import java.util.*;
public class UtilTest1 {
   public static void main(String args[]) {
      String[] str={"나", "사", "아", "마", "바", "다", "라", "가"};
      for(String s : str)         
          System.out.print(s+"\t");
      System.out.println();
      int index = Arrays.binarySearch(str, "마");
      System.out.println("\"마\"가 존재하는 위치 : " + index);
      Arrays.sort(str);
      System.out.println("소팅 후....");
      for(String s : str)         
          System.out.print(s+"\t");
      System.out.println();
      Arrays.fill(str, "ㅋ");     
      System.out.println("모든 원소의 값으로 ㅋ를 채운 후....");
      for(String s : str)         
          System.out.print(s+"\t");
   }
}
