package com.thedustybox.joybuy.member.exception;
/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
public class UserNameExistException extends RuntimeException{

    public UserNameExistException() {
        super("用户名已存在");
    }
}
