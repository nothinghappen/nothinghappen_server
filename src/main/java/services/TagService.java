package services;

import dao.TagMapper;
import models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class TagService {

    private TagMapper tagMapper;

    @Autowired
    public void setTagMapper(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    public void insertTag(Tag tag){
        tagMapper.insert(tag);
    }

    public void deleteTagById(int id){
        tagMapper.deleteById(id);
    }

    public Map<Integer,Tag> getAllTagsMap(){

        Map<Integer,Tag> tagsMap = new HashMap<Integer, Tag>();

        List<Tag> tags = (List<Tag>)CacheManager.getOrAdd("tagsMap", new Callable() {
            @Override
            public Object call() throws Exception {
                return tagMapper.selectAll();
            }
        });

        if (tags == null){
            return tagsMap;
        }
        for(Tag t : tags){
            tagsMap.put(t.getId(),t);
        }
        return tagsMap;
    }

    public List<Tag> getAllTagsByOwnerId(final int id){

        List<Tag> tags = (List<Tag>)CacheManager.getOrAdd("tags", new Callable() {
            @Override
            public Object call() throws Exception {
                return tagMapper.selectAllByOwnerId(id);
            }
        });

        if (tags != null){
            return tags;
        }

        return new ArrayList<Tag>();
    }
}
