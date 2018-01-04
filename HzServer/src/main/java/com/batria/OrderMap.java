
/* User Map store implementation for connacting Haxelcast to Cassandra
 *
 * */

package com.batria;

import com.hazelcast.core.MapStore;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.batria.Connection;
import com.hazelcast.internal.ascii.rest.RestValue;

public class OrderMap implements MapStore<String, String>
{
	
        public static Cluster cluster = null;
        public static Session session = null;
	private String serverIp="127.0.0.1";	
	public OrderMap()
	{
		if(session == null)
		{
			Connection conn = new Connection(serverIp);
			session = conn.getSession();
		}
		System.out.println("Constructor called...");
	}	
	public synchronized void delete(String key)
	{

	}
	public void store(String key, String obj)
	{
                System.out.println("MapStore.Store is called $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Key = " + key);
		System.out.println("Value = " + obj);

		// Don't handle the exception here. So that, we will pass on the same to caller.
		session.execute("INSERT INTO test.orders JSON " + "'" + obj + "'");
	}
	public synchronized void storeAll(Map<String, String> maps)
	{
		System.out.println("StoreAll is called ####################################");
	}
	public synchronized void deleteAll(Collection<String> keys)
	{
	}
	public String load(String orderId)
	{      
	        System.out.println("MapStore.Load method is called..");

		// Don't handle the exception here. So that, we will pass on the same to caller.
		ResultSet resultSet = session.execute("SELECT JSON * FROM test.orders WHERE order_id="+ "'"+orderId+"'");
		String jsonString = null;
		Row row = resultSet.one();
		if(row != null)
		{
			jsonString = row.getString(0);
		}
   		return(jsonString);
	}
	public synchronized Map<String, String> loadAll(Collection<String> keys)
	{
		Map<String, String> result = new HashMap<String, String>();
		return result;
	}
	public Iterable<String> loadAllKeys()
	{
		return null;
	}
}
