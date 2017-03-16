package com.springapp.mvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import services.TagService;

/**
 * Created by wangjin on 17/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class TagServiceTest {

    @Autowired
    public TagService tagService;

    @Test
    public void getTagsTest(){
        for (int i = 0;i<10;i++) {
            tagService.getAllTagsByOwnerId(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
