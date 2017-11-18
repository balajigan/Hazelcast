package com.batria;

/**
 * Hazelcast server main class
 *
 */
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hazelcast server started ... !" );
	HazelcastInstance hz = Hazelcast.newHazelcastInstance();
	while(true)
	{
	}
    }
}



