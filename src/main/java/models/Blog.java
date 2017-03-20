package models;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangjin on 17/3/7.
 */
public class Blog {

    private int id;

    private String title = "";

    private String author = "";

    private String content = "";

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime = new Date();

    private boolean isPublic = true;

    private String tags = "";

    private List<Tag> tagItems = new ArrayList<Tag>();

    public List<Tag> getTagItems() {
        return tagItems;
    }

    public void setTagItems(List<Tag> tagItems) {
        this.tagItems = tagItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
