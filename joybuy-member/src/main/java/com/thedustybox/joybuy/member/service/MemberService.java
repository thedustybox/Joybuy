package com.thedustybox.joybuy.member.service;

import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.member.entity.MemberEntity;
import com.thedustybox.joybuy.member.exception.PhoneException;
import com.thedustybox.joybuy.member.exception.UsernameException;
import com.thedustybox.joybuy.member.vo.MemberUserLoginVo;
import com.thedustybox.joybuy.member.vo.MemberUserRegisterVo;
import com.thedustybox.joybuy.member.vo.SocialUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 会员
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 * @date 2024-06-09 19:54:45
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void register(MemberUserRegisterVo vo);

    void checkPhoneUnique(String phone) throws PhoneException;

    void checkUserNameUnique(String userName) throws UsernameException;

    MemberEntity login(MemberUserLoginVo vo);


    MemberEntity login(SocialUser socialUser) throws Exception;
}

