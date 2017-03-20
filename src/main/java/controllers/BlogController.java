package controllers;

import dao.BlogMapper;
import models.Blog;
import models.BlogListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.BlogService;

import java.util.Date;
import java.util.List;

/**
 * Created by wangjin on 17/3/7.
 */

@Controller
@RequestMapping("/")
public class BlogController {

    private BlogService blogService;

    private BlogMapper blogMapper;

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    @ResponseBody
    public Blog getBlog(int id) {
        return blogService.getBlogById(id);
    }

    @RequestMapping(value = "/bloglist",method = RequestMethod.GET)
    @ResponseBody
    public BlogListResponse getBlogList(int page,int pageSize) {
        return blogService.getBlogList(page, pageSize);
    }

    @RequestMapping(value = "/blogcount",method = RequestMethod.GET)
    @ResponseBody
    public int countBlog() {
        return blogMapper.count();
    }

}
