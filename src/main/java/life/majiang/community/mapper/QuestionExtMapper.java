package life.majiang.community.mapper;

import life.majiang.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int inView(Question record);
    int inCommentCount(Question record);
    List<Question> selectRelated(Question question);
}