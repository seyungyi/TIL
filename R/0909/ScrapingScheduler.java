package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScrapingScheduler {
	static final char UTF_8_WITHOUT_BOM = '\ufeff';	// UTF8 인코딩
	static int cnt = 0;	// 제일 처음 제목 행 1회만 출력하기
	@Scheduled(fixedDelay=100)
	public void scheduleRun() {
		Calendar calendar = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		RConnection rc = null;
		BufferedWriter bw = null;
		try {
			rc = new RConnection();
			REXP x = rc.eval("imsi<-source('c:/Rstudy/0906/Rtask.R'); imsi$value");
			RList list = x.asList();
			String[] title = list.at("newstitle").asStrings();
			String[] name = list.at("newspapername").asStrings();
//			for(int i=0; i<title.length; i++) {
//				System.out.println(title[i] + " " + name[i]);
//			}
			File file = new File("C:/Rstudy/daumnews_schedule.csv");
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath(), true), "UTF8"));
			bw.write(UTF_8_WITHOUT_BOM);	// CSV저장시 인코딩 깨질때 BufferedWriter에 Encoding Set
			if(cnt == 0) {
				bw.write("newstitle, newspapername, datetime\r\n");
				cnt++;
			}
			for(int i=0; i<title.length; i++) {
				calendar = Calendar.getInstance();
				String row = title[i] + "," + name[i] + "," + dateFormat.format(calendar.getTime());
				bw.append(row);
				bw.append("\r\n");
			}
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rc.close();
		}
	}
}
