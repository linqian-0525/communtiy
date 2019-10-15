package life.majiang.community.mapper;

import life.majiang.community.model.Question;

public interface QuestionExtMapper {
    int inView(Question record);
    int inCommentCount(Question record);
}