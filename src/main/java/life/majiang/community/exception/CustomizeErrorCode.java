package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
     QUESTION_NOT_FOUND(2001,"你找的问题不在了，换一个看看吧"),
     TARGET_PARAM_NOT_NOT_FOUND(2002,"未选中任何问题或者评论"),
    NO_LOGIN(2003,"当前操作需要重新登录，请登录后重试"),
    SYSTEM_ERROR(2004,"服务器太热了，等一等在试试看吧"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"你找到的评论不存在了" ),
    COMMENT_IS_EMPTY(2007,"输入的内容不能够为空" );
    private String message;
    private Integer code;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    CustomizeErrorCode(Integer code,String message){
        this.message=message;
        this.code = code;
    }
}
