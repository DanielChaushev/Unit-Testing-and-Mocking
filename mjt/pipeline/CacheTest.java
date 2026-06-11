package bg.sofia.uni.fmi.mjt.pipeline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {


    @Test
    void testCacheValueNullKeyThrowsIllegalArgumentException() {
        Cache cache = new Cache();
        assertThrows(IllegalArgumentException.class, () -> cache.cacheValue(null, "value"), "Key is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testCacheValueNullValueThrowsIllegalArgumentException() {
        Cache cache = new Cache();
        assertThrows(IllegalArgumentException.class, () -> cache.cacheValue("key", null), "Value is null and IllegalArgumentException must be thrown!");
    }
    @Test
    void testCacheValueOverrideValue(){
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        cache.cacheValue("key1","value2");
        assertEquals("value2", cache.getCachedValue("key1"));
    }

    @Test
    void testGetCachedValue() {
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertEquals("value1", cache.getCachedValue("key1"));
    }
    @Test
    void testGetCachedValueNonExistantKey() {
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertNull(cache.getCachedValue("key2"));
    }

    @Test
    void testGetCachedValueNullKeyThrowsIllegalArgumentException() {
        Cache cache = new Cache();
        assertThrows(IllegalArgumentException.class, () -> cache.getCachedValue(null), "Key is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testContainsKey() {
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertTrue(cache.containsKey("key1"));
    }
    @Test
    void testContainsKeyNonExistingKey() {
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertFalse(cache.containsKey("asdascasdc"));
    }

    @Test
    void testContainsKeyNullKeyThrowsIllegalArgumentException() {
        Cache cache = new Cache();
        assertThrows(IllegalArgumentException.class, () -> cache.containsKey(null), "Key is null and IllegalArgumentException must be thrown!");
    }
    @Test
    void testClear(){
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        cache.clear();
        assertTrue(cache.isEmpty());
    }
    @Test
    void testIsEmptyNotActuallyEmpty(){
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertFalse(cache.isEmpty());
    }
    @Test
    void testIsEmpty(){
        Cache cache = new Cache();
        assertTrue(cache.isEmpty());
    }
}
