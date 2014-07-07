package dev.kyuelin.caching;

import net.spy.memcached.MemcachedClient;

public class ReaderImpl implements ICacheReader {
	
	private MemcachedClient cacheClient;

	@Override
	public <T extends ICachable> T readCache(String key) {
		// TODO Auto-generated method stub
		T t = (T) cacheClient.get(key);
		return t;
	}

}
