package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
     QUESTION_NOT_FOUND("你找的问题不在了，换一个看看吧");
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    CustomizeErrorCode(String message){
        this.message=message;
    }
}
