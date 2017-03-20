package services;

import dao.BlogMapper;
import models.Blog;
import models.BlogListResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangjin on 17/3/17.
 */
public interface BlogService {

    void deleteById(int id);

    BlogListResponse getBlogList(int page, int pageSize);

    Blog getBlogById(int id);

    BlogListResponse getBlogAdminList(int page, int pageSize);
}
