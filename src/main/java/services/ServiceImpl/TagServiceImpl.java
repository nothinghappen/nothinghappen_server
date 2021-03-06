package services.ServiceImpl;

import dao.TagMapper;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import services.TagService;
import utils.CacheManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by wangjin on 17/3/11.
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    @CacheEvict(value = "TagCache",key = "'tagOwner'+#tag.ownerId")
    public void insertTag(Tag tag){
        tagMapper.insert(tag);
    }

    //清空所有关于tag的缓存
    @Override
    @CacheEvict(value = "TagCache",allEntries = true)
    public void deleteTagById(int id){
        tagMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = "TagCache",key="'tagsmap'")
    public Map<Integer,Tag> getAllTagsMap(){
        Map<Integer,Tag> tagsMap = new HashMap<Integer, Tag>();
        List<Tag> tags = tagMapper.selectAll();
        for(Tag t : tags){
            tagsMap.put(t.getId(),t);
        }
        return tagsMap;
    }

    @Override
    @Cacheable(value = "TagCache",key = "'tagOwner'+#id")
    public List<Tag> getAllTagsByOwnerId(int id){
        return tagMapper.selectAllByOwnerId(id);
    }
}
