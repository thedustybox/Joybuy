package com.thedustybox.joybuy.member.exception;
/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
public class UsernameException extends RuntimeException {


    public UsernameException() {
        super("存在相同的用户名");
    }
}
