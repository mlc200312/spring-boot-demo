package com.springboot.util.collection;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

/**
 * Map操作工具类（升级版）
 * 
 * @author liangchao.min
 *
 */
public class MapUtil<K, V> {

	private Map<K, V> map;

	private MapUtil(Map<K, V> m) {
		super();

		this.map = m;
	}

	public static synchronized MapUtil<String, Object> Builder() {

		return new MapUtil<String, Object>(new HashMap<String, Object>());
	}

	public static synchronized <K, V> MapUtil<K, V> Builder(Map<K, V> m) {

		return new MapUtil<K, V>(m);
	}

	/**
	 * 
	 * @param ex
	 */
	protected static void logInfo(final Exception ex) {
		System.out.println("INFO: Exception: " + ex);
	}

	/**
	 * 添加数据
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public MapUtil<K, V> put(K key, V value) {

		map.put(key, value);

		return this;
	}

	/**
	 * 批量添加数据
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public MapUtil<K, V> putAll(Map<K, V> m) {

		map.putAll(m);

		return this;
	}

	/**
	 * get Object
	 * 
	 * @param key
	 * @return
	 */
	public Object getObject(final K key) {

		return MapUtils.getObject(map, key);
	}

	/**
	 * get String
	 * 
	 * @param key
	 * @return
	 */
	public String getString(final K key) {

		return MapUtils.getString(map, key);
	}

	/**
	 * get Boolean
	 * 
	 * @param key
	 * @return
	 */
	public Boolean getBoolean(final K key) {

		return MapUtils.getBoolean(map, key);
	}

	/**
	 * get Number
	 * 
	 * @param key
	 * @return
	 */
	public Number getNumber(final K key) {

		return MapUtils.getNumber(map, key);
	}

	/**
	 * get Byte
	 * 
	 * @param key
	 * @return
	 */
	public Byte getByte(final K key) {

		return MapUtils.getByte(map, key);
	}

	/**
	 * get Short
	 * 
	 * @param key
	 * @return
	 */
	public Short getShort(final K key) {

		return MapUtils.getShort(map, key);
	}

	/**
	 * get Integer
	 * 
	 * @param key
	 * @return
	 */
	public Integer getInteger(final K key) {

		return MapUtils.getInteger(map, key);
	}

	/**
	 * get Long
	 * 
	 * @param key
	 * @return
	 */
	public Long getLong(final K key) {

		return MapUtils.getLong(map, key);
	}

	/**
	 * get Float
	 * 
	 * @param key
	 * @return
	 */
	public Float getFloat(final K key) {

		return MapUtils.getFloat(map, key);
	}

	/**
	 * get Double
	 * 
	 * @param key
	 * @return
	 */
	public Double getDouble(final K key) {

		return MapUtils.getDouble(map, key);
	}

	/**
	 * get Map
	 * 
	 * @param key
	 * @return
	 */
	public Map<?, ?> getMap(final K key) {

		return MapUtils.getMap(map, key);
	}

	/**
	 * 取数据
	 * 
	 * @return
	 */
	public Map<K, V> getMap() {

		System.out.println("loggerInfo:{map : " + map.toString() + "}");

		return map;
	}

	/**
	 * 移除
	 * 
	 * @param key
	 * @return
	 */
	public MapUtil<K, V> remove(K key) {

		map.remove(key);

		return this;
	}

	/**
	 * 移除
	 * 
	 * @param keys
	 * @return
	 */
	public MapUtil<K, V> remove(@SuppressWarnings("unchecked") K... keys) {

		for (K key : keys) {
			map.remove(key);
		}
		return this;
	}

	/**
	 * 清空数据
	 * 
	 * @return
	 */
	public MapUtil<K, V> clear() {

		map.clear();

		return this;
	}
}
