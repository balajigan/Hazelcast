package com.batria;

/**
 * HzClient program
 *
 */

//import java.util.IMap;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.batria.Order;

//import com.hazelcast.config.GroupConfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "HzClient started ..." );
	
	ClientConfig clientConfig = new ClientConfig();
	clientConfig.getGroupConfig().setName("HzCluster").setPassword("HzCluster");
	clientConfig.getNetworkConfig().addAddress("10.128.0.2:5703");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

//        IMap<String, String> mapOrders = client.getMap("orders");
//	mapOrders.put("1", "First Order");
//	mapOrders.put("2", "Second Order");

	IMap<String, Order> mapOrders = client.getMap("ordersObj");
//	Order order1 = new Order();
//	order1.setOrderId("1");
//	order1.setOrderDesc("Sample Order using Obj");
//	order1.setPrdId("PrdId1000");
//	order1.setOrderQty(250);
//	mapOrders.put("1", order1);

	Order order2 = mapOrders.get("1");
        System.out.println("OrderDesc = " + order2.getOrderDesc());

	client.shutdown();
    }
}
