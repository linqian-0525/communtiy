package life.majiang.community.mapper;

import life.majiang.community.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuesstionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag)values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    public void create(Quesstion quesstion);
    @Select("select * from question limit #{offset},#{size}")
    List<Quesstion> list(Integer offset, Integer size);
}

