package life.majiang.community.mapper;

import life.majiang.community.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuesstionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag)values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
     void create(Quesstion quesstion);
    @Select("select * from question limit #{offset},#{size}")
    List<Quesstion> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question")
    Integer count();
    @Select("select * from question where creator=#{userId} limit #{offset},#{size}")
    List<Quesstion> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset,@Param(value = "size") Integer size);
    @Select("select count(1) from question  where creator=#{userId}")
    Integer countByUserId(@Param(value = "userId")Integer userId);

    @Select("select * from question id=#{id}")
    Quesstion getById(@Param(value = "id") Integer id);
}

