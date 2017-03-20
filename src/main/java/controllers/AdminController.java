package controllers;

import dao.BlogMapper;
import models.Blog;
import models.BlogListResponse;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.BlogService;
import services.TagService;

import java.util.Date;
import java.util.List;

/**
 * Created by wangjin on 17/3/17.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/bloglist",method = RequestMethod.GET)
    @ResponseBody
    public BlogListResponse getBlogAdminList(int page,int pageSize) {
        return blogService.getBlogAdminList(page,pageSize);
    }

    @RequestMapping(value = "/blogcount",method = RequestMethod.GET)
    @ResponseBody
    public int countAdminBlog() {
        return blogMapper.adminCount();
    }

    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    @ResponseBody
    public int saveBlog(@RequestBody Blog b) {
        blogMapper.insert(b);
        //System.out.println(b.getId());
        return b.getId();
    }

    @RequestMapping(value = "/blog",method = RequestMethod.PUT)
    @ResponseBody
    public void updateBlog(@RequestBody Blog b) {
        b.setUpdateTime(new Date());
        //System.out.println(b.getTitle());
        blogMapper.update(b);
    }

    @RequestMapping(value = "/blog",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBlog(@RequestParam int id) {
        blogService.deleteById(id);
    }

    @RequestMapping(value = "/tag",method = RequestMethod.POST)
    @ResponseBody
    public void saveTags(@RequestBody Tag tag) {
        tagService.insertTag(tag);
    }

    @RequestMapping(value = "/tag",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTag(@RequestParam int id) {
        tagService.deleteTagById(id);
    }


}
