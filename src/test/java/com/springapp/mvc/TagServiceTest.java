package com.springapp.mvc;
import models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.TagService;
import services.UserService;

/**
 * Created by wangjin on 17/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class TagServiceTest {

    @Autowired
    public TagService tagService;

    @Autowired
    public UserService userService;

    @Test
    public void test(){
//
    }

}
