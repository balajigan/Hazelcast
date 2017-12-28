
package com.batria;

import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Exception;
import com.batria.Connection;
import org.apache.log4j.Logger;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.batria.Order;

public class PopulateData implements Runnable
{
	private static Logger logger = Logger.getLogger(PopulateData.class);
	int initialValue=0;
	int count=0;
	public PopulateData()
	{

	}
	public PopulateData(int initialValue, int count)
	{
		this.initialValue = initialValue;
		this.count = count;
	}

	public void run()
	{
		try{
		//Thread.sleep(10000);
		}
		catch(Exception ex)
		{
		}
		Connection conn = new Connection();
		HazelcastInstance client = conn.getClient();
		
		for(int loopCount = 0; loopCount < count ; loopCount++)
		{
			initialValue = initialValue+1;
			//System.out.println("Current Value = " + initialValue);
			try
			{
				//Thread.sleep(1000);
				GenerateOrder generateOrder = new GenerateOrder();
				String jsonOrderString = generateOrder.getOrderJsonString(initialValue);
				logger.info("orderId = "+Integer.toString(initialValue));				
				IMap<String, String> mapOrders = client.getMap("ordersMap");
				mapOrders.put(Integer.toString(initialValue), jsonOrderString);
			//	session.execute("INSERT INTO test.orders json " + "'"+jsonOrderString + "'");
			//	System.out.println(jsonOrderString);	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}

		}
		String threadName = Thread.currentThread().getName();
		logger.info("Thread : " + threadName + " finished the execution");
		System.out.println("Thread : " + threadName + " finished the execution");
	}
}
