package hdfsexam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSExam {
    public static void main(String[] args){

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
        try {
  
            FileSystem hdfs = FileSystem.get(conf);

            Path path = new Path(args[0]);

			// 리눅스 하둡에서 사용할 경우 주석 처리 아래 if문만
			if(hdfs.exists(path)){ 
				hdfs.delete(path, true); 
			}
			

            FSDataOutputStream out = hdfs.create(path);
            out.writeUTF(args[1]);
            out.close();
           
            //파일출력
            FSDataInputStream input = hdfs.open(path);
            String data = input.readUTF();
            input.close();
            System.out.println("INPUT String : "+data);
           
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
}
