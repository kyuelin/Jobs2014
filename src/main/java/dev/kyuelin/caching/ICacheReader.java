package dev.kyuelin.caching;

public interface ICacheReader {
	public <T extends ICachable> T readCache(String key);

}
