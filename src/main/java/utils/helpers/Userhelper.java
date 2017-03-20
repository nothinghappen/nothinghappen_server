package utils.helpers;

import models.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by wangjin on 17/3/17.
 */

@Component
public class Userhelper {

    @Cacheable(value = "UserCache",key = "#uuid")
    public User getUserByToken(String uuid){
        //进入方法说明没有缓存
        return null;
    }

    @CachePut(value = "UserCache",key = "#uuid")
    public User putToken(User user,String uuid){
        return user;
    }
}
