package services.ServiceImpl;

import dao.BlogMapper;
import models.Blog;
import models.BlogListResponse;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.BlogService;
import services.TagService;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjin on 17/3/11.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private TagService tagService;


    @Override
    public void deleteById(int id){
        blogMapper.deleteById(id);
    }

    @Override
    public BlogListResponse getBlogList(int page, int pageSize){

        BlogListResponse res = new BlogListResponse();

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
        res.setBloglist(blogs);

        int blogcount = blogMapper.count();
        res.setBlogcount(blogcount);

        return res;
    }

    @Override
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

    @Override
    public BlogListResponse getBlogAdminList(int page, int pageSize) {
        int begin = (page - 1) * pageSize;
        List<Blog> blogs = blogMapper.selectAdminList(begin, pageSize);

        int blogcount = blogMapper.adminCount();

        BlogListResponse res = new BlogListResponse();
        res.setBlogcount(blogcount);
        res.setBloglist(blogs);
        return res;
    }

}
