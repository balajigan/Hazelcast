package com.batria;

/**
 * HzClient program
 *
 */

//import java.util.IMap;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

//import com.hazelcast.config.GroupConfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "HzClient started ..." );
	
	ClientConfig clientConfig = new ClientConfig();
	clientConfig.getGroupConfig().setName("dev").setPassword("dev-pass");
	clientConfig.getNetworkConfig().addAddress("130.211.209.169:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
//	IMap<String, String> mapOrders = client.getMap("orders");
//	mapOrders.put("1", "First Order");
//	mapOrders.put("2", "Second Order");

	client.shutdown();
    }
}
