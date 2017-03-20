package models;

import java.util.List;

/**
 * Created by wangjin on 17/3/11.
 */
public class BlogListResponse {

    private int blogcount;

    private List<Blog> bloglist;

    public int getBlogcount() {
        return blogcount;
    }

    public void setBlogcount(int blogcount) {
        this.blogcount = blogcount;
    }

    public List<Blog> getBloglist() {
        return bloglist;
    }

    public void setBloglist(List<Blog> bloglist) {
        this.bloglist = bloglist;
    }
}
