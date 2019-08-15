package hdfsexam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
public class FileSystemCat {
   public static void main(String[] args) throws Exception {
	Configuration conf = new Configuration();
	conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
	FileSystem hdfs = FileSystem.get(conf);
	FSDataInputStream in = null;
	try {
	    in = hdfs.open(new Path("/edudata/president_moon.txt"));
	    IOUtils.copyBytes(in, System.out, 4096, false);
	} finally {
   	    IOUtils.closeStream(in);
	}
    }
}
