package com.thedustybox.joybuy.member.exception;

/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
public class PhoneException extends RuntimeException {

    public PhoneException() {
        super("存在相同的手机号");
    }
}
