package com.batria;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.batria.Order;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import com.google.gson.Gson;
import com.batria.Connection;
import org.json.JSONObject;
import com.batria.PopulateData;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger("App");

    public static void main( String[] args )
    {
        System.out.println( "Application Started ... " );
        
	Connection conn = null;
	int numberOfRowsPerThread = 100; //00000;
	int numberOfThreads = 20;
	int initialOrderId = 1000;
        String serverIpAddress = "127.0.0.1:5701";
	// Log4j configuration
	PatternLayout layout = new PatternLayout();
	String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
	layout.setConversionPattern(conversionPattern);

	ConsoleAppender consoleAppender = new ConsoleAppender();
	consoleAppender.setLayout(layout);
        consoleAppender.activateOptions();
	
	FileAppender fileAppender = new FileAppender();
	fileAppender.setFile("client.log");
	fileAppender.setLayout(layout);
	fileAppender.activateOptions();

	Logger rootLogger = Logger.getRootLogger();
	rootLogger.setLevel(Level.INFO);
//	rootLogger.addAppender(consoleAppender);
	rootLogger.addAppender(fileAppender);
	logger.info("@@@@@@@@@@@@@@@@@  Application Started @@@@@@@@@@@@@@@@@@@");

      try{
        conn = new Connection(serverIpAddress);
	HazelcastInstance client = conn.getClient();

	for(int threadCount = 0; threadCount < numberOfThreads; threadCount++)
	{
		String threadName = "Thread"+Integer.toString(threadCount);
		int startOrderId = initialOrderId + (numberOfRowsPerThread*threadCount);
		Thread thread1 = new Thread(new PopulateData(startOrderId ,numberOfRowsPerThread), threadName);
		thread1.start();
	}

	//System.out.println("Exit from main");
	logger.info("Exit from main");
       }
      catch(Exception ex)
      {
	      //System.out.println("Exception !!!");
	      logger.error("Exception in Application");
	      ex.printStackTrace();
      }
      finally
      {
	    //  conn.close();
      }
    }
}
