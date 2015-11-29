package dev.kyuelin.caching;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class CacheClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int portNum=1234;
		try {
			MemcachedClient c = new MemcachedClient(new InetSocketAddress("hostname", portNum));
			c.set("key", 3600, new Object());
			Object obj = c.get("key");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
