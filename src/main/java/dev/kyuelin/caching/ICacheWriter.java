package dev.kyuelin.caching;

public interface ICacheWriter {
	boolean add(String key, ICachable value);
	<T extends ICachable> T set(String key, ICachable value);
}
