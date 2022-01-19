package dev.kyuelin.caching;

import java.io.Serializable;

public interface ICachableKey extends Serializable {
	public String generateKey();
}
