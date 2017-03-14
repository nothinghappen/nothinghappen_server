package dao;

import models.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjin on 17/3/11.
 */
public interface TagMapper {

    int insert(Tag tag);

    List<Tag> selectAllByOwnerId(int id);

    List<Tag> selectAll();

    void deleteById(int id);
}
