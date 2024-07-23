package com.thedustybox.joybuy.member.vo;

import lombok.Data;
/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
@Data
public class SocialUser {

    private String access_token;

    private String remind_in;

    private long expires_in;

    private String uid;

    private String isRealName;

}
