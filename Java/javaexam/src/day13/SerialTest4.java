package day13;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

import day6.Product;
public class SerialTest4 {
   public static void main(String[] args) throws Exception{ 
      FileInputStream fis = 
    		  new FileInputStream("c:/iotest/test2.ser"); 
      ObjectInputStream ois = new ObjectInputStream(fis); 
      Date value1 = (Date)ois.readObject();
      Date value2 = (Date)ois.readObject();
      Product st = (Product)ois.readObject();
      System.out.println("Date객체 데이터 : " + value1); 
      System.out.println("Date객체 데이터 : " + value2); 
      StringBuffer sb = new StringBuffer();
      sb.append("이름 - "+st.getName());
      sb.append(", 재고량 - "+st.getBalance());
      sb.append(", 가격 - "+st.getPrice());
      System.out.println("Product 객체 데이터 : " + sb);
      ois.close();
      fis.close();
   }
}



