package life.majiang.community.dto;

import lombok.Data;

/**
 * 传递的参数类
 */

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
