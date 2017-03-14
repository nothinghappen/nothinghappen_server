package controllers;


import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.TagService;

import java.util.List;

/**
 * Created by wangjin on 17/3/11.
 */

@Controller
@RequestMapping("/")
public class TagController {

    private TagService tagService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/tag",method = RequestMethod.GET)
    @ResponseBody
    public List<Tag> getTags(@RequestParam int id) {
        return tagService.getAllTagsByOwnerId(id);
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
