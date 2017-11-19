
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

public class UserMapStoreImpl implements MapStore<String, String>
{
	
        public static Cluster cluster;
        public static Session session;	
	public UserMapStoreImpl()
	{
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("Test Cluster");
	}	
	public synchronized void delete(String key)
	{

	}
	public synchronized void store(String key, String value)
	{

	}
	public synchronized void storeAll(Map<String, String> maps)
	{
	}
	public synchronized void deleteAll(Collection<String> keys)
	{
	}
	public synchronized String load(String key)
	{
   		return("SUCCESS");
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
