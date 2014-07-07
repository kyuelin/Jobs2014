package dev.kyuelin.caching;

public interface ICacheWriter {
	public boolean add(String key, ICachable value);
	public <T extends ICachable> T set(String key, ICachable value);
}
