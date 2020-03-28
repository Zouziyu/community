package life.majiang.community.mapper;

import com.github.pagehelper.Page;
import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Select("select * from question")
    Page<Question> list();

    @Insert("Insert into question(title,description,gmt_create,gmt_modified,creator,tag) VALUES(#{title},#{description},#{gmt_Create},#{gmt_Modified},#{creator},#{tag})")
    void create(Question question);

    @Select("Select count(*) from question")
    Integer getTotalNum();
}
