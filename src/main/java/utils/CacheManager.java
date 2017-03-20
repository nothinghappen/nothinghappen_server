package utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjin on 17/3/11.
 */
public class CacheManager {

    private static Cache<String,Object> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.MINUTES)
            .build();

    public static Object getOrPut(String key,Callable call){
        try {
            return cache.get(key,call);
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

}
