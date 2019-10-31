package day13;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
public class SerialTest2 {
   public static void main(String[] args) throws Exception{ 
      FileInputStream fis = 
    		  new FileInputStream("c:/iotest/test1.ser"); 
      ObjectInputStream ois = new ObjectInputStream(fis); 
      Date value1 = (Date)ois.readObject(); // readObject()는 항상 Object(부모객체)로 받기때문에 형변환 필요
      Date value2 = (Date)ois.readObject();
      System.out.println("Date객체 데이터 : " + value1); 
      System.out.println("Date객체 데이터 : " + value2); 
      ois.close();
      fis.close();
   }
}



