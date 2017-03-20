package services.ServiceImpl;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import services.UserService;
import utils.helpers.Userhelper;

import java.util.UUID;

/**
 * Created by wangjin on 17/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userhelper userhelper;

    @Override
    public String login(User user){
        if (!user.getUsername().equals("nothinghappen") || !user.getPassword().equals("tomcat"))
            return "";
        String uuid = UUID.randomUUID().toString();
        user.setId(1);
        userhelper.putToken(user,uuid);
        return uuid;
    }
}
