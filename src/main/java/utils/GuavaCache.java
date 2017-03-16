package utils;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjin on 17/3/15.
 */
public class GuavaCache implements Cache{

    private String name = "";

    private final com.google.common.cache.Cache<Object,Object> cache;

    public GuavaCache(String name,int expired,TimeUnit unit){
        this.name = name;
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expired, unit)
                .build();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.cache;
    }

    @Override
    public ValueWrapper get(Object key) {
        //System.out.println("get");
        Object value = cache.getIfPresent(key);
        return toValueWrapper(value);
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        //System.out.println("get2");
        Object value = cache.getIfPresent(key);
        if (value != null && type != null && !type.isInstance(value)) {
            throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
        }
        return (T) value;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader){
        //System.out.println("get3");
        T value = null;
        try {
            value = (T)cache.get(key,valueLoader);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        //System.out.println("put");
        this.cache.put(key,value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, final Object value) {
        //System.out.println("putifabsent");
        try {
            PutIfAbsentCallable callable = new PutIfAbsentCallable(value);
            Object result = this.cache.get(key, callable);
            return (callable.called ? null : toValueWrapper(result));
        }
        catch (ExecutionException ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public void evict(Object key) {
        cache.invalidate(key);
    }

    @Override
    public void clear() {
        cache.invalidateAll();
    }

    private ValueWrapper toValueWrapper(Object value){
        return value == null ? null : new SimpleValueWrapper(value);
    }

    private class PutIfAbsentCallable implements Callable<Object> {

        private final Object value;

        private boolean called;

        public PutIfAbsentCallable(Object value) {
            this.value = value;
        }

        @Override
        public Object call() throws Exception {
            this.called = true;
            return this.value;
        }
    }
}
