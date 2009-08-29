package NewtonERP.Logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author r3hallejo
 * 
 * 
 * Class used to log system messages into an external log for purposes
 * of viewing errors, information messages, warnings and much more 
 * that has happen on a later time. For debugging.
 * 
 * HOWTO :
 * 
 * 1. Create a Log object
 * 2. Use the "log" method like this :
 * 		logger.log("MY MESSAGE GOES HERE", Log.State.STATE_OF_MESSAGE)
 * 
 * See the state enumeration for all the actual states available
 */
public class Log {
	
	private FileWriter fstream;
	private BufferedWriter out;
	private GregorianCalendar gc = new GregorianCalendar();
	private SimpleDateFormat sdf = new SimpleDateFormat("K:mm yyyy.MM.dd");
	
	public enum State {
		INFO, WARNING, ERROR
	}
	
	public void log(String message, State state) {
		try {
			fstream = new FileWriter("logs.txt",true);
			out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
		try {
			switch (state) {
				default :
				case INFO:
					out.write('\n'+"[INFO "+ sdf.format(gc.getTime())+"] +"+message);
					break;
				case WARNING:
					out.write('\n'+"[WARNING "+ sdf.format(gc.getTime())+"] +"+message);
					break;
				case ERROR:
					out.write('\n'+"[ERROR "+ sdf.format(gc.getTime())+"] +"+message);
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(message);
	}
}
