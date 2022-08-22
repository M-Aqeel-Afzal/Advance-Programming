import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapred.FileInputFormat;
//import org.apache.hadoop.mapred.FileOutputFormat;
//import org.apache.hadoop.mapreduce.JobClient;
//import org.apache.hadoop.mapreduce.JobConf;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
//import org.apache.taglibs.standard.extra.spath.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class MainFyp {
	
	public class FypMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
		//Map function
	  /*  public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
	    {
	       String line = value.toString();
	       String lasttoken = null;
	       StringTokenizer s = new StringTokenizer(line,"\t");
	       String year = s.nextToken();
	       
	       while(s.hasMoreTokens()){
	          lasttoken=s.nextToken();
	       }
	       
	       int avgprice = Integer.parseInt(lasttoken);
	       output.collect(new Text(year), new IntWritable(avgprice));
	    }*/
		
		//Map function
	    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	    {
	       String line = value.toString();
	      System.out.println(line);
	      
	      // context.write(new Text(year), new IntWritable(1));
	    }
	}
	
public class FypDriver {
	 public void main(String args[])throws Exception
	   {
		 
		 Configuration confg =new Configuration();
		 
	      Job job = Job.getInstance(confg,"myjob");
	      job.setJarByClass(MainFyp.class);
	      job.setMapOutputKeyClass(Text.class);
	      job.setMapOutputValueClass(IntWritable.class);
	      job.setMapperClass(FypMapper.class);
	   //   job.setReducerClass(FypReducer.class);
			
	      job.setInputFormatClass(TextInputFormat.class);
	      job.setOutputFormatClass(TextOutputFormat.class);
			
	     FileInputFormat.setInputPaths(job, new Path(args[0]));
	     FileOutputFormat.setOutputPath(job, new Path(args[1]));
	     job.waitForCompletion(true);
	    // JobClient.run(job);
	   }
}









/*this class is responsible for running map reduce job*/
public class maxtemperaturedriver extends Configured implements Tool{
public int run(String[] args) throws Exception
 {

 if(args.length !=2) {
 System.err.println("usage: maxtemperaturedriver <input path> <outputpath>");
 System.exit(-1);
 }

 Configuration confg =new Configuration();
 
 Job job = Job.getInstance(confg,"myjob");
 job.setJarByClass(MainFyp.class);
 job.setMapOutputKeyClass(Text.class);
 job.setMapOutputValueClass(IntWritable.class);
 job.setMapperClass(FypMapper.class);
//   job.setReducerClass(FypReducer.class);
	
 job.setInputFormatClass(TextInputFormat.class);
 job.setOutputFormatClass(TextOutputFormat.class);
	
FileInputFormat.setInputPaths(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));

 System.exit(job.waitForCompletion(true) ? 0:1); 
 boolean success = job.waitForCompletion(true);
 return success ? 0 : 1;
 }
public void main(String[] args) throws Exception {
 maxtemperaturedriver driver = new maxtemperaturedriver();
 int exitcode = ToolRunner.run(driver, args);
 System.exit(exitcode);
 }
}









}