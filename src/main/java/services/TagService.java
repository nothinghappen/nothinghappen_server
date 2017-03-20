package services;

import dao.TagMapper;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjin on 17/3/17.
 */
public interface TagService {

    @CacheEvict(value = "TagCache",key = "'tagOwner'+#tag.ownerId")
    void insertTag(Tag tag);

    //清空所有关于tag的缓存
    @CacheEvict(value = "TagCache",allEntries = true)
    void deleteTagById(int id);

    @Cacheable(value = "TagCache",key="'tagsmap'")
    Map<Integer,Tag> getAllTagsMap();

    @Cacheable(value = "TagCache",key = "'tagOwner'+#id")
    List<Tag> getAllTagsByOwnerId(int id);
}
