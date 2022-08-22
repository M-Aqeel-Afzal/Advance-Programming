import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;

public class FypReducer extends Mapper<LongWritable, Text, Text, IntWritable> {
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
