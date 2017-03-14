package dao;

import models.Blog;

import java.util.List;

/**
 * Created by wangjin on 17/3/9.
 */
public interface BlogMapper {

    int insert(Blog blog);

    void update(Blog blog);

    Blog selectById(int id);

    List<Blog> selectList(int page,int pageSize);

    List<Blog> selectAdminList(int page,int pageSize);

    void deleteById(int id);

    int count();

    int adminCount();

}
