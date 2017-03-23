package com.signhor.cms.model.ck;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 重写HashMap的put和get方法，把key转成小写
 */
public class EvideoMap<K,V> extends LinkedHashMap<K,V> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public V put(K key, V value) {
		key = (K) key.toString().toLowerCase();
		return super.put(key, value);
	}

	@Override
	public V remove(Object key) {
		return super.remove(key.toString().toLowerCase());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//key转小写
		Map<K,V> map = new EvideoMap<K,V>();
		Iterator<?> it = m.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
			K key = (K) entry.getKey().toString().toLowerCase();
			V value = (V) entry.getValue();
			map.put(key, value);
		}
		super.putAll(map);
	}

	@Override
	public V get(Object key) {
		return super.get(key.toString().toLowerCase());
	}


}
