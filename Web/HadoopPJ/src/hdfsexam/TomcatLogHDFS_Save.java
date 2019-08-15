package hdfsexam;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs	.FileSystem;
import org.apache.hadoop.fs.Path;

public class TomcatLogHDFS_Save {
	public static void main(String[] args) {
		// 파일 경로 및 이름
		String filePath = "c:/Users/student/ys/Linux/강사로그/";
		String fname = "tomcat_access_log.txt";
		try {
			File folder = new File(filePath);
			BufferedReader br = null;
			PrintWriter out = new PrintWriter(new FileWriter(filePath+fname));
			String line = null;
			// 폴더 내 파일 리스트 출력
			for(File data : folder.listFiles()) {
				// 저장하려는 파일이름의 파일은 생략
				if(data.getName().equals(fname))
					continue;
				// 각각 리스트 파일 준비
				br = new BufferedReader(new FileReader(data));
				// 라인별로 텍스트 저장
				while((line = br.readLine()) != null) {
					out.write(line);
					out.println();
				}
			}
			out.close();
			br.close();
			
			// 윈도우에서 리눅스 하둡으로 전달
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
			FileSystem hdfs = FileSystem.get(conf);
			File f = new File(filePath + fname);
			if (!f.exists()) {
				System.out.println("파일이 없음!!");
				return;
			}
			Path path = new Path("/edudata/" + fname);
			if (hdfs.exists(path)) {
				hdfs.delete(path, true);
			}
			long size = f.length();
			FileReader fr = new FileReader(f);
			char[] content = new char[(int) size];
			fr.read(content);
			FSDataOutputStream outStream = hdfs.create(path);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));
			writer.write(content);
			writer.close();
			outStream.close();
			fr.close();
			System.out.println(size + " 크기의 데이터 출력 완료!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
