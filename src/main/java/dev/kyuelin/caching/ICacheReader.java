package dev.kyuelin.caching;

public interface ICacheReader {
	<T extends ICachable> T readCache(String key);

}
