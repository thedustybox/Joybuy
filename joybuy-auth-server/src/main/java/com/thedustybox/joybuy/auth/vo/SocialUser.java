package com.thedustybox.joybuy.auth.vo;

import lombok.Data;

/**
 *
 * @author thedustybox
 */
@Data
public class SocialUser {
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}
