package life.majiang.community.dto;

import lombok.Data;

@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long  notifier;
    private String notificationName;
    private String outerTitle;
    private Long outerid;
    private Integer type;
    private String typeName;
}
