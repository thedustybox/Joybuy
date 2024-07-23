package com.thedustybox.joybuy.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.member.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 * @date 2024-06-09 19:54:45
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

