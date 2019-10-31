package day13;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import day6.Product;
public class SerialTest3 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos = 
    		  new FileOutputStream("c:/iotest/test2.ser"); 
      ObjectOutputStream oos = 
    		  new ObjectOutputStream(fos);
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date()); 
      Product st = new Product("듀크볼펜", 100, 3000);
      oos.writeObject(st); // Product 객체가 Serializable을 상속받아야 직렬화 가능함
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



