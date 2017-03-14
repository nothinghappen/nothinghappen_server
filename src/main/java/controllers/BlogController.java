package controllers;

import dao.BlogMapper;
import models.Blog;
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
    public List<Blog> getBlogList(int page,int pageSize) {
        return blogService.getBlogList(page, pageSize);
    }

    @RequestMapping(value = "/blogAdminlist",method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getBlogAdminList(int page,int pageSize) {
        int begin = (page - 1) * pageSize;
        return blogMapper.selectAdminList(begin, pageSize);
    }

    @RequestMapping(value = "/blogAdmincount",method = RequestMethod.GET)
    @ResponseBody
    public int countAdminBlog() {
        return blogMapper.adminCount();
    }

    @RequestMapping(value = "/blogcount",method = RequestMethod.GET)
    @ResponseBody
    public int countBlog() {
        return blogMapper.count();
    }

    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    @ResponseBody
    public int saveBlog(@RequestBody Blog b) {
        blogMapper.insert(b);
        System.out.println(b.getId());
        return b.getId();
    }

    @RequestMapping(value = "/blog",method = RequestMethod.PUT)
    @ResponseBody
    public void updateBlog(@RequestBody Blog b) {
        b.setCreateTime(new Date());
        System.out.println(b.getTitle());
        blogMapper.update(b);
    }

    @RequestMapping(value = "/blog",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBlog(@RequestParam int id) {
        blogService.deleteById(id);
    }

}
