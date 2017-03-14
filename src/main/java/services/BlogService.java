package services;

import dao.BlogMapper;
import models.Blog;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.CacheManager;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjin on 17/3/11.
 */
@Service
public class BlogService {

    private BlogMapper blogMapper;

    private TagService tagService;

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public void deleteById(int id){
        blogMapper.deleteById(id);
    }

    public List<Blog> getBlogList(int page,int pageSize){
        int begin = (page - 1) * pageSize;
        List<Blog> blogs = blogMapper.selectList(begin, pageSize);
        for(Blog b : blogs){
            if (b.getTags().equals(""))
                continue;
            String[] tagIds = b.getTags().split(",");
            Map<Integer, Tag> tagMap = tagService.getAllTagsMap();
            for (String s : tagIds) {
                Integer i = Integer.valueOf(s);
                Tag t = tagMap.get(i);
                if(t != null)
                    b.getTagItems().add(t);
            }
        }
        return blogs;
    }

    public Blog getBlogById(int id){
        Blog b = blogMapper.selectById(id);
        if (b.getTags().equals(""))
            return b;

        String[] tagIds = b.getTags().split(",");
        Map<Integer, Tag> tagMap = tagService.getAllTagsMap();
        for (String s : tagIds) {
            Integer i = Integer.valueOf(s);
            Tag t = tagMap.get(i);
            if (t != null)
                b.getTagItems().add(t);
        }
        return b;
    }

}
